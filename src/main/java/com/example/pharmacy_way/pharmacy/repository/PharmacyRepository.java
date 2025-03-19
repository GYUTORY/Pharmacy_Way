package com.example.pharmacy_way.pharmacy.repository;

import com.example.pharmacy_way.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Pharmacy 엔티티와 데이터베이스 간의 상호작용을 담당하는 JPA Repository 인터페이스
 *
 * - JpaRepository<T, ID>를 상속받아 CRUD (Create, Read, Update, Delete) 기능을 자동으로 제공
 * - Spring Data JPA를 사용하여 SQL 쿼리를 직접 작성하지 않아도 데이터베이스와 통신 가능
 */

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
    // JpaRepository<Pharmacy, Long>를 상속받으면 기본적인 CRUD 메서드를 자동으로 제공받음
}