package com.java.testtask.controller;

import com.java.testtask.model.Client;
import com.java.testtask.model.Offer;
import com.java.testtask.repo.BankRepo;
import com.java.testtask.repo.ClientRepo;
import com.java.testtask.repo.OfferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    OfferRepo offerRepo;
    @Autowired
    BankRepo bankRepo;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(clientRepo.findAll());
    }

    @GetMapping("/offers")
    public ResponseEntity<?> getOffersByClient(@RequestParam Long id){
        Set<Offer> offers = clientRepo.findById(id).get().getOffers();
        return ResponseEntity.ok(offers);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postClient(@RequestBody Client client){
        client.setBank(bankRepo.getById(client.getBank().getId()));
        clientRepo.save(client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteClient(@RequestParam Long id){
        clientRepo.delete(clientRepo.getById(id));
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}