package com.phoenix.api.service.impl;

import com.phoenix.api.entities.Delivery;
import com.phoenix.api.repository.DeliveryRepository;
import com.phoenix.api.repository.DeliveryScheduleRepository;
import com.phoenix.api.service.facade.DeliveryService;
import com.phoenix.api.utils.DeliveryMode;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DeliveryServiceImpl  implements DeliveryService  {
    
    private final DeliveryRepository deliveryRepository;
    private final DeliveryScheduleRepository scheduleRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, DeliveryScheduleRepository scheduleRepository) {
        this.deliveryRepository = deliveryRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public Optional<Delivery> createDelivery(Long clientId, DeliveryMode mode, Long scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .filter(schedule -> !schedule.isReserved())
                .map(schedule -> {
                    schedule.setReserved(true);
                    scheduleRepository.save(schedule);
                    
                    Delivery delivery = new Delivery();
                    delivery.setClientId(clientId);
                    delivery.setMode(mode);
                    delivery.setSchedule(schedule);
                    return deliveryRepository.save(delivery);
                });
    }
}
