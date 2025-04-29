/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.model;

/**
 *
 * @author emanu
 */

public class Result {
   private int id;
    private int raceId;
    private int teamId;
    private int position;
    private int points;

    public Result(int id, int raceId, int teamId, int position, int points) {
        this.id = id;
        this.raceId = raceId;
        this.teamId = teamId;
        this.position = position;
        this.points = points;
    }

     public Result(int raceId, int teamId, int position, int points) {
        this.raceId = raceId;
        this.teamId = teamId;
        this.position = position;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
