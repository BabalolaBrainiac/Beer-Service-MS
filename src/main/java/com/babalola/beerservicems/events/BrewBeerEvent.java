package com.babalola.beerservicems.events;


import com.babalola.beerservicems.events.event_entities.BeerEvent;
import com.babalola.beerservicems.models.BeerDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {
    public BrewBeerEvent(BeerDTO beerDto) {
        super(beerDto);
    }
}
