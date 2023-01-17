package com.kakao.review.persistence;

import com.kakao.review.domain.Member;
import com.kakao.review.domain.Movie;
import com.kakao.review.domain.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // 테이블 전체 데이터 가져오기 -Paging 가능
    // 기본키 가지고 데이터 1개 가져오기
    // 데이터 삽입 과 수정(기본키를 조건)에 사용되는 메서드 제공
    // 기본키 가지고 삭제하는 메서드 와 entity 로 삭제
    
    // 이름 기반으로 메서드 생성 가능
    @EntityGraph(attributePaths = {"member"},
    type= EntityGraph.EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);
    // 회원 정보 삭제
    void deleteByMember(Member member);

    // JPQL 이용해 쿼리 작성 가능(Join 시 사용)
    @Modifying
    @Query("update Review r set r.member.mid=null where r.member.mid=:mid")
    void updatebyMember(@Param("mid") Long mid);

    // Querydsl 이용해 쿼리 작성 가능(동적쿼리 시 사용)
}
