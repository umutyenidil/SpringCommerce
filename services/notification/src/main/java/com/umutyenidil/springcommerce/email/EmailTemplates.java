package com.umutyenidil.springcommerce.email;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EmailTemplates {
    PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment Successfully Processed"),
    ORDER_CONFIRMATION("order-confirmation.html", "Your Order Confirmed");

    @Getter
    private final String template;
    @Getter
    private final String subject;
}
