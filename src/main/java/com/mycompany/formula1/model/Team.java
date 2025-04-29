/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.model;

/**
 *
 * @author emanu
 */
public class Team { 
  private int id;
    private String name;
    private String country;

    public Team(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Team(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Team{id=" + id + ", name='" + name + "', country='" + country + "'}";
    }
}