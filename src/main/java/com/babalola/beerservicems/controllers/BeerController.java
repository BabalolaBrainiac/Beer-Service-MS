package com.babalola.beerservicems.controllers;
import com.babalola.beerservicems.models.BeerDTO;
import com.babalola.beerservicems.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;


@RequestMapping("/api/beer")
@RestController
public class BeerController {
    private final BeerService beerService;
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity handlePost(@RequestBody BeerDTO beerDTO) {
        BeerDTO newBeer = beerService.saveNewBeer(beerDTO);

        HttpHeaders header = new HttpHeaders();
        header.add("Location", "/beer" + newBeer.getId().toString() );

        return new ResponseEntity(header, HttpStatus.CREATED);

    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDTO) {
       beerService.updateBeer(beerId, beerDTO);

       return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);


    }

}
