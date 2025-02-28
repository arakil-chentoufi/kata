package com.phoenix.api.entities;

import java.time.LocalDateTime;

import com.phoenix.api.utils.DeliveryMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "delivery_slots")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DeliverySchedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryMode mode;

    @Column(nullable = false)
    private LocalDateTime scheduleTime;

    @Column(nullable = false)
    private boolean reserved = false;
}

