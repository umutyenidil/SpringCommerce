package com.umutyenidil.springcommerce.payment;

import com.umutyenidil.springcommerce.customer.CustomerResponse;
import com.umutyenidil.springcommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
