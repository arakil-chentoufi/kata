package com.phoenix.api.service.nonbloq.facade;

import com.phoenix.api.entities.Delivery;
import com.phoenix.api.utils.DeliveryMode;

import reactor.core.publisher.Mono;

public interface DeliveryService {
	
	
	Mono<Delivery> createDelivery(Long clientId, DeliveryMode mode, Long scheduleId);

   Mono<Delivery> getDeliveryById(Long id) ;

}
