package com.example.pharmacy_way.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Kakao API 응답 데이터를 매핑하는 DTO 클래스
 *
 * - Kakao 지도 API의 응답(JSON) 데이터를 Java 객체로 변환하는 역할
 * - `meta`와 `documents` 필드를 포함하여 API 응답을 구조화된 데이터로 매핑
 */

@Getter // Lombok 제공: 모든 필드의 Getter 메서드를 자동 생성
@AllArgsConstructor // Lombok 제공: 모든 필드를 매개변수로 받는 생성자 자동 생성
@NoArgsConstructor  // Lombok 제공: 기본 생성자(매개변수 없는 생성자) 자동 생성
public class KakaoApiResponseDto {

    /**
     * 검색 결과의 메타데이터 (예: 전체 검색 결과 개수, 페이지 정보 등)
     */
    @JsonProperty("meta") // JSON 응답 필드 "meta"를 Java 필드 metaDto에 매핑
    private MetaDto metaDto;

    /**
     * 검색 결과 목록 (주소 데이터 리스트)
     */
    @JsonProperty("documents") // JSON 응답 필드 "documents"를 Java 필드 documentList에 매핑
    private List<DocumentDto> documentList;
}