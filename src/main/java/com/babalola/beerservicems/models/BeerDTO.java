package com.babalola.beerservicems.models;
import lombok.*;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDTO {
    private UUID id;
    private String name;
    private String beerType;
    private Long upc;

}
