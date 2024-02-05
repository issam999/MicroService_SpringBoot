package com.issam.clientservice.web;

import com.issam.clientservice.entities.customer;
import com.issam.clientservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CustomerRestController {

    private CustomerRepository customerRepository;
    private CustomerRestController (CustomerRepository customerRepository)
    {
        this.customerRepository=customerRepository;
    }

    @GetMapping("/customers")
    public List<customer> customerList ()
    {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public customer customerById (@PathVariable  Long id)
    {
        return customerRepository.findById(id).get();
    }



}
