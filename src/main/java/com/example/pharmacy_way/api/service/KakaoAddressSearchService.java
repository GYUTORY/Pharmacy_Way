package com.example.pharmacy_way.api.service;

import com.example.pharmacy_way.api.dto.KakaoApiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * 카카오 주소 검색 API를 호출하는 서비스 클래스
 */
@Slf4j // Lombok 제공: Logger 객체를 자동으로 생성하여 log.info(), log.error() 등을 사용할 수 있음.
@Service // 해당 클래스가 Spring의 서비스 레이어 컴포넌트임을 나타냄 (Spring의 Bean으로 등록됨)
@RequiredArgsConstructor // Lombok 제공: final이 붙은 필드를 생성자로 자동 주입
public class KakaoAddressSearchService {

    // RestTemplate을 이용하여 외부 API와 통신
    private final RestTemplate restTemplate;

    // Kakao API 호출에 필요한 URI를 생성하는 서비스
    private final KakaoUriBuilderService kakaoUriBuilderService;

    // application.properties 또는 application.yml에 설정된 Kakao REST API 키 값을 주입
    @Value("${kakao.rest.api.key}")
    private String kakaoRestApiKey;

    /**
     * 주소 검색 API 요청 메서드
     *
     * @param address 검색할 주소 문자열
     * @return KakaoApiResponseDto (API 응답 데이터)
     */
    public KakaoApiResponseDto requestAddressSearch(String address) {

        // 주소 값이 비어있는지 확인하고, 비어있다면 null 반환 (API 호출 불필요)
        if (ObjectUtils.isEmpty(address)) {
            log.warn("주소가 비어 있어 API 요청을 중단합니다.");
            return null;
        }

        // 주소를 기반으로 Kakao API 요청을 위한 URI 생성
        URI uri = kakaoUriBuilderService.buildUriByAddressSearch(address);

        // HTTP 요청 헤더 설정 (Kakao API의 인증키 필요)
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + kakaoRestApiKey); // Authorization 헤더 설정 (오타 수정)

        // HTTP 요청 객체 생성 (헤더 포함)
        HttpEntity<Void> httpEntity = new HttpEntity<>(headers);

        // Kakao API 호출 및 응답 반환
        try {
            return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, KakaoApiResponseDto.class).getBody();
        } catch (Exception e) {
            log.error("Kakao 주소 검색 API 호출 중 오류 발생: {}", e.getMessage());
            return null;
        }
    }
}
