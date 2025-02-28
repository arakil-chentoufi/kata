package com.phoenix.api.service.facade;

import java.util.List;

import com.phoenix.api.entities.DeliverySchedule;
import com.phoenix.api.utils.DeliveryMode;

public interface DeliveryScheduleService {
	List<DeliverySchedule> getAvailableSchedules(DeliveryMode mode);
}
