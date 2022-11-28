package com.babalola.beerservicems.services;

import com.babalola.beerservicems.entities.BeerEntity;
import com.babalola.beerservicems.interfaces.BeerInterface;
import com.babalola.beerservicems.mapper.BeerMapper;
import com.babalola.beerservicems.models.BeerDTO;
import com.babalola.beerservicems.models.BeerListPageable;
import com.babalola.beerservicems.models.BeerType;
import com.babalola.beerservicems.repositories.BeerRepository;
import com.babalola.domain.Beer;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class BeerService implements BeerInterface {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Cacheable(cacheNames = "beerListCache", condition = "#showInventoryOnHand == false ")
    @Override
    public BeerListPageable listBeers(String beerName, BeerType beerType, PageRequest pageRequest, Boolean showInventoryOnHand) {
        BeerListPageable beerPagedList;
        Page<Beer> beerPage;

        return null;
    }

    @Cacheable(cacheNames = "beerCache", key = "#beerId", condition = "#showInventoryOnHand == true")
    @Override
    public BeerDTO getBeerById(UUID id, Boolean showInventoryOnHand) throws ChangeSetPersister.NotFoundException {

        if (showInventoryOnHand) {
            return beerMapper.beerToBeerDtoWithInventory(
                    beerRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new)
            );
        } else {
            return beerMapper.beerToBeerDTO(beerRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));
        }
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDto) {

        return beerDto;
//        return beerMapper.beerToBeerDTO(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO) throws ChangeSetPersister.NotFoundException {
        BeerEntity beer = beerRepository.findById(beerId).orElseThrow(ChangeSetPersister.NotFoundException::new);

        beer.setBeerName(beerDTO.getName());
        beer.setBeerStyle(beerDTO.getBeerType().name());
        beer.setBeerPrice(beerDTO.getPrice());
        beer.setUpc(beerDTO.getUpc());

        return beerMapper.beerToBeerDTO(beerRepository.save(beer));
    }

    @Override
    public BeerDTO deleteById(UUID beerId) {
        //Implement logic to delete object

        return null;
    }

    @Cacheable(cacheNames = "beerUpcCache")
    @Override
    public BeerDTO getByUpc(String upc) {
        return beerMapper.beerToBeerDTO(beerRepository.findByUpc(upc));
    }
}
