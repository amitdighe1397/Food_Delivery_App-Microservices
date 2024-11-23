package com.example.Payment_Service.serviceimpl;

import com.example.Payment_Service.model.Payment;
import com.example.Payment_Service.model.PaymentMethod;
import com.example.Payment_Service.model.PaymentStatus;
import com.example.Payment_Service.repository.PaymentRepository;
import com.example.Payment_Service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository
            orderRepository;

    @Override
    public Payment processPayment(UUID orderId, BigDecimal amount, PaymentMethod paymentMethod) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setMethod(paymentMethod);
        payment.setStatus(PaymentStatus.PENDING);  // Set initial status
        paymentRepository.save(payment);

        // Simulate payment processing and update status
        payment.setStatus(PaymentStatus.SUCCESS);  // For simplicity, assuming success
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(UUID paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found"));
    }

    @Override
    public PaymentStatus getPaymentStatus(UUID orderId) {
        Payment payment = paymentRepository.findByOrderId(orderId)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found"));
        return payment.getStatus();
    }

    @Override
    public Payment refundPayment(UUID paymentId) {
        Payment payment = getPaymentById(paymentId);
        payment.setStatus(PaymentStatus.REFUNDED);
        return paymentRepository.save(payment);
    }
}

