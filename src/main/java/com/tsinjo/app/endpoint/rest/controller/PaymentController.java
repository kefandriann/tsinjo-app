package com.tsinjo.app.endpoint.rest.controller;

import com.tsinjo.app.endpoint.rest.model.PaymentVerificationRequest;
import com.tsinjo.app.endpoint.rest.model.PaymentVerificationResponse;
import com.tsinjo.app.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;

@Controller
public class PaymentController {

    private final PaymentService paymentService = new PaymentService();

    @GetMapping("/payment")
    public String home(Model model){
        model.addAttribute("message", "Hello");
        return "home";
    }

    @PostMapping("/payment")
    public PaymentVerificationResponse verifyPayment(@RequestBody PaymentVerificationRequest payment) {

        return paymentService.verifyPayment(payment);
    }
}
