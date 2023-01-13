package com.kakao.board.service;

import com.kakao.board.board.ReplyDTO;
import com.kakao.board.domain.Board;
import com.kakao.board.domain.Reply;

import java.util.List;

public interface ReplyService {
    // 댓글 등록
    Long register(ReplyDTO replyDTO);
    // 댓글 목록
    List<ReplyDTO> getList(Long bno);
    // 댓글 수정
    Long modify(ReplyDTO replyDTO);
    // 댓글 삭제
    Long remove(Long rno);

    //ReplyDTO 를 Entity 로 변환
    default Reply dtoToEntity(ReplyDTO dto){
        Board board = Board.builder().bno(dto.getBno()).build();
        Reply reply = Reply.builder().text(dto.getText()).replyer(dto.getReplyer()).board(board).build();
        return reply;
    }
    //ReplyEntity 를 DTO로 변환
    default ReplyDTO entityToDTO(Reply reply){
        ReplyDTO dto = ReplyDTO.builder()
                .rno(reply.getRno())
                .text(reply.getText())
                .replyer(reply.getReplyer())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();
        return dto;
    }
}
