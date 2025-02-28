package com.phoenix.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.phoenix.api.entities.Delivery;
import com.phoenix.api.service.facade.DeliveryService;
import com.phoenix.api.utils.DeliveryMode;

import java.util.Optional;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@RequestParam Long clientId, 
                                                   @RequestParam DeliveryMode mode,
                                                   @RequestParam Long scheduleId) {
        Optional<Delivery> delivery = deliveryService.createDelivery(clientId, mode, scheduleId);
        return delivery.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}


