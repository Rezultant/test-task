package com.java.testtask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "credit")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Credit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "limit")
    private int limit;

    @Column(name = "percent")
    private int percent;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Bank bank;

    @JsonIgnore
    @OneToMany(mappedBy = "credit")
    private Set<Offer> offers;

    public Credit() {

    }

    public Credit(int limit, int percent, Bank bank) {
        this.limit = limit;
        this.percent = percent;
        this.bank = bank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
