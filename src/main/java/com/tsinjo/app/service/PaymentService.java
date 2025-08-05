package com.tsinjo.app.service;

import com.tsinjo.app.endpoint.rest.model.PaymentVerificationRequest;
import com.tsinjo.app.endpoint.rest.model.PaymentVerificationResponse;
import com.tsinjo.app.model.payment.Payment;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@NoArgsConstructor
public class PaymentService {

    private final Dotenv dotenv = Dotenv.load();

    private final String apiKey = dotenv.get("PAYMENTVERIFICATION_KEY");

    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedDelay = 24 * 60 * 60 * 1000)
    public PaymentVerificationResponse verifyPayment (PaymentVerificationRequest payment) {
        String url = "https://42cwka3n4ifcp7ufheyrpmph240iuaxo.lambda-url.eu-west-3.on.aws/payment";

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-api-key", apiKey);

            HttpEntity<PaymentVerificationRequest> entity = new HttpEntity<>(payment, headers);

            PaymentVerificationResponse response = restTemplate.postForObject(url, entity, PaymentVerificationResponse.class);
            response.setVerificationAttemptNb(response.getVerificationAttemptNb() + 1);

            return response;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
