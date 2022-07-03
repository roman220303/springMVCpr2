package com.example.springmvcpr2.models;

import java.util.Objects;

public class Manager {
    //доробити
    private String name;
    private int id;

    public Manager(String name, int id_manager) {
        this.name = name;
        this.id = id_manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void enterAvtoNewCourse(){

    }

    public void enterManuallyNewCourse(){
        float euro;
        float dollar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return id == manager.id && Objects.equals(name, manager.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
