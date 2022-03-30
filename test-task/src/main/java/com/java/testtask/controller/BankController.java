package com.java.testtask.controller;


import com.java.testtask.model.*;
import com.java.testtask.repo.*;
import com.java.testtask.service.BankService;
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
    BankService bankService;

    @GetMapping
    public ResponseEntity<?> getAll() throws ParseException {
        return new ResponseEntity(bankService.getAllBanks(), HttpStatus.OK);
    }

    @GetMapping("/clients")
    public ResponseEntity<?> getClientsByBank(@RequestParam Long id){
        return new ResponseEntity(bankService.getClientsByBank(id), HttpStatus.OK);
    }

    @GetMapping("/credits")
    public ResponseEntity<?> getCreditsByBank(@RequestParam Long id){
        return new ResponseEntity(bankService.getCreditsByBank(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postBank(@RequestBody String name){
        return new ResponseEntity(bankService.postBank(name), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBank(@RequestParam Long id){
        return new ResponseEntity(bankService.deleteBank(id), HttpStatus.OK);
    }
}
