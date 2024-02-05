package com.issam.compteservice;

import com.issam.compteservice.clients.CustomerRestClient;
import com.issam.compteservice.entities.bankAccount;
import com.issam.compteservice.enums.AccountType;
import com.issam.compteservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class CompteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository , CustomerRestClient customerRestClient)
    {

        return args ->{
            customerRestClient.allCustomers().forEach(c ->
                    {
                        bankAccount bankAccount1 = bankAccount.builder()
                                .accountId(UUID.randomUUID().toString())
                                .currency("MAD")
                                .balance(Math.random()*35014)
                                .createdAt(LocalDate.now())
                                .type(AccountType.CURRENT_ACCOUNT)
                                .customerId(c.getId())

                                .build();


                        bankAccount bankAccount2 = bankAccount.builder()
                                .accountId(UUID.randomUUID().toString())
                                .currency("MAD")
                                .balance(Math.random()*80000)
                                .createdAt(LocalDate.now())
                                .type(AccountType.SAVING_ACCOUNT)
                                .customerId(c.getId())

                                .build();
                        bankAccountRepository.save(bankAccount1);
                        bankAccountRepository.save(bankAccount2);
                    }




                    );






        };
    }
}
