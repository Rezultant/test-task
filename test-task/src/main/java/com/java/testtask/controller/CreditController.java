package com.java.testtask.controller;

import com.java.testtask.model.Credit;
import com.java.testtask.repo.BankRepo;
import com.java.testtask.repo.CreditRepo;
import com.java.testtask.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit")
public class CreditController {

    @Autowired
    CreditService creditService;

    @PostMapping("/post")
    public ResponseEntity<?> postCredit(@RequestBody Credit credit){
        return new ResponseEntity(creditService.postCredit(credit), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCredit(@RequestParam Long id){
        return new ResponseEntity(creditService.deleteCredit(id),HttpStatus.OK);
    }
}
