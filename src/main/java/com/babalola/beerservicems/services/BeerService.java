package com.babalola.beerservicems.services;
import com.babalola.beerservicems.interfaces.BeerInterface;
import com.babalola.beerservicems.models.BeerDTO;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class BeerService implements BeerInterface {

    @Override
    public BeerDTO getBeerById(UUID id) {
        return BeerDTO.builder().id(UUID.randomUUID())
                .name("Guiness Extra Smooth")
                .upc(900L)
                .beerType("Lager/Stout")
                .build();
    }

    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
      return BeerDTO.builder().id(UUID.randomUUID())
               .build();
    }


    @Override
    public void updateBeer(UUID beerId, BeerDTO beerDTO) {
        //Implement logic to update beer
    }

    @Override
    public void deleteById(UUID beerId) {
        //Implement logic to delete object
    }
}
