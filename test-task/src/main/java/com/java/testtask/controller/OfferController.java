package com.java.testtask.controller;

import com.java.testtask.model.Credit;
import com.java.testtask.model.Graph;
import com.java.testtask.model.Offer;
import com.java.testtask.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/api/offer")
public class OfferController {
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
    @GetMapping("/graph")
    public ResponseEntity<?> getGraphByOffer(@RequestParam Long id){
        Graph graph = offerRepo.findById(id).get().getGraph();
        return ResponseEntity.ok(graph);
    }
    @PostMapping("/post")
    public ResponseEntity<?> postCredit(@RequestBody Offer offer){
        Graph graph = offer.getGraph();
        graphRepo.save(graph);
        offer.setCredit(creditRepo.getById(offer.getCredit().getId()));
        offer.setClient(clientRepo.getById(offer.getClient().getId()));
        offerRepo.save(offer);
        return ResponseEntity.ok(offer);
    }
}