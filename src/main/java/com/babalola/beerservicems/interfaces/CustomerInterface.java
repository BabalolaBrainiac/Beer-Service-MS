package com.babalola.beerservicems.interfaces;

import com.babalola.beerservicems.models.CustomerDTO;

import java.util.UUID;

public interface CustomerInterface {
    CustomerDTO getCustomerById(UUID id);
    CustomerDTO createNewCustomer(CustomerDTO newCustomer);
    void updateCustomer(UUID customerId, CustomerDTO updatedData);
    void deleteCustomer(UUID customerId);
}
