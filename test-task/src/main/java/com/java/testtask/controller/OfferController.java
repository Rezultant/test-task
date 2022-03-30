package com.java.testtask.controller;

import com.java.testtask.model.Graph;
import com.java.testtask.model.Offer;
import com.java.testtask.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/api/offer")
public class OfferController {

    @Autowired
    OfferService offerService;

    @GetMapping("/graph")
    public ResponseEntity<?> getGraphByOffer(@RequestParam Long id){
        return new ResponseEntity(offerService.getGraph(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postCredit(@RequestBody Offer offer){
        return new ResponseEntity(offerService.postOffer(offer), HttpStatus.CREATED);
    }
}