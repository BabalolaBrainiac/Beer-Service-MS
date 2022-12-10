package com.babalola.beerservicems.controllers;

import com.babalola.beerservicems.models.BeerDTO;
import com.babalola.beerservicems.models.BeerListPageable;
import com.babalola.beerservicems.models.BeerStyle;
import com.babalola.beerservicems.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;


@RequiredArgsConstructor
@RequestMapping("/api/beer")
@RestController
public class BeerController {
    private static final Integer DEFAULT_PAGE_NUMBER = 10;
    private static final Integer DEFAULT_PAGE_SIZE = 25;
    private final BeerService beerService;


    @GetMapping(produces = {"application/json"}, path = {"/beers"})
    public ResponseEntity<BeerListPageable> listBeers(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                      @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                      @RequestParam(value = "beerName", required = false) String beerName,
                                                      @RequestParam(value = "beerStyle", required = false) BeerStyle beerStyle,
                                                      @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand) {


        if (showInventoryOnHand == null) {
            showInventoryOnHand = false;
        }

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        BeerListPageable beerList = beerService.listBeers(beerName, beerStyle, PageRequest.ofSize(pageNumber), true);

        System.out.println("Controller working");
        return new ResponseEntity<>(beerList, HttpStatus.OK);
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId,
                                               @RequestParam(value = "showInventoryOnHand") Boolean showInventoryOnHand) throws ChangeSetPersister.NotFoundException {

        if (showInventoryOnHand == null) {
            showInventoryOnHand = false;
        }

        return new ResponseEntity<>(beerService.getBeerById(beerId, showInventoryOnHand), HttpStatus.OK);
    }

    @GetMapping("/beerUpc/{upc}")
    public ResponseEntity<BeerDTO> getBeerByUpc(@PathVariable("upc") String upc) {
        return new ResponseEntity<>(beerService.getByUpc(upc), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDTO beerDTO) {

        return new ResponseEntity(beerService.saveNewBeer(beerDTO), HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDTO beerDTO) throws ChangeSetPersister.NotFoundException {

        return new ResponseEntity(beerService.updateBeer(beerId, beerDTO), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);
    }
}
