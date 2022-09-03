package com.babalola.beerservicems.repositories;

import com.babalola.beerservicems.entities.BeerEntity;
import com.babalola.beerservicems.models.BeerDTO;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<BeerEntity, UUID> {
}
