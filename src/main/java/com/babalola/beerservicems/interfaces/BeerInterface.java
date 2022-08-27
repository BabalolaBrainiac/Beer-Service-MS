package com.babalola.beerservicems.interfaces;
import com.babalola.beerservicems.models.BeerDTO;
import java.util.UUID;

public interface BeerInterface {
    BeerDTO getBeerById(UUID id);
    void updateBeer(UUID beerId, BeerDTO beerDTO);

    void deleteById(UUID beerId);

}
