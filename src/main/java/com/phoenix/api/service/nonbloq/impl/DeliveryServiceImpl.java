package com.phoenix.api.service.nonbloq.impl;

import org.springframework.stereotype.Service;
import com.phoenix.api.entities.Delivery;
import com.phoenix.api.repository.nonbloquant.DeliveryRepository;
import com.phoenix.api.service.nonbloq.facade.DeliveryService;
import com.phoenix.api.utils.DeliveryMode;
import reactor.core.publisher.Mono;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

   

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
		super();
		this.deliveryRepository = deliveryRepository;
	}

	public Mono<Delivery> createDelivery(Long clientId, DeliveryMode mode, Long scheduleId) {
        Delivery delivery = new Delivery();
        delivery.setClientId(clientId);
        delivery.setMode(mode);
        delivery.setSchedule(null);
        return deliveryRepository.save(delivery);
    }

    public Mono<Delivery> getDeliveryById(Long id) {
        return deliveryRepository.findById(id);
    }
}
