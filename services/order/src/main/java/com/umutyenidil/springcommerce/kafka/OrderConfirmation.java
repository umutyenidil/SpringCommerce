package com.umutyenidil.springcommerce.kafka;

import com.umutyenidil.springcommerce.customer.CustomerResponse;
import com.umutyenidil.springcommerce.order.PaymentMethod;
import com.umutyenidil.springcommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
