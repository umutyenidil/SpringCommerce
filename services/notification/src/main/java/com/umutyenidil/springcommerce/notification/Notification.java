package com.umutyenidil.springcommerce.notification;

import com.umutyenidil.springcommerce.kafka.order.OrderConfirmation;
import com.umutyenidil.springcommerce.kafka.payment.PaymentConfirmation;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Notification {

    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private NotificationType type;
    private LocalDateTime createdAt;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}
