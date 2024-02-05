package com.issam.compteservice.entities;

import com.issam.compteservice.enums.AccountType;
import com.issam.compteservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class bankAccount {

   @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;

    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Transient
    private Customer customer;
    private Long customerId ;


}
