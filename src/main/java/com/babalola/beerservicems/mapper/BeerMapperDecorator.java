package com.babalola.beerservicems.mapper;

import com.babalola.beerservicems.interfaces.BeerInventoryInterface;
import com.babalola.beerservicems.models.BeerDTO;
import com.babalola.domain.Beer;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BeerMapperDecorator implements BeerMapper {

    private BeerInventoryInterface beerInventoryInterface;

    private BeerMapper beerMapper;


    @Autowired
    public void setBeerInventoryInterface(BeerInventoryInterface beerInventoryInterface) {
        this.beerInventoryInterface = beerInventoryInterface;
    }

    @Autowired
    public void setBeerMapper(BeerMapper beerMapper) {
        this.beerMapper = beerMapper;
    }

    @Override
    public BeerDTO beerToBeerDTO(Beer beer) {
        return beerMapper.beerToBeerDTO(beer);
    }

    @Override
    public BeerDTO beerToBeerDtoWithInventory(Beer beer) {
        BeerDTO dto = beerMapper.beerToBeerDTO(beer);
        dto.setQuantityOnHand(beerInventoryInterface.getOnHandInventory(beer.getId()));
        return dto;
    }

    @Autowired
    public Beer beerDtoToBeer(BeerDTO beerDTO) {
        return beerMapper.beerDtoToBeer(beerDTO);
    }
}
