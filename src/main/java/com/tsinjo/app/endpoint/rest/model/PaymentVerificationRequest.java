package com.tsinjo.app.endpoint.rest.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaymentVerificationRequest {
    private final String apiKey;
    private final String payerEmail;
    private final String pspType;
    private final String pspPaymentId;
}
