package com.issam.compteservice.repository;

import com.issam.compteservice.entities.bankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<bankAccount,String> {
}
