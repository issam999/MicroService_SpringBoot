package com.issam.compteservice.web;

import com.issam.compteservice.clients.CustomerRestClient;
import com.issam.compteservice.entities.bankAccount;
import com.issam.compteservice.model.Customer;
import com.issam.compteservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public AccountRestController(BankAccountRepository bankAccountRepository,CustomerRestClient customerRestClient)
    {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient=customerRestClient;
    }
    @GetMapping("/accounts")
    public List<bankAccount> accountList()
    {
       return bankAccountRepository.findAll();
    }
    @GetMapping ("/accounts/{id}")
    public bankAccount bankAccountById(@PathVariable String id)
    {

        bankAccount bankaccount=  bankAccountRepository.findById(id).get();
        Customer customer =customerRestClient.findCustomerById(bankaccount.getCustomerId());
        bankaccount.setCustomer(customer);
        return bankaccount;
    }
}
