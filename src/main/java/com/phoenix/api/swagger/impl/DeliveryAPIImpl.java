package com.phoenix.api.swagger.impl;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.api.entities.Delivery;
import com.phoenix.api.service.facade.DeliveryService;
import com.phoenix.api.utils.DeliveryMode;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/deliveries")
@Tag(name = "Delivery Controller", description = "APIs for managing deliveries")
public class DeliveryAPIImpl  {

	private final DeliveryService deliveryService;

	public DeliveryAPIImpl(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

	@Operation(summary = "Create a new delivery", description = "Creates a new delivery with the specified client ID, delivery mode, and schedule ID.")
	@PostMapping("/")
	public ResponseEntity<Delivery> createDelivery(Long clientId, DeliveryMode mode, Long scheduleId) {
		// TODO Auto-generated method stub
		Optional<Delivery> delivery = deliveryService.createDelivery(clientId, mode, scheduleId);
		return delivery.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
	}

}
