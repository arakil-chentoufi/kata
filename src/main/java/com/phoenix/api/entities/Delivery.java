package com.phoenix.api.entities;

import com.phoenix.api.utils.DeliveryMode;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "deliveries")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Delivery {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long clientId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryMode mode;

    @OneToOne
    @JoinColumn(name = "schedule_id", unique = true)
    private DeliverySchedule schedule;
}
