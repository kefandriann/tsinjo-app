package com.tsinjo.app.endpoint.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class PaymentVerificationResponse {
    private final String id;
    private PspType pspType;
    private final Instant creationInstant;
    private final Instant lastPspVerificationInstant;
    private int verificationAttemptNb = 0;
    private Payer payer;
    private Application application;
    private String verificationStatus;
}
