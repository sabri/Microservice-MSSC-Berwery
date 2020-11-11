package com.sabrouch.msscbrewery.web.controller;

import com.sabrouch.msscbrewery.web.model.CustomerDto;
import com.sabrouch.msscbrewery.web.server.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


/**
 * Created by sabrouch.
 * Date: 11/8/2020
 */
@RestController
@RequestMapping("/api/v1/customer")
public class Customer {

    private final CustomerService customerService;

    public Customer(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{CustomerId}")
    public ResponseEntity<CustomerDto>getCustomer(@PathVariable("CustomerId") UUID CustomerId){
        return new ResponseEntity<>(customerService.getCustomerById(CustomerId), HttpStatus.OK);
    }

    
}
