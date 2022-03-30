package com.java.testtask.service;

import com.java.testtask.model.Graph;
import com.java.testtask.model.Offer;
import com.java.testtask.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    @Autowired
    ClientRepo clientRepo;

    @Autowired
    CreditRepo creditRepo;

    @Autowired
    OfferRepo offerRepo;

    @Autowired
    GraphRepo graphRepo;

    public Graph getGraph(Long id){
        Graph graph = offerRepo.findById(id).get().getGraph();
        return graph;
    }

    public Offer postOffer(Offer offer){
        Graph graph = offer.getGraph();
        graphRepo.save(graph);
        offer.setCredit(creditRepo.getById(offer.getCredit().getId()));
        offer.setClient(clientRepo.getById(offer.getClient().getId()));
        offerRepo.save(offer);
        return offer;
    }
}
