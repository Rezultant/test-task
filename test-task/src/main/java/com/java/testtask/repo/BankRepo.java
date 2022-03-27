package com.java.testtask.repo;

import com.java.testtask.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepo extends JpaRepository<Bank,Long> {
    List findAll();
    Bank findByName(String name);
}
