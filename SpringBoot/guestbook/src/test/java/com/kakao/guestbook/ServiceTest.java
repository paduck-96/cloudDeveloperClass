package com.kakao.guestbook;

import com.kakao.guestbook.domain.GuestBook;
import com.kakao.guestbook.dto.GuestBookDTO;
import com.kakao.guestbook.dto.PageRequestDTO;
import com.kakao.guestbook.dto.PageResponseDTO;
import com.kakao.guestbook.service.GuestBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private GuestBookService guestBookService;

    @Test
    public void testRegister(){
        GuestBookDTO dto = GuestBookDTO.builder()
                .title("샘플 제목")
                .content("샘플 내용")
                .writer("군계")
                .build();
        System.out.println(guestBookService.register(dto));
    }

    @Test
    public void testList(){
        //1페이지 10개
        PageRequestDTO pageRequestDTO =
                PageRequestDTO.builder()
                        .page(1)
                        .size(10)
                        .build();
        PageResponseDTO <GuestBookDTO, GuestBook> result =
                guestBookService.getList(pageRequestDTO);
        for(GuestBookDTO dto : result.getDtoList()){
            System.out.println(dto);
        }
    }

    @Test
    public void testListInformation(){
        PageRequestDTO pageRequestDTO =
                PageRequestDTO.builder()
                        .page(19)
                        .size(10)
                        .build();
        PageResponseDTO<GuestBookDTO, GuestBook> result =
                guestBookService.getList(pageRequestDTO);
        //데이터 확인
        //데이터 목록
        System.out.println(result.getDtoList());
        //페이지 목록
        System.out.println(result.getPageList());
        //전체 페이지 개수
        System.out.println(result.getTotalPage());
        //이전 여부
        System.out.println(result.isPrev());
        //다음 여부
        System.out.println(result.isNext());
    }
}
