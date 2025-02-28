package com.phoenix.api.controller;

import org.springframework.web.bind.annotation.*;

import com.phoenix.api.entities.DeliverySchedule;
import com.phoenix.api.service.facade.DeliveryScheduleService;
import com.phoenix.api.utils.DeliveryMode;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class DeliveryScheduleController {
    
    private final DeliveryScheduleService scheduleService;

    public DeliveryScheduleController(DeliveryScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{mode}")
    public List<DeliverySchedule> getAvailableSchedules(@PathVariable DeliveryMode mode) {
        return scheduleService.getAvailableSchedules(mode);
    }
}
