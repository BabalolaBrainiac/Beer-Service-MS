package com.babalola.beerservicems.mapper;

import com.babalola.beerservicems.entities.BeerEntity;
import com.babalola.beerservicems.models.BeerDTO;
import com.babalola.domain.Beer;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDTO beerToBeerDTO(BeerEntity beer);

    BeerDTO beerToBeerDtoWithInventory(BeerEntity beer);

    Beer beerDtoToBeer(BeerDTO dto);
}
