package com.example.pharmacy_way.api.dto; // DTO 클래스가 속한 패키지

import com.fasterxml.jackson.annotation.JsonProperty; // JSON 필드 이름을 자바 필드에 매핑해주는 어노테이션
import lombok.AllArgsConstructor; // 모든 필드를 인자로 받는 생성자를 자동 생성
import lombok.Getter; // 필드에 대한 Getter 메서드를 자동 생성
import lombok.NoArgsConstructor; // 파라미터 없는 기본 생성자를 자동 생성 (JSON 역직렬화 등에 필요)

@Getter // totalCount 필드의 Getter 메서드를 생성 (ex: getTotalCount())
@AllArgsConstructor // 전체 필드를 초기화하는 생성자 생성
@NoArgsConstructor // 기본 생성자 생성
public class MetaDto { // JSON 응답의 "meta" 필드를 매핑하는 DTO 클래스

    @JsonProperty("total_count") // JSON의 "total_count" 키를 totalCount 필드에 매핑
    private Integer totalCount; // 전체 검색 결과 수를 저장하는 필드
}