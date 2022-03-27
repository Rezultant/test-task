package com.java.testtask.controller;

import com.java.testtask.model.Credit;
import com.java.testtask.repo.BankRepo;
import com.java.testtask.repo.CreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit")
public class CreditController {
    @Autowired
    CreditRepo creditRepo;
    @Autowired
    BankRepo bankRepo;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(creditRepo.findAll());
    }

    @PostMapping("/post")
    public ResponseEntity<?> postCredit(@RequestBody Credit credit){
        credit.setBank(bankRepo.getById(credit.getBank().getId()));
        creditRepo.save(credit);
        return ResponseEntity.ok(credit);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCredit(@RequestParam Long id){
        creditRepo.delete(creditRepo.getById(id));
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
