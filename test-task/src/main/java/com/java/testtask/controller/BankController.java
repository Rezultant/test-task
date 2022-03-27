package com.java.testtask.controller;


import com.java.testtask.model.*;
import com.java.testtask.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/bank")
public class BankController {
    @Autowired
    ClientRepo clientRepo;

    @Autowired
    BankRepo bankRepo;

    @Autowired
    CreditRepo creditRepo;

    @Autowired
    OfferRepo offerRepo;

    @Autowired
    GraphRepo graphRepo;

    @GetMapping
    public ResponseEntity<?> getAll() throws ParseException {
        return ResponseEntity.ok(bankRepo.findAll());
    }

    @GetMapping("/clients")
    public ResponseEntity<?> getClientsByBank(@RequestParam Long id){
        Set<Client> clients = bankRepo.findById(id).get().getClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/credits")
    public ResponseEntity<?> getCreditsByBank(@RequestParam Long id){
        Set<Credit> credits = bankRepo.findById(id).get().getCredits();
        return ResponseEntity.ok(credits);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postBank(@RequestBody String name){
        Bank bank = new Bank(name);
        bankRepo.save(bank);
        return ResponseEntity.ok(bank);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBank(@RequestParam Long id){
        bankRepo.delete(bankRepo.getById(id));
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
