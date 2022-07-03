package com.example.springmvcpr2.models;

import java.util.Objects;

public class Customer extends User {
    //доробити
    private String name;
    private Long id;

    public Customer(){

    }

    public Customer(String name, Long id_manager) {
        this.name = name;
        this.id = id_manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void displayAvto(){

    }

    public void buyAvto(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

