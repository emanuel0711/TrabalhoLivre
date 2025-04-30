/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.model;

/**
 *
 * @author emanu
 */
public class Driver {

    private int id;
    private String name;

    
    public Driver() {
}

    // Construtor para quando já tem o ID (ex: vindo do banco)
    public Driver(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Construtor para quando está criando um novo Driver (sem ID ainda)
    public Driver(String name) {
        this.name = name;
    }

    // Getters e Setters
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
}


