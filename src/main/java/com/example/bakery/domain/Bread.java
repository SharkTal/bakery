package com.example.bakery.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Bread {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name, brand;
    private double price;
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "type")
    private Type type;

    public Bread(){}

    public Bread(String name, String brand, double price, int quantity, Type type) {
        super();
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


}
