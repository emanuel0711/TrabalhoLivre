/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.controller;

import com.mycompany.formula1.dao.TeamDAO;
import com.mycompany.formula1.database.DatabaseConnection;
import com.mycompany.formula1.model.Team;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author emanu
 */
public class TeamController {

    private final TeamDAO teamDAO;

    public TeamController() {
        Connection connection = DatabaseConnection.getConnection();
        this.teamDAO = new TeamDAO(connection);
    }

    public String criarTime(String name, String country) {
        if (name == null || name.isBlank()) return "Team name cannot be null or empty.";
        if (country == null || country.isBlank()) return "Country cannot be null or empty.";


        teamDAO.addTeam(new Team(name, country));
        return null;
    }

    public List<Team> listarTimes() {
        return teamDAO.getAllTeams();
    }

    public String atualizarTime(int id, String name, String country) {
        if (id <= 0) return "Team ID must be a positive integer.";
        if (name == null || name.isBlank()) return "Team name cannot be null or empty.";
        if (country == null || country.isBlank()) return "Country cannot be null or empty.";

        teamDAO.updateTeam(new Team(id, name, country));
        return null;
    }

    public String removerTime(int id) {
        if (id <= 0) return "Team ID must be a positive integer.";

        teamDAO.deleteTeam(id);
        return null;
    }

    public Team buscarTimePorId(int id) {
        if (id <= 0) return null;
        return teamDAO.getTeamById(id);
    }
}
