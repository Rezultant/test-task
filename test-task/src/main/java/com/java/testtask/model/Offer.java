package com.java.testtask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "offer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Credit credit;

    @Column(name = "value")
    private int value;


    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "graph_id")
    private Graph graph;

    public Offer() {

    }

    public Offer(Client client, Credit credit, int value, Graph graph) {
        this.client = client;
        this.credit = credit;
        this.value = value;
        this.graph = graph;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
