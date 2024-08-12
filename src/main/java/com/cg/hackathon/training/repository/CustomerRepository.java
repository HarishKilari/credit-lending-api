package com.cg.hackathon.training.repository;


import com.cg.hackathon.training.entity.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerData, String> {
    // additional custom methods if needed
}
