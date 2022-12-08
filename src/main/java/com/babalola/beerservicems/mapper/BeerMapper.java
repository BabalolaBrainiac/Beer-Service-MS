package com.babalola.beerservicems.mapper;

import com.babalola.beerservicems.models.BeerDTO;
import com.babalola.domain.Beer;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDTO beerToBeerDTO(Beer beer);

    BeerDTO beerToBeerDtoWithInventory(Beer beer);

    Beer beerDtoToBeer(BeerDTO dto);
}
