package com.phoenix.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenix.api.entities.DeliverySchedule;
import com.phoenix.api.utils.DeliveryMode;

public interface DeliveryScheduleRepository extends JpaRepository<DeliverySchedule, Long> {
	List<DeliverySchedule> findByModeAndReservedFalse(DeliveryMode mode);

}
