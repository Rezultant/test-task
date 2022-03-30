package com.java.testtask.controller;

import com.java.testtask.model.Client;
import com.java.testtask.model.Offer;
import com.java.testtask.repo.BankRepo;
import com.java.testtask.repo.ClientRepo;
import com.java.testtask.repo.OfferRepo;
import com.java.testtask.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/offers")
    public ResponseEntity<?> getOffersByClient(@RequestParam Long id){
        return new ResponseEntity(clientService.getOffer(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postClient(@RequestBody Client client){
        return new ResponseEntity(clientService.postClient(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteClient(@RequestParam Long id){
        return new ResponseEntity(clientService.deleteClient(id), HttpStatus.OK);
    }
}