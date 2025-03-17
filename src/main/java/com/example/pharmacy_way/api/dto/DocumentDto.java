package com.example.pharmacy_way.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Kakao API 응답에서 'documents' 객체의 데이터를 매핑하는 DTO 클래스
 *
 * - Kakao 주소 검색 API 응답에서 각 주소 정보를 담는 객체
 * - JSON 응답을 Java 객체로 변환할 때 사용
 */
@Getter // Lombok 제공: 필드의 Getter 메서드를 자동으로 생성
@AllArgsConstructor // Lombok 제공: 모든 필드를 포함하는 생성자를 자동으로 생성
@NoArgsConstructor  // Lombok 제공: 기본 생성자(파라미터 없는 생성자)를 자동으로 생성
public class DocumentDto {

    /**
     * 주소 문자열
     */
    @JsonProperty("address_name") // JSON 응답 필드 "address_name"을 Java 필드 addressName에 매핑
    private String addressName;

    /**
     * 위도 (Latitude)
     */
    @JsonProperty("y") // JSON 응답 필드 "y"를 Java 필드 latitude에 매핑
    private double latitude;

    /**
     * 경도 (Longitude)
     */
    @JsonProperty("x") // JSON 응답 필드 "x"를 Java 필드 longitude에 매핑
    private double longitude;
}
