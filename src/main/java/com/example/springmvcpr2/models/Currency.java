package com.example.springmvcpr2.models;

import java.util.Objects;

public class Currency {
    int id;
    float value;
    String name;

    public Currency() {
    }

    public Currency(int id, float value, String name) {
        this.id = id;
        this.value = value;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return id == currency.id && Float.compare(currency.value, value) == 0 && Objects.equals(name, currency.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, name);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
