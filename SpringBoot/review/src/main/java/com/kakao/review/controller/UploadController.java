package com.kakao.review.controller;

import com.kakao.review.dto.UploadResultDTO;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
public class UploadController {
    @Value("${com.kakao.review.upload.path}")
    private String uploadPath;
    
    // 날짜 별로 디렉토리 생성 메서드
    private String makeFolder(){
        // 오늘 날짜로 된 디렉토리 경로 생성
        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String realUploadPath = str.replace("//", File.separator);
        File uploadPathDir = new File(uploadPath, realUploadPath);
        // 디렉토리 없으면 생성
        if(uploadPathDir.exists() == false){
            uploadPathDir.mkdirs();
        }
        return realUploadPath;
    }
    @PostMapping("/uploadajax")
    public ResponseEntity<List<UploadResultDTO>> uploadFile(MultipartFile [] uploadFiles){
        // 결과 전달 객체 생성
        List<UploadResultDTO> resultDTOList = new ArrayList<>();
        for(MultipartFile uploadFile : uploadFiles){
            if(uploadFile.getContentType().startsWith("image")==false){
                log.warn("이미지 파일이 아닙니다");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            // 업로드 된 파일 이름
            String originalName = uploadFile.getOriginalFilename();
            // IE는 파일 이름이 아니고 전체 경로를 전송하기 떄문에
            //마지막 \ 뒤 부분만 추출해야 함
            String fileName = originalName.substring(originalName.lastIndexOf("\\")+1);
            log.warn("fileName: " + fileName);

            //디렉토리 생성
            String realUploadPath = makeFolder();

            //UUId 생성
            String uuid = UUID.randomUUID().toString();
            // 실제 파일 저장 경로
            String saveName = uploadPath + File.separator
                    +realUploadPath+File.separator+uuid+fileName;
            File saveFile = new File(saveName);
            try{
                uploadFile.transferTo(saveFile);
                // 썸네일 파일 이름 생성
                File thumbnailFile = new File(uploadPath +
                        File.separator + realUploadPath +
                        File.separator + "s_" + uuid + fileName);
                //썸네일 생성
                Thumbnailator.createThumbnail(saveFile, thumbnailFile, 50, 50);

                // 결과를 List에 추가
                resultDTOList.add(new UploadResultDTO(
                        fileName, uuid, realUploadPath
                ));
            }catch(IOException e){
                System.out.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
    }

    @GetMapping("/display")
    public ResponseEntity<byte []> getFile(String filename){
        ResponseEntity<byte[]> result = null;
try{
    log.warn("파일 이름: " + filename);
    // 전송 파일 생성
    File file = new File(uploadPath + File.separator + URLDecoder.decode(filename, "UTF-8"));
    // 헤더 파일이라는 사실 설정
    HttpHeaders header = new HttpHeaders();
    header.add("Content-type", Files.probeContentType(file.toPath()));
    // 파일 내용 응답의 결과로 생성
    result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
}catch(Exception e){
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
        return result;
    }

    @PostMapping("/removefile")
    public ResponseEntity<Boolean> removeFile(String fileName){
        try{
            // 원래 파일 이름 만들기
            String srcFileName = URLDecoder.decode(fileName,"UTF-8");
            // 원본 이미지 파일 생성
            File file = new File(uploadPath + File.separator + srcFileName);
            file.delete();
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            return new ResponseEntity<>(
                    false, HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
}