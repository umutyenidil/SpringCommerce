package com.umutyenidil.springcommerce.order;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request) {
        return Order.builder()
                .id(request.id())
                .customerId(request.customerId())
                .reference(request.reference())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }
}
