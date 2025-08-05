package com.tsinjo.app.model.flow;

public class Donation extends CashFlow {
    public Donation(String id, Integer amount) {
        super(id, Type.IN, amount);
    }
}
