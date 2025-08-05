package com.tsinjo.app.model.payment;

import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
public class Payment {
    private final String id;
    private final Instant creationInstant;
    private final Integer amount;
    private final PaymentMean paymentMean;
}
