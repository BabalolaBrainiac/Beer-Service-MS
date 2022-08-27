package com.babalola.beerservicems.services;

import com.babalola.beerservicems.interfaces.CustomerInterface;
import com.babalola.beerservicems.models.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CustomerService implements CustomerInterface {
    @Override
    public CustomerDTO getCustomerById(UUID id) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .name("Babalola Opeyemi Daniel")
                .favoriteBeer("Legend")
                .build();
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO newCustomer) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO updatedData) {
        //Logic to update customer details
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        //Logic to delete customer details
    }
}
