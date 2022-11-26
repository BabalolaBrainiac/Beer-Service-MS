package com.babalola.beerservicems.interfaces;

import com.babalola.beerservicems.models.BeerDTO;
import com.babalola.beerservicems.models.BeerListPageable;
import com.babalola.beerservicems.models.BeerType;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerInterface {
    BeerListPageable listBeers(String beerName, BeerType beerType, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDTO getBeerById(UUID id, Boolean showInventoryOnHand) throws ChangeSetPersister.NotFoundException;

    BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO) throws ChangeSetPersister.NotFoundException;

    BeerDTO deleteById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDto);

    BeerDTO getByUpc(String upc);
}
