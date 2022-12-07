package com.babalola.beerservicems.repositories;

import com.babalola.beerservicems.entities.BeerEntity;
import com.babalola.beerservicems.models.BeerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<BeerEntity, UUID> {
    Page<BeerEntity> findAllByBeerName(String beerName, Pageable pageable);

    Page<BeerEntity> findAllByBeerStyle(BeerType beerType, Pageable pageable);

    Page<BeerEntity> findAllByBeerNameAndBeerStyle(String beerName, BeerType beerType, Pageable pageable);

    BeerEntity findByUpc(String upc);
}