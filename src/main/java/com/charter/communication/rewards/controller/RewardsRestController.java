package com.charter.communication.rewards.controller;


import com.charter.communication.rewards.model.CustomerRewardDetails;
import com.charter.communication.rewards.service.TransactionsService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/rewards")
@Log
public class RewardsRestController {
@Autowired
TransactionsService service;
    @GetMapping(value = "/getcustdetails/{custid}")
    public ResponseEntity<CustomerRewardDetails> getRewards(@PathVariable(required=false)String custid){

        CustomerRewardDetails customer= service.getRewards(custid);
        return ResponseEntity.ok(customer);
    }
}
