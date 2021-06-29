package com.sena.inventory.product;


import com.sena.inventory.brand.Brand;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    @DecimalMin(value="1.0")
    private double price;
    @DecimalMin(value="1.0")
    private double cost;
    @ManyToOne
    private Brand brand;
    @Column(columnDefinition = "Boolean default true")
    private boolean status;
    @NotNull
    private int quantity;

    public Product(String name, double price, double cost, Brand brand, boolean status, int quantity) {
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.brand = brand;
        this.status = status;
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Product() {

    }
    public Product(Integer id, String name, double price, double cost, Brand brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.brand = brand;
    }

    public Product(String name, double price, double cost, Brand brand) {
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cost=" + cost +
                ", brand=" + brand +
                '}';
    }
}
