package com.phoenix.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenix.api.entities.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
