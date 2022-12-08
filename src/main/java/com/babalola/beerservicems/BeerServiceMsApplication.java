package com.babalola.beerservicems;

import com.babalola.domain.Beer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = Beer.class)
public class BeerServiceMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerServiceMsApplication.class, args);
    }

}
