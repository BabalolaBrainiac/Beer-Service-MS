package com.babalola.beerservicems.events.event_listeners;


import com.babalola.beerservicems.configuration.JMSConfig;
import com.babalola.beerservicems.domain.Beer;
import com.babalola.beerservicems.events.BeerInventoryEvent;
import com.babalola.beerservicems.events.BrewBeerEvent;
import com.babalola.beerservicems.models.BeerDTO;
import com.babalola.beerservicems.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerEventListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JMSConfig.BEER_BREWING_QUEUE)
    public void listen(BrewBeerEvent event){
        BeerDTO beerDto = event.getBeerDTO();

        Beer beer = beerRepository.getOne(beerDto.getId());

        beerDto.setQuantityOnHand(beer.getQuantityToBrew());


        BeerInventoryEvent beerInventoryEvent = new BeerInventoryEvent(beerDto);

        log.debug("Brewed beer " + beer.getMinOnHand() + " : QOH: " + beerDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JMSConfig.BEER_INVENTORY_QUEUE, beerInventoryEvent);
    }
}
