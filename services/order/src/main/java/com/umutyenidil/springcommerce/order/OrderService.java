package com.umutyenidil.springcommerce.order;

import com.umutyenidil.springcommerce.customer.CustomerClient;
import com.umutyenidil.springcommerce.exception.BusinessException;
import com.umutyenidil.springcommerce.orderline.OrderLineRequest;
import com.umutyenidil.springcommerce.orderline.OrderLineService;
import com.umutyenidil.springcommerce.product.ProductClient;
import com.umutyenidil.springcommerce.product.PurchaseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;

    public Integer createOrder(@Valid OrderRequest request) {
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(()-> new BusinessException("Cannot create order with this customer"));

        this.productClient.purchaseProducts(request.products());

        var order = this.repository.save(mapper.toOrder(request));

        for(PurchaseRequest purchaseRequest: request.products()) {
            orderLineService.saveOrderLine(new OrderLineRequest(null, order.getId(), purchaseRequest.productId(), purchaseRequest.quantity()));
        }
    }
}
