package com.kakao.board.persistence;

import com.kakao.board.domain.Board;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface SearchBoardRepository {
    Board search1();
    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
