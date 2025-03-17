package com.example.pharmacy_way.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate을 Spring Bean으로 등록하는 설정 클래스
 *
 * - RestTemplate은 Spring에서 제공하는 HTTP 요청을 위한 클라이언트
 * - 외부 API와 통신할 때 사용됨 (예: Kakao API, 다른 RESTful API 호출 등)
 */
@Configuration // 해당 클래스가 설정 클래스임을 나타내며, Spring이 자동으로 빈을 등록하도록 함
public class RestTemplateConfig {

    /**
     * RestTemplate을 Spring Bean으로 등록
     *
     * @return RestTemplate 객체
     */
    @Bean // 해당 메서드의 반환값(RestTemplate 객체)을 Spring 컨테이너에 Bean으로 등록
    public RestTemplate restTemplate() {
        return new RestTemplate(); // 새로운 RestTemplate 인스턴스를 생성하여 반환
    }
}
