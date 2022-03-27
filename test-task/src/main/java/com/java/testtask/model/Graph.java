package com.java.testtask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "graph")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Graph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "month")
    private int months;

    @Column(name = "value")
    private int value;

    @Column(name = "body")
    private int body;

    @Column(name = "percent")
    private int percent;

    public Graph() {

    }

    public Graph(Date date, int months, int value, int body, int percent) {
        this.date = date;
        this.months = months;
        this.value = value;
        this.body = body;
        this.percent = percent;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
