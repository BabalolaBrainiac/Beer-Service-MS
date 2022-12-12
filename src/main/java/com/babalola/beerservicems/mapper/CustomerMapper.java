package com.babalola.beerservicems.mapper;

import com.babalola.beerservicems.models.CustomerDTO;
import com.babalola.beerservicems.domain.Customer;
import org.mapstruct.Mapper;


@Mapper
public interface CustomerMapper {

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDTOToCustomer(CustomerDTO customer);
}
