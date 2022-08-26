package com.babalola.beerservicems.controllers;


import com.babalola.beerservicems.models.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/beer")
public class BeerController {

    @GetMapping("{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId) {

        //Implement Logic
        return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BeerDTO> createBeer(BeerDTO newBeer) {

        //Implement Logic
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity updateBeerDetails(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO updatedBeer) {

        //Implement Logic
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{beerId}")
    public void deleteBeerById(@PathVariable("beerId") UUID beerId) {

        //Implement Logic
    }
}
