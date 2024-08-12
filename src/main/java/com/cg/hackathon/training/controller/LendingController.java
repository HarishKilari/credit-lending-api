package com.cg.hackathon.training.controller;

import com.cg.hackathon.training.entity.CustomerData;
import com.cg.hackathon.training.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lending/api/v1")
@CrossOrigin(origins = "https://evolve-bank.vercel.app/")
public class LendingController {

    @Autowired
    private LendingService lendingService;

    @PostMapping("/creditrisk")
    public ResponseEntity<String> predictCreditRisk(@RequestBody CustomerData customerData) throws Exception {
        String status = lendingService.predictCreditRisk(customerData);
        lendingService.saveCustomerData(customerData,status);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }


}





