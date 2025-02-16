package com.umutyenidil.springcommerce.customer;

import com.umutyenidil.springcommerce.exception.CustomerNotFoundException;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public String createCustomer(
            CustomerRequest request
    ) {
        Customer customer = customerRepository.save(
                customerMapper.toCustomer(request)
        );

        return customer.getId();
    }

    public void updateCustomer(
            CustomerRequest request
    ) {
        Customer customer = customerRepository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot find customer with id %s", request.id())
                ));

        mergeCustomer(customer, request);

        customerRepository.save(customer);
    }

    private void mergeCustomer(
            Customer customer,
            CustomerRequest request
    ) {
        if (StringUtils.isNotBlank(request.firstName())) {
            customer.setFirstName(request.firstName());
        }

        if (StringUtils.isNotBlank(request.lastName())) {
            customer.setLastName(request.lastName());
        }

        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }

        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existsById(
            String customerId
    ) {
        return customerRepository.findById(customerId)
                .isPresent();
    }

    public CustomerResponse findById(
            String customerId
    ) {
        return customerRepository.findById(customerId)
                .map(customerMapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("No customer found with given id %s", customerId)
                ));
    }

    public void deleteById(
            String customerId
    ) {

    }
}
