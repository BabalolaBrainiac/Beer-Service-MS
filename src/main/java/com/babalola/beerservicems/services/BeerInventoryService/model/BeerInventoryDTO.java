package com.babalola.beerservicems.services.BeerInventoryService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerInventoryDTO {

    private UUID id;

    private OffsetDateTime createdAt;

    private OffsetDateTime lastUpdatedAt;

    private UUID beerId;

    private Integer quantityOnHand;


}
