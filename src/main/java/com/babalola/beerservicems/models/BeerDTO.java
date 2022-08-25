package com.babalola.beerservicems.models;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDTO {
    private UUID id;
    private Integer version;
    private OffsetDateTime createdAt;
    private OffsetDateTime lastModified;
    private String beerName;
    private BeerType beerType;
    private Long upc;
    private BigDecimal price;
    private Integer availableQuantity;
}
