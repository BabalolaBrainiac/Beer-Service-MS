package com.babalola.beerservicems.events;


import com.babalola.beerservicems.models.BeerDTO;
import com.babalola.beerservicems.models.BeerEvent;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BeerInventoryEvent extends BeerEvent {
    public BeerInventoryEvent(BeerDTO beerDto) {
        super(beerDto);
    }
}
