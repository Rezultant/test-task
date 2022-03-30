package com.java.testtask.service;

import com.java.testtask.model.Credit;
import com.java.testtask.repo.BankRepo;
import com.java.testtask.repo.CreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditService {
    @Autowired
    CreditRepo creditRepo;

    @Autowired
    BankRepo bankRepo;

    public Credit postCredit(Credit credit){
        credit.setBank(bankRepo.getById(credit.getBank().getId()));
        creditRepo.save(credit);
        return credit;
    }

    public Long deleteCredit(Long id){
        creditRepo.delete(creditRepo.getById(id));
        return id;
    }
}
