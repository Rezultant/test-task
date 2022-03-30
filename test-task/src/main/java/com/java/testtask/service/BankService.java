package com.java.testtask.service;

import com.java.testtask.model.Bank;
import com.java.testtask.model.Client;
import com.java.testtask.model.Credit;
import com.java.testtask.repo.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BankService {
    @Autowired
    BankRepo bankRepo;

    public List<Bank> getAllBanks(){
        return bankRepo.findAll();
    }

    public Set<Client> getClientsByBank(Long id){
        Set<Client> clients = bankRepo.getById(id).getClients();
        return clients;
    }

    public Set<Credit> getCreditsByBank(Long id){
        Set<Credit> credits = bankRepo.getById(id).getCredits();
        return credits;
    }

    public Bank postBank(String name){
        Bank bank = new Bank(name);
        bankRepo.save(bank);
        return bank;
    }

    public Long deleteBank(Long id){
        bankRepo.delete(bankRepo.getById(id));
        return id;
    }
}
