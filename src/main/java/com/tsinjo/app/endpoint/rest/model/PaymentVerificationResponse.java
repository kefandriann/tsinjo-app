package com.tsinjo.app.endpoint.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter
public class PaymentVerificationResponse {
    private final String id;
    private PspType pspType;
    private final Instant creationInstant;
    private final Instant lastPspVerificationInstant;
    private Integer verificationAttemptNb;
    private Payer payer;
    private Application application;
    private String verificationStatus;
}
