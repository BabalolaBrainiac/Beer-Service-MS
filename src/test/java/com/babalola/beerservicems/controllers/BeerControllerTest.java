package com.babalola.beerservicems.controllers;
import com.babalola.beerservicems.models.BeerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.UUID;


@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
   MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {

      mockMvc.perform(get("/api/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk());
    }

    @Test
    void createBeer() throws Exception {
        BeerDTO beerDTO = BeerDTO.builder().build();
        String beerAsString = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(post("/api/beer").contentType(MediaType.APPLICATION_JSON)
                .content(beerAsString)).andExpect(status().isCreated());
    }

    @Test
    void updateBeerDetails() throws Exception {
        BeerDTO beerDTO = BeerDTO.builder().build();
        String beerAsString = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(put("/api/beer/" + UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON)
                .content(beerAsString)).andExpect(status().isOk());
    }
}