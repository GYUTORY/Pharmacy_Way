package com.example.pharmacy_way.api.service;

import com.example.pharmacy_way.api.dto.KakaoApiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http;
import java.net.http.HttpHeaders;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoAddressSearchService {


    private final RestTemplate restTemplate;
    private final KakaoUriBuilderService kakaoUriBuilderService;


    // todo Check Need
    public KakaoAddressSearchService(RestTemplate restTemplate, KakaoUriBuilderService kakaoUriBuilderService) {
        this.restTemplate = restTemplate;
        this.kakaoUriBuilderService = kakaoUriBuilderService;
    }

    @Value("${kakao.rest.api.key}")
    private String kakaoRestApiKey;

    public KakaoApiResponseDto requestAddressSearch(String address) {

        if(ObjectUtils.isEmpty(address)) return null;

        URI uri = kakaoUriBuilderService.buildUriByAddressSearch(address);


        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTORIZATION, "KakaoAk " + kakaoRestApiKey);
        HttpEntity httpEntity = new HttpEntity<>(headers);

        // kakao api 호출
        return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, KakaoApiResponseDto.class).getBody();
    }


}
