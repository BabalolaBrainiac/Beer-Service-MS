package com.babalola.beerservicems.services.BeerInventoryService;

import com.babalola.beerservicems.interfaces.BeerInventoryInterface;
import com.babalola.beerservicems.services.BeerInventoryService.model.BeerInventoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Slf4j
@ConfigurationProperties(prefix = "com.babalola.beer-inventory-service", ignoreInvalidFields = true)
@Component
public class BeerInventoryServiceRestTemplate implements BeerInventoryInterface {

    private static final String BEER_INVENTORY_SERVICE_PATH = "api/beer/{beerId}/inventory";

    RestTemplate restTemplate;

    private String beerInventoryServiceHost;

    public BeerInventoryServiceRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setBeerInventoryServiceHost(String newHost) {
        this.beerInventoryServiceHost = newHost;
    }

    @Override
    public Integer getOnHandInventory(UUID beerId) {

        log.debug("Connected to Beer Inventory Service");

        ResponseEntity<List<BeerInventoryDTO>> responseEntity = restTemplate
                .exchange(beerInventoryServiceHost + BEER_INVENTORY_SERVICE_PATH, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<BeerInventoryDTO>>() {
                        }, beerId);

        Integer onHand = Objects.requireNonNull(responseEntity.getBody()).stream()
                .mapToInt(BeerInventoryDTO::getQuantityOnHand).sum();


        return onHand;
    }
}
