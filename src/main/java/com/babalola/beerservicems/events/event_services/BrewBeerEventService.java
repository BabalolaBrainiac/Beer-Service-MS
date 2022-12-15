package com.babalola.beerservicems.events.event_services;


import com.babalola.beerservicems.configuration.JMSConfig;
import com.babalola.beerservicems.domain.Beer;
import com.babalola.beerservicems.events.BrewBeerEvent;
import com.babalola.beerservicems.interfaces.BeerInventoryInterface;
import com.babalola.beerservicems.mapper.BeerMapper;
import com.babalola.beerservicems.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BrewBeerEventService {
    private final BeerRepository beerRepository;
    private final BeerInventoryInterface beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;


    @Scheduled(fixedRate = 5000)
    public void checkLowInventory() {
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer availableInventory = beerInventoryService.getOnHandInventory(beer.getId());
            log.debug("Checking Inventory for: " + beer.getBeerName() + " / " + beer.getId());
            log.debug("Min Onhand is: " + beer.getMinOnHand());
            log.debug("Inventory is: "  + availableInventory);

            System.out.println("Minimum on Hand is " + beer.getMinOnHand());
            System.out.println("Available inventory is " + availableInventory);
            if(beer.getMinOnHand() >= availableInventory){
                jmsTemplate.convertAndSend(JMSConfig.BEER_BREWING_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDTO(beer)));
            }
        });
    }

}
