package com.example.pharmacy_way.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Kakao API의 주소 검색을 위한 URI를 생성하는 서비스 클래스
 */
@Slf4j // Lombok 제공: Logger 객체를 자동으로 생성하여 log.info(), log.error() 등을 사용할 수 있음
@Service // 해당 클래스가 Spring의 서비스 레이어의 Bean으로 등록됨
public class KakaoUriBuilderService {

    // Kakao 주소 검색 API의 기본 URL (변경 가능성이 없으므로 static final로 선언)
    private static final String KAKAO_LOCAL_SEARCH_ADDRESS_URL = "https://dapi.kakao.com/v2/local/search/address.json";

    /**
     * 사용자가 입력한 주소를 기반으로 Kakao API 요청을 위한 URI를 생성
     *
     * @param address 검색할 주소 문자열
     * @return Kakao API 요청을 위한 URI 객체
     */
    public URI buildUriByAddressSearch(String address) {
        // UriComponentsBuilder를 사용하여 GET 요청에 필요한 URL을 동적으로 생성
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(KAKAO_LOCAL_SEARCH_ADDRESS_URL)
                .queryParam("query", address); // "query" 파라미터에 검색할 주소 추가

        // URI 객체 생성 (encode()를 사용하여 URL 인코딩 처리)
        URI uri = uriBuilder.build().encode().toUri();

        // 로깅 추가 (주소 및 생성된 URI 출력)
        log.info("[KakaoUriBuilderService buildUriByAddressSearch] address: {}, uri: {}", address, uri);

        // URI 반환
        return uri;
    }
}
