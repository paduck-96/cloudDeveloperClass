package com.kakao.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@AllArgsConstructor
public class UploadResultDTO implements Serializable {
    // Serializable(직렬화)
    //데이터 전송 시 객체 단위로 전송하게 해주는 인터페이스
    private String fileName;
    private String uuid;
    private String uploadPath;

    // 실제 이미지 경로 리턴
    public String getImageURL(){
        try{
            return URLEncoder.encode(uploadPath+"/"+uuid+fileName, "UTF-8");
        }catch(UnsupportedEncodingException e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return "";
    }

    public String getThumbnailURL(){
        try{
            return URLEncoder.encode(uploadPath+"/s_"+uuid+fileName, "UTF-8");
        }catch(UnsupportedEncodingException e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return "";
    }
}
