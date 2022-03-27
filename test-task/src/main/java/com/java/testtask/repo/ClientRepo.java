package com.java.testtask.repo;

import com.java.testtask.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
    List findAll();
    Client findByFullName(String fullName);
    Client findByPhoneNumber(String phoneNumber);
}
