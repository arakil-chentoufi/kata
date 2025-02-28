package com.phoenix.api.service.facade;

import java.util.Optional;

import com.phoenix.api.entities.Delivery;
import com.phoenix.api.utils.DeliveryMode;

public interface DeliveryService {
	Optional<Delivery> createDelivery(Long clientId, DeliveryMode mode, Long scheduleId);

}
