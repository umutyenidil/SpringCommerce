package com.umutyenidil.springcommerce.customer;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        if(request == null) return null;

        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lasName())
                .email(request.email())
                .address(request.address())
                .build();
    }
}
