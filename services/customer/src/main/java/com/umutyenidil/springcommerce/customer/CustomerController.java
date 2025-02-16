package com.umutyenidil.springcommerce.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        return ResponseEntity
                .ok()
                .body(customerService.createCustomer(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        customerService.updateCustomer(request);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        return ResponseEntity
                .ok()
                .body(customerService.findAllCustomers());
    }

    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable("customer-id") String customerId
    ) {
        return ResponseEntity
                .ok()
                .body(customerService.existsById(customerId));
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(
            @PathVariable("customer-id") String customerId
    ) {
        return ResponseEntity
                .ok()
                .body(customerService.findById(customerId));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("customer-id") String customerId
    ) {
        customerService.deleteById(customerId);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
