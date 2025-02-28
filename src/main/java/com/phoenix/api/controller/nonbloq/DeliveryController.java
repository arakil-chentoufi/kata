package com.phoenix.api.controller.nonbloq;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Mono;
import com.phoenix.api.entities.Delivery;
import com.phoenix.api.service.nonbloq.facade.DeliveryService;
import com.phoenix.api.utils.DeliveryMode;


@RestController
@RequestMapping("/deliveries")
@Tag(name = "Delivery Controller", description = "APIs for managing deliveries in a reactive way")
public class DeliveryController {
    
    private final DeliveryService deliveryService;

    

 
    public DeliveryController(DeliveryService deliveryService) {
		super();
		this.deliveryService = deliveryService;
	}


	@PostMapping
    @Operation(summary = "Create a new delivery", description = "Creates a new delivery with the specified client ID, delivery mode, and schedule ID in a reactive manner.")
    public Mono<ResponseEntity<Delivery>> createDelivery(@RequestParam Long clientId, 
                                                         @RequestParam DeliveryMode mode,
                                                       @RequestParam Long scheduleId) {
        return deliveryService.createDelivery(clientId, mode, scheduleId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

  
  
  
    @GetMapping("/{id}")
    @Operation(summary = "Get delivery by ID", description = "Retrieves a specific delivery by its ID in a reactive manner.")
    public Mono<ResponseEntity<Delivery>> getDeliveryById(@PathVariable Long id) {
        return deliveryService.getDeliveryById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
