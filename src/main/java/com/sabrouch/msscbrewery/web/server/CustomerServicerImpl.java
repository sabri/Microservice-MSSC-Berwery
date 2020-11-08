package com.sabrouch.msscbrewery.web.server;

import com.sabrouch.msscbrewery.web.model.CustomerDto;
import com.sabrouch.msscbrewery.web.model.SodaDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by sabrouch.
 * Date: 11/8/2020
 */
@Service
public class CustomerServicerImpl  implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("sabri")
                .build();
    }
}
