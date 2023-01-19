package com.kakao.board;

import com.kakao.board.dto.BoardDTO;
import com.kakao.board.dto.PageRequestDTO;
import com.kakao.board.dto.PageResponseDTO;
import com.kakao.board.dto.ReplyDTO;
import com.kakao.board.service.BoardService;
import com.kakao.board.service.ReplyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private BoardService boardService;

    //등록 테스트
    @Test
    public void registerTest(){
        BoardDTO dto = BoardDTO.builder()
                .title("등록 테스트")
                .content("등록을 테스트합니다.")
                .writerEmail("user33@kakao.com")
                .build();
        Long bno = boardService.register(dto);
        System.out.println(bno);
    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO =
                new PageRequestDTO();
        PageResponseDTO<BoardDTO, Object []> result =
                boardService.getList(pageRequestDTO);
        System.out.println(result);
    }

    @Test
    public void testGet(){
        Long bno = 100L;
        BoardDTO boardDTO = boardService.get(bno);
        System.out.println(boardDTO);
    }

    @Test
    public void testDelete(){
        boardService.removeWithReplies(99L);
    }

    @Test
    public void testUpdate(){
        BoardDTO dto = BoardDTO.builder()
                .bno(99L)
                .title("제목 변경")
                .content("내용 변경")
                .build();
        System.out.println(boardService.modify(dto));
    }

    @Autowired
    ReplyService replyService;

    @Test
    public void testGetList(){
        //게시글 번호를 이용해서 댓글 가져오기
        List<ReplyDTO> list = replyService.getList(27L);
        list.forEach(dto -> System.out.println(dto));
    }

    @Test
    public void insertReply(){
        ReplyDTO dto = ReplyDTO.builder()
                .text("댓글 삽입 테스트")
                .replyer("user1@kakao.com")
                .bno(27L)
                .build();
        System.out.println(replyService.register(dto));
    }
}
