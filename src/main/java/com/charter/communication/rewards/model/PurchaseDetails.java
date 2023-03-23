package com.charter.communication.rewards.model;


import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.time.LocalDate;

@Log
@Getter
@Setter
@Entity
@Table(name = "purchase_details")
public class PurchaseDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "trans_date")
    private LocalDate trans_date;

    @Column(name = "amount")
    private double amount;

}
