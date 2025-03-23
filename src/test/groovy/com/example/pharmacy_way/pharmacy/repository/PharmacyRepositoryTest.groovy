package com.example.pharmacy_way.pharmacy.repository

import com.example.pharmacy_way.pharmacy.entity.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.pharmacy_way.AbstractIntegrationContainerBaseTest
import com.example.pharmacy_way.pharmacy.entity.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired


import org.springframework.boot.test.context.SpringBootTest;
import spock.lang.Specification;

/**
 * PharmacyRepository의 기능을 테스트하는 클래스
 *
 * - Spock 프레임워크를 사용하여 테스트를 작성
 * - @SpringBootTest를 사용하여 Spring 컨텍스트에서 테스트 수행
 */


class PharmacyRepositoryTest extends AbstractIntegrationContainerBaseTest { // Spock의 테스트 클래스는 Specification을 상속받아야 함

    @Autowired // Spring 컨테이너에서 PharmacyRepository 빈을 자동 주입
    private PharmacyRepository pharmacyRepository;

    def "PharmacyRepository save"() {

        given:
        String address = "서울 특별시 성북구 종암동"
        String name = "은혜 약국"
        double latitude = 36.11
        double longitude = 128.11

        def pharmacy = Pharmacy.builder()
                .pharmacyAddress(address)
                .pharmacyName(name)
                .latitude(latitude)
                .longitude(longitude)
                .build()

        when:
        def result = pharmacyRepository.save(pharmacy)

        then:
        result.getPharmacyAddress() == address;
        result.getPharmacyName() == name;
        result.getLatitude() == latitude;
        result.getLongitude() == longitude;
    }

}