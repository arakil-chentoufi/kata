package com.phoenix.api.service.impl;

import org.springframework.stereotype.Service;

import com.phoenix.api.entities.DeliverySchedule;
import com.phoenix.api.repository.DeliveryScheduleRepository;
import com.phoenix.api.service.facade.DeliveryScheduleService;
import com.phoenix.api.utils.DeliveryMode;

import java.util.List;

@Service
public class DeliveryScheduleServiceImpl implements DeliveryScheduleService  {
    
    private final DeliveryScheduleRepository scheduleRepository;

    

    public DeliveryScheduleServiceImpl(DeliveryScheduleRepository scheduleRepository) {
		super();
		this.scheduleRepository = scheduleRepository;
	}



	public List<DeliverySchedule> getAvailableSchedules(DeliveryMode mode) {
        return scheduleRepository.findByModeAndReservedFalse(mode);
    }
}
