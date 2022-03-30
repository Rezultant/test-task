package com.java.testtask.service;

import com.java.testtask.model.Client;
import com.java.testtask.model.Offer;
import com.java.testtask.repo.BankRepo;
import com.java.testtask.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ClientService {
    @Autowired
    ClientRepo clientRepo;

    @Autowired
    BankRepo bankRepo;

    public Set<Offer> getOffer(Long id){
        Set<Offer> offers = clientRepo.getById(id).getOffers();
        return offers;
    }

    public Client postClient(Client client){
        client.setBank(bankRepo.getById(client.getBank().getId()));
        clientRepo.save(client);
        return client;
    }

    public Long deleteClient(Long id){
        clientRepo.delete(clientRepo.getById(id));
        return id;
    }
}
