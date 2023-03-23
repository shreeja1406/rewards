package com.charter.communication.rewards.service;

import com.charter.communication.rewards.dao.TransactionRepository;
import com.charter.communication.rewards.model.CustomerRewardDetails;
import com.charter.communication.rewards.model.PurchaseDetails;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log
public class TransactionsService {

    private static final int POINTS_PER_DOLLAR_ABOVE_100 = 2;
    private static final int POINTS_PER_DOLLAR_BETWEEN_50_AND_100 = 1;
    @Autowired
    TransactionRepository repo;
    public CustomerRewardDetails getRewards(String custId) {
        log.info("Searching for custId "+custId);
        List<PurchaseDetails> transactions = repo.findByCustomerId((int)Integer.parseInt(custId));
        Map<Month, Integer> rewardPointsByMonth = new HashMap<>();
        System.out.println("transactios-------");
        System.out.println(transactions);
        System.out.println("transactios-------");
        for (PurchaseDetails transaction : transactions) {
            System.out.println("transaction.getDate() "+transaction.getTrans_date()+" transaction.getAmount(): "+transaction.getAmount());
            Month month = transaction.getTrans_date().getMonth();
            int rewardPoints = calculateRewardPoints(transaction.getAmount());
            System.out.println("rewardPoints "+rewardPoints);
            rewardPointsByMonth.put(month, rewardPointsByMonth.getOrDefault(month, 0) + rewardPoints);
        }
        System.out.println(rewardPointsByMonth);
        CustomerRewardDetails customerRewardDetails = new CustomerRewardDetails();
        customerRewardDetails.setId(Long.parseLong(custId));
        customerRewardDetails.setTotal(rewardPointsByMonth.values()
                .stream()
                .mapToDouble(Integer::doubleValue).sum());
        return customerRewardDetails;
    }

    private int calculateRewardPoints(double amount) {
        int totalPoints = 0;

        if (amount > 100) {
            totalPoints += (amount - 100) * POINTS_PER_DOLLAR_ABOVE_100;
            amount = 100;
        }

        if (amount >= 50) {
            totalPoints += (amount - 50) * POINTS_PER_DOLLAR_BETWEEN_50_AND_100;
        }

        return totalPoints;
    }
}
