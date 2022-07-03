package com.example.springmvcpr2.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class Avto {

    private String marka;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int number;
    private float price;
    private int currency;

    public Avto(){

    }

    public Avto(String marka, int id, int number, float price, int currency) {
        this.marka = marka;
        this.id = id;
        this.number = number;
        this.price = price;
        this.currency = currency;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avto avto = (Avto) o;
        return id == avto.id && number == avto.number && Float.compare(avto.price, price) == 0 && currency == avto.currency && Objects.equals(marka, avto.marka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marka, id, number, price, currency);
    }

    @Override
    public String toString() {
        return "Avto{" +
                "marka='" + marka + '\'' +
                ", id=" + id +
                ", number=" + number +
                ", price=" + price +
                ", currency=" + currency +
                '}';
    }
}
