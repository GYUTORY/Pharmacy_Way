package com.example.pharmacy_way.pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spock.lang.Specification;

/**
 * PharmacyRepository의 기능을 테스트하는 클래스
 *
 * - Spock 프레임워크를 사용하여 테스트를 작성
 * - @SpringBootTest를 사용하여 Spring 컨텍스트에서 테스트 수행
 */

@SpringBootTest // Spring Boot의 애플리케이션 컨텍스트를 로드하여 테스트 실행
class PharmacyRepositoryTest extends Specification { // Spock의 테스트 클래스는 Specification을 상속받아야 함

    @Autowired // Spring 컨테이너에서 PharmacyRepository 빈을 자동 주입
    private PharmacyRepository pharmacyRepository;

    /**
     * 테스트 메서드 (현재는 빈 상태)
     *
     * - "def" 키워드는 Spock에서 테스트 메서드를 정의할 때 사용
     */
    def "test"() {

    }
}