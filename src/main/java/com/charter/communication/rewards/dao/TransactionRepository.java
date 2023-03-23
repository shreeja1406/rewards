package com.charter.communication.rewards.dao;

import com.charter.communication.rewards.model.PurchaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<PurchaseDetails, Long> {
    List<PurchaseDetails> findByCustomerId(int customerId);
}