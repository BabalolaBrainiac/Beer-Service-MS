package com.babalola.beerservicems.bootstrap;

import com.babalola.beerservicems.entities.BeerEntity;
import com.babalola.beerservicems.models.BeerType;
import com.babalola.beerservicems.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";
    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadHardCodedBeerObjects();
    }

    private void loadHardCodedBeerObjects() {
        if (beerRepository.count() == 0) {

            BeerEntity beer1 = BeerEntity.builder()
                    .beerName("Orijin")
                    .beerStyle(BeerType.IPA.name())
                    .minOnHand(12)
                    .brewableQuantity(200)
                    .beerPrice(new BigDecimal("12.95"))
                    .upc(BEER_1_UPC)
                    .build();

            BeerEntity beer2 = BeerEntity.builder()
                    .beerName("Start")
                    .beerStyle(BeerType.IPA.name())
                    .minOnHand(12)
                    .brewableQuantity(200)
                    .beerPrice(new BigDecimal("12.95"))
                    .upc(BEER_2_UPC)
                    .build();

            BeerEntity beer3 = BeerEntity.builder()
                    .beerName("33")
                    .beerStyle(BeerType.IPA.name())
                    .minOnHand(12)
                    .brewableQuantity(200)
                    .beerPrice(new BigDecimal("12.95"))
                    .upc(BEER_3_UPC)
                    .build();

            beerRepository.save(BeerEntity.builder()
                    .beerName("Guiness Extra Smooth")
                    .beerStyle("Dark Stout")
                    .brewableQuantity(20000)
                    .upc("1234L")
                    .beerPrice(new BigDecimal("200.54"))
                    .minOnHand(1500)
                    .build());

            beerRepository.save(BeerEntity.builder()
                    .beerName("Trophy Extra Smooth")
                    .beerStyle("Dark Stout")
                    .brewableQuantity(10800)
                    .upc("12345L")
                    .beerPrice(new BigDecimal("440.54"))
                    .minOnHand(1500)
                    .build());

            beerRepository.save(BeerEntity.builder()
                    .beerName("Heineken")
                    .beerStyle("Lager")
                    .brewableQuantity(900000)
                    .upc("123456L")
                    .beerPrice(new BigDecimal("700.54"))
                    .minOnHand(1500)
                    .build());


            beerRepository.save(BeerEntity.builder()
                    .beerName("Guiness Extra Smooth")
                    .beerStyle("Dark Stout")
                    .brewableQuantity(20000)
                    .upc("127823L")
                    .beerPrice(new BigDecimal("200.54"))
                    .minOnHand(1500)
                    .build());

            beerRepository.save(beer1);
            beerRepository.save(beer2);
            beerRepository.save(beer3);
        }


        System.out.println(beerRepository.count());

    }
}
