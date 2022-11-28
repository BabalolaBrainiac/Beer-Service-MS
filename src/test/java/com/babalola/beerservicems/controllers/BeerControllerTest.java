package com.babalola.beerservicems.controllers;

import com.babalola.beerservicems.bootstrap.BeerLoader;
import com.babalola.beerservicems.models.BeerDTO;
import com.babalola.beerservicems.models.BeerType;
import com.babalola.beerservicems.services.BeerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    BeerService beerService;


    @Test
    void getBeerById() throws Exception {

        given(beerService.getBeerById(any(), anyBoolean())).willReturn(getValidBeerDto());

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
//                .andExpect(status().isOk());


    }

    @Test
    void createBeer() throws Exception {

        BeerDTO beerDTO = getValidBeerDto();
        String beerAsString = objectMapper.writeValueAsString(beerDTO);

        given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());

        mockMvc.perform(post("/api/beer").contentType(MediaType.APPLICATION_JSON)
                .content(beerAsString)).andExpect(status().isCreated());
    }

    @Test
    void updateBeerDetails() throws Exception {
        BeerDTO beerDTO = getValidBeerDto();
        String beerAsString = objectMapper.writeValueAsString(beerDTO);

        given(beerService.updateBeer(any(), any())).willReturn(getValidBeerDto());

        mockMvc.perform(put(
                "/api/beer/" + UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON).content(beerAsString)).andExpect(status().isNoContent());
    }

    BeerDTO getValidBeerDto() {
        return BeerDTO.builder()
                .name("Heiniken")
                .beerType(BeerType.LAGER)
                .price(new BigDecimal("15.99"))
                .upc(BeerLoader.BEER_1_UPC)
                .build();

    }
}