package com.charter.communication.rewards.model;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.util.List;

@Log
@Getter
@Setter
public class CustomerRewardDetails {
    private long id;
    private List<PurchaseDetails> transactions;
    private double total;


}
