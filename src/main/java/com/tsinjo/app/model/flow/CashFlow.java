package com.tsinjo.app.model.flow;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class CashFlow {
    private final String id;
    private final Type type;
    private final Integer amount;
}
