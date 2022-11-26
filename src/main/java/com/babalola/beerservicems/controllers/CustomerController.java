package com.babalola.beerservicems.controllers;
import com.babalola.beerservicems.models.CustomerDTO;
import com.babalola.beerservicems.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("customerId")UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerService.createNewCustomer(customerDTO), HttpStatus.CREATED);
    }

    @PutMapping({"customerId"})
    public ResponseEntity updateCustomerDetails(@PathVariable UUID customerId, @RequestBody CustomerDTO updatedData) {
        customerService.updateCustomer(customerId, updatedData);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"customerId"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable("customerId") UUID customerId) {
        customerService.deleteCustomer(customerId);
    }

}
