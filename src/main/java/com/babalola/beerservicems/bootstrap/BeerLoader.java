package com.babalola.beerservicems.bootstrap;

import com.babalola.beerservicems.entities.BeerEntity;
import com.babalola.beerservicems.models.BeerDTO;
import com.babalola.beerservicems.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class BeerLoader implements CommandLineRunner {

    private BeerRepository beerRepository;
    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadHardCodedBeerObjects();
    }

    private void loadHardCodedBeerObjects() {
        if (beerRepository.count() == 0 ) {

            beerRepository.save(BeerEntity.builder()
                    .beerName("Guiness Extra Smooth")
                    .beerStyle("Dark Stout")
                    .brewableQuantity(20000)
                    .upc(127823L)
                    .beerPrice(new BigDecimal("200.54"))
                    .minOnHand(1500)
                    .build());

            beerRepository.save(BeerEntity.builder()
                    .beerName("Trophy Extra Smooth")
                    .beerStyle("Dark Stout")
                    .brewableQuantity(10800)
                    .upc(7823L)
                    .beerPrice(new BigDecimal("440.54"))
                    .minOnHand(1500)
                    .build());

            beerRepository.save(BeerEntity.builder()
                    .beerName("Heineken")
                    .beerStyle("Lager")
                    .brewableQuantity(900000)
                    .upc(12232L)
                    .beerPrice(new BigDecimal("700.54"))
                    .minOnHand(1500)
                    .build());


            beerRepository.save(BeerEntity.builder()
                    .beerName("Guiness Extra Smooth")
                    .beerStyle("Dark Stout")
                    .brewableQuantity(20000)
                    .upc(127823L)
                    .beerPrice(new BigDecimal("200.54"))
                    .minOnHand(1500)
                    .build());

        }

        System.out.println(beerRepository.count());

    }
}
