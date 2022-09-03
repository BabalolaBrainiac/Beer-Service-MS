package com.babalola.beerservicems.models;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDTO {

    @Null
    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String beerType;

    @Positive
    private Long upc;

}
