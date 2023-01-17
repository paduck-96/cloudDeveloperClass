package com.kakao.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
    private Long mno;
    private String title;
    // builder() 를 통해 생성시 기본으로 사용
    @Builder.Default
    private List<MovieImageDTO> imageDTOList = new ArrayList<>();
}
