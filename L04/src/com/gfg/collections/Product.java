package com.gfg.collections;

import java.util.Objects;

public class Product implements Comparable {

    private String name;

    private Double cost;

    private Integer rating;

    public Integer getRating() {
        return rating;
    }

    public Product(String name, Double cost, Integer rating) {
        this.name = name;
        this.cost = cost;
        this.rating = rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public Product(String name, Double cost) {
        this.name = name;
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return cost.compareTo(((Product)o).getCost());
       // return name.compareTo(((Product)o).getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(cost, product.cost) && Objects.equals(rating, product.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, rating);
    }
}
