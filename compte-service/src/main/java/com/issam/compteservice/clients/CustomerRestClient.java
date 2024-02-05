package com.issam.compteservice.clients;

import com.issam.compteservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CLIENT-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")

    @CircuitBreaker(name= "customerService" , fallbackMethod = "getDefaultCustomer")

    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    @CircuitBreaker(name= "customerService" , fallbackMethod = "getDefaultListCustomer")

    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception)
    {
        Customer customer= new Customer();
        customer.setFirstName("Not Found");
        customer.setLasttName("Not Found");
        customer.setEmail("Not Found");
        return customer;
    }
    default List<Customer> getDefaultListCustomer (Exception exception )
    {
        return List.of();
    }

}
