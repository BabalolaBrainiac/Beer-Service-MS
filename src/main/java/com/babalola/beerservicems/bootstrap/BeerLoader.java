package com.babalola.beerservicems.bootstrap;

import com.babalola.beerservicems.models.BeerStyle;
import com.babalola.beerservicems.repositories.BeerRepository;
import com.babalola.beerservicems.domain.Beer;
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
        if (beerRepository.count() == 0) {
            loadHardCodedBeerObjects();
        }
    }

    private void loadHardCodedBeerObjects() {

        Beer beer1 = Beer.builder()
                .beerName("Orijin")
                .beerStyle(BeerStyle.ALE.name())
                .minOnHand(152)
                .quantityToBrew(2030)
                .price(new BigDecimal("42.95"))
                .upc(BEER_1_UPC)
                .build();

        Beer beer2 = Beer.builder()
                .beerName("Stout")
                .beerStyle(BeerStyle.PORTER.name())
                .minOnHand(142)
                .quantityToBrew(2300)
                .price(new BigDecimal("12.95"))
                .upc(BEER_2_UPC)
                .build();

        Beer beer3 = Beer.builder()
                .beerName("33")
                .beerStyle(BeerStyle.SIASON.name())
                .minOnHand(132)
                .quantityToBrew(2060)
                .price(new BigDecimal("15.95"))
                .upc(BEER_3_UPC)
                .build();

        beerRepository.save(Beer.builder()
                .beerName("Guiness Extra Smooth")
                .beerStyle(BeerStyle.PILSNER.name())
                .quantityToBrew(20000)
                .upc(BEER_1_UPC)
                .price(new BigDecimal("200.54"))
                .minOnHand(1500)
                .build());

        beerRepository.save(Beer.builder()
                .beerName("Trophy Extra Smooth")
                .beerStyle(BeerStyle.IPA.name())
                .quantityToBrew(10800)
                .upc("1235654345L")
                .price(new BigDecimal("440.54"))
                .minOnHand(1500)
                .build());

        beerRepository.save(Beer.builder()
                .beerName("Heineken")
                .beerStyle(BeerStyle.ALE.name())
                .quantityToBrew(900000)
                .upc(BEER_2_UPC)
                .price(new BigDecimal("700.54"))
                .minOnHand(1500)
                .build());


        beerRepository.save(Beer.builder()
                .beerName("Guiness Extra Smooth")
                .beerStyle(BeerStyle.LAGER.name())
                .quantityToBrew(20000)
                .upc(BEER_3_UPC)
                .price(new BigDecimal("200.54"))
                .minOnHand(1500)
                .build());

        beerRepository.save(beer1);
        beerRepository.save(beer2);
        beerRepository.save(beer3);

        System.out.println(beerRepository.count());

    }
}
