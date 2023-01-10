package com.kakao.bootjpa.persistence;

import com.kakao.bootjpa.domain.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    //mno 의 값이 from 부터 to 사이인 데이터 조회 메서드
    List<Memo> findByMnoBetween(Long from, Long to);

    // mno 값이 from 부터 to 사이인 데이터를 mno 내림차순 정렬해 조회
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
    // 페이징 조회
    Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);

    void deleteByMnoLessThan(Long num);
    
    // mno 와 memoText를 매개변수로 받아서 수정하는 메서드
    @Transactional
    @Modifying
    // native sql이 아니기 때문에 Table 이름이 아닌
    //Entity 클래스 이름 작성xW
    @Query("update Memo m set m.memoText = :memoText where m.mno = :mno")
    public int updateMemoText(@Param("mno") int mno,
                              @Param("memoText") String memoText);
    @Query("update Memo m set m.memoText = :#{#param.memoText} where m.mno = :#{#param.mno}")
    public int updateMemoText(@Param("param") Memo memo);

    @Query("select m from Memo m where m.mno > :mno")
    Page <Memo> getListWithQuery(@Param("mno") Long mno, Pageable pageable);

    @Query("select m.mno, m.memoText, CURRENT_DATE from Memo m where m.mno > :mno")
    Page<Object []> getObjectWithQuery(@Param("mno") Long mon, Pageable pageable);
}
