package com.phoenix.api.repository.nonbloquant;


import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.phoenix.api.entities.Delivery;
import reactor.core.publisher.Mono;

public interface DeliveryRepository extends R2dbcRepository<Delivery, Long> {
    Mono<Delivery> findByClientId(Long clientId);
}

