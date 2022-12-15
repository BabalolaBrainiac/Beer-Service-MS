package com.babalola.beerservicems.events;


import com.babalola.beerservicems.events.event_entities.BeerEvent;
import com.babalola.beerservicems.models.BeerDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BeerInventoryEvent extends BeerEvent {
    public BeerInventoryEvent(BeerDTO beerDto) {
        super(beerDto);
    }
}
