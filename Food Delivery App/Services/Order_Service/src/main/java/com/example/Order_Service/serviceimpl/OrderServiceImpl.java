package com.example.Order_Service.serviceimpl;

import com.example.Order_Service.model.Order;
import com.example.Order_Service.model.OrderItem;
import com.example.Order_Service.model.OrderStatus;
import com.example.Order_Service.repository.OrderItemRepository;
import com.example.Order_Service.repository.OrderRepository;
import com.example.Order_Service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Order placeOrder(UUID userId, UUID restaurantId, List<OrderItem> orderItems, UUID addressId) {
        // Step 1: Calculate the total order amount
        BigDecimal totalAmount = calculateTotalAmount(orderItems);

        // Step 2: Create and save the order
        Order order = new Order();
        order.setUserId(userId);
        order.setRestaurantId(restaurantId);
        order.setAddressId(addressId);
        order.setTotalAmount(totalAmount);
        order.setStatus(OrderStatus.PLACED);  // Initial status
        order = orderRepository.save(order);

        // Step 3: Save the order items
        for (OrderItem item : orderItems) {
            item.setOrderId(order.getId());
            orderItemRepository.save(item);
        }

        return order;
    }

    @Override
    public Order getOrderById(UUID orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found"));
    }

    @Override
    public Order updateOrderStatus(UUID orderId, OrderStatus status) {
        Order order = getOrderById(orderId);
        order.setStatus(status);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByUserId(UUID userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public BigDecimal calculateTotalAmount(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

