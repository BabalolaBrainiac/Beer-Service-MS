package com.babalola.beerservicems.mapper;

import com.babalola.beerservicems.domain.Customer;
import com.babalola.beerservicems.domain.Customer.CustomerBuilder;
import com.babalola.beerservicems.models.CustomerDTO;
import com.babalola.beerservicems.models.CustomerDTO.CustomerDTOBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T22:45:42+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTOBuilder customerDTO = CustomerDTO.builder();

        customerDTO.id( customer.getId() );
        customerDTO.name( customer.getName() );
        customerDTO.favoriteBeer( customer.getFavoriteBeer() );

        return customerDTO.build();
    }

    @Override
    public Customer customerDTOToCustomer(CustomerDTO customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerBuilder customer1 = Customer.builder();

        customer1.id( customer.getId() );
        customer1.name( customer.getName() );
        customer1.favoriteBeer( customer.getFavoriteBeer() );

        return customer1.build();
    }
}
