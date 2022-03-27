package com.java.testtask.repo;

import com.java.testtask.model.Bank;
import com.java.testtask.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepo extends JpaRepository<Credit,Long> {
    List findAll();
    Credit findByBank(Bank bank);
}
