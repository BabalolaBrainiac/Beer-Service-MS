package com.babalola.beerservicems.repositories;

import com.babalola.beerservicems.entities.BeerEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<BeerEntity, UUID> {
//    Page<BeerEntity> findAllByBeerName(String beerName, Pageable pageable);
//
//    Page<BeerEntity> findAllByBeerStyle(BeerType beerType, Pageable pageable);
//
//    Page<BeerEntity> findAllByBeerNameAndBeerStyle(String beerName, BeerType beerType, Pageable pageable);

    BeerEntity findByUpc(String upc);
}