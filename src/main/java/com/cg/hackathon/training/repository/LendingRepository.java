package com.cg.hackathon.training.repository;

import com.cg.hackathon.training.entity.CreditInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LendingRepository extends JpaRepository<CreditInfo, String> {
    CreditInfo findBySsn(String ssn);
    // additional custom methods if needed
}