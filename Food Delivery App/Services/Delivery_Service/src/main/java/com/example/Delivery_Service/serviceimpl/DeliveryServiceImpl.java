package com.example.Delivery_Service.serviceimpl;

import com.example.Delivery_Service.model.Delivery;
import com.example.Delivery_Service.model.DeliveryAgent;
import com.example.Delivery_Service.model.DeliveryStatus;
import com.example.Delivery_Service.repository.DeliveryAgentRepository;
import com.example.Delivery_Service.repository.DeliveryRepository;
import com.example.Delivery_Service.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DeliveryAgentRepository deliveryAgentRepository;

    @Override
    public Delivery assignDelivery(UUID orderId, UUID deliveryAgentId, String deliveryAddress) {
        DeliveryAgent agent = deliveryAgentRepository.findById(deliveryAgentId)
                .orElseThrow(() -> new DeliveryAgentNotFoundException("Delivery agent not found"));

        Delivery delivery = new Delivery();
        delivery.setOrderId(orderId);
        delivery.setDeliveryAgentId(deliveryAgentId);
        delivery.setStatus(DeliveryStatus.PENDING);  // Initial status
        delivery.setEstimatedTime(calculateEstimatedDeliveryTime());
        deliveryRepository.save(delivery);

        return delivery;
    }

    @Override
    public DeliveryStatus getDeliveryStatus(UUID deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new DeliveryNotFoundException("Delivery not found"))
                .getStatus();
    }

    @Override
    public Delivery updateDeliveryStatus(UUID deliveryId, DeliveryStatus status) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new DeliveryNotFoundException("Delivery not found"));
        delivery.setStatus(status);
        return deliveryRepository.save(delivery);
    }

    @Override
    public List<Delivery> getDeliveriesByAgent(UUID agentId) {
        return deliveryRepository.findByDeliveryAgentId(agentId);
    }

    @Override
    public List<Delivery> getDeliveriesByOrder(UUID orderId) {
        return deliveryRepository.findByOrderId(orderId);
    }

    private String calculateEstimatedDeliveryTime() {
        // Simple logic to simulate an estimated time calculation
        return "30 mins";
    }
}

