package com.example.pharmacy_way.pharmacy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Pharmacy 엔티티 클래스
 *
 * - JPA(Java Persistence API)를 사용하여 데이터베이스 테이블과 매핑되는 클래스
 * - Spring Boot와 Hibernate를 이용해 자동으로 테이블을 생성하고 관리
 * - Lombok을 활용하여 보일러플레이트(반복 코드)를 줄임
 */

@Entity(name = "pharmacy")  // 해당 클래스가 데이터베이스 테이블과 매핑되는 JPA 엔티티(Entity)임을 선언
@Getter  // Lombok 제공: 모든 필드에 대한 Getter 메서드를 자동 생성
@Builder // Lombok 제공: 객체 생성 시 Builder 패턴을 사용할 수 있도록 지원
@NoArgsConstructor // Lombok 제공: 기본 생성자(매개변수 없는 생성자)를 자동으로 생성
@AllArgsConstructor // Lombok 제공: 모든 필드를 매개변수로 받는 생성자를 자동으로 생성
public class Pharmacy {

    /**
     * 기본 키(Primary Key) 설정
     * - @Id: 해당 필드가 데이터베이스 테이블의 Primary Key임을 명시
     * - @GeneratedValue: Primary Key 값을 자동으로 생성
     * - strategy = GenerationType.IDENTITY:
     *      - MySQL, PostgreSQL 등의 데이터베이스에서 AUTO_INCREMENT를 사용하여 자동 증가
     *      - 새로운 레코드가 추가될 때마다 자동으로 1씩 증가하는 값 할당
     */
    @Id  // Primary Key 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 데이터베이스가 자동으로 값을 생성 (AUTO_INCREMENT)
    private Long id;  // 약국 엔티티의 고유 식별자 (Primary Key)
}