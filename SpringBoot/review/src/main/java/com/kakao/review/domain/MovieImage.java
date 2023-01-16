package com.kakao.review.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude="movie") //toString 시 movie 제외
//지연생성이기 때문에 get을 하지 않은 상태에서 toString 호출시 
//NullpointExcepiton 발생
@Embeddable //부모테이블 만들 때 이 속성 값 포함해 생성
public class MovieImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inum;

    private String uuid; // 파일 이름 겹치지 않기 위해 추가
    private String imgName; //파일 이름
    private String path; //하나의 디렉토리에 너무 많은 파일 저장되지 않도록
    //업로드 한 날짜 별로 파악되게 디렉토리 생성(~ 몇 만 개 정도)



    // 하나의 영화에 여러 개의 영화 이미지
    //데이터 불러올 떄 movie를 불러오지 않고 사용할 때 불러오게 설정
    //따로 설정값 없을 경우 외래키의 이름은 movie_mno
    @ManyToOne(fetch= FetchType.LAZY) // (내 테이블에서)To(다른 테이블이 어떻게 가지쳐지는지)
    private Movie movie;
}
