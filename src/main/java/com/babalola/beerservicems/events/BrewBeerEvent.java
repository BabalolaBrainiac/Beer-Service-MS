package com.babalola.beerservicems.events;


import com.babalola.beerservicems.models.BeerDTO;
import com.babalola.beerservicems.models.BeerEvent;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {
    public BrewBeerEvent(BeerDTO beerDto) {
        super(beerDto);
    }
}
