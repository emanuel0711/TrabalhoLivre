/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.controller;

import com.mycompany.formula1.service.TeamService;
import com.mycompany.formula1.database.DatabaseConnection;
import com.mycompany.formula1.model.Team;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author emanu
 */
public class TeamController {
   

    private final TeamService teamService;
    private final Connection connection;

    public TeamController() {
        this.connection = DatabaseConnection.getConnection();
        this.teamService = new TeamService(connection);
    }

    // Método para criar um novo time
    public void createTeam(String name, String country) throws Exception {
        if (name == null || name.isEmpty() || country == null || country.isEmpty()) {
            throw new Exception("Todos os campos precisam estar preenchidos");
        }
        Team team = new Team(name, country);
        teamService.addTeam(team);
        DatabaseConnection.closeConnection();
    }

    // Método para listar todos os times
    public List<Team> getAllTeams() throws Exception {
        List<Team> teams = (List<Team>) teamService.getAllTeams();
        DatabaseConnection.closeConnection();
        return teams;
    }

    // Método para atualizar um time
    public void updateTeam(int id, String name, String country) throws Exception {
        if (name == null || name.isEmpty() || country == null || country.isEmpty()) {
            throw new Exception("Todos os campos precisam estar preenchidos");
        }
        Team team = new Team(id, name, country);
        teamService.updateTeam(team);
        DatabaseConnection.closeConnection();
    }

    // Método para remover um time
    public void deleteTeam(int id) throws Exception {
        teamService.deleteTeam(id);
        DatabaseConnection.closeConnection();
    }
}
