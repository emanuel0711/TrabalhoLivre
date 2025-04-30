/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.controller;

import com.mycompany.formula1.dao.DriverTeamDAO;
import com.mycompany.formula1.database.DatabaseConnection;
import com.mycompany.formula1.model.Driver;
import com.mycompany.formula1.model.Team;
import java.sql.Connection;
import java.util.List;

public class DriverTeamController {

    private final DriverTeamDAO driverTeamDAO;

    public DriverTeamController() {
        Connection connection = DatabaseConnection.getConnection();
        this.driverTeamDAO = new DriverTeamDAO(connection);
    }

    public String linkDriverToTeam(int driverId, int teamId) {
        if (driverId <= 0) return "Driver ID must be a positive integer.";
        if (teamId <= 0) return "Team ID must be a positive integer.";

        driverTeamDAO.linkDriverToTeam(driverId, teamId);
        return null;
    }

    public String unlinkDriverFromTeam(int driverId, int teamId) {
        if (driverId <= 0) return "Driver ID must be a positive integer.";
        if (teamId <= 0) return "Team ID must be a positive integer.";

        driverTeamDAO.unlinkDriverFromTeam(driverId, teamId);
        return null;
    }

    public List<Driver> getDriversByTeamId(int teamId) {
        if (teamId <= 0) return List.of();
        return driverTeamDAO.getDriversByTeamId(teamId);
    }

    public List<Team> getTeamsByDriverId(int driverId) {
        if (driverId <= 0) return List.of();
        return driverTeamDAO.getTeamsByDriverId(driverId);
    }
}

