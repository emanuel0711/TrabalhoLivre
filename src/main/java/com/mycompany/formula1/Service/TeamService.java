/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.service;

import com.mycompany.formula1.model.Team;
import com.mycompany.formula1.dao.TeamDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author emanu
 */
public class TeamService {
    private final TeamDAO teamDAO;
    private final Connection connection;

    public TeamService(Connection connection) {
        this.connection = connection;
        this.teamDAO = new TeamDAO(connection);
    }

    public void addTeam(Team team) throws Exception {
        if (team == null || team.getName() == null || team.getName().isEmpty()) {
            throw new IllegalArgumentException("Team data is invalid.");
        }
        teamDAO.addTeam(team);
    }

    public Team getTeamById(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("Team ID must be positive.");
        }
        try {
            Team team = teamDAO.getTeamById(id);
            if (team == null) {
                throw new Exception("Team not found");
            }
            return team;
        } catch (SQLException e) {
            throw new Exception("Error getting team: " + e.getMessage(), e);
        }
    }

    public List<Team> getAllTeams() throws Exception {
        return teamDAO.getAllTeams();
    }

    public void updateTeam(Team team) throws Exception {
        if (team == null || team.getId() <= 0) {
            throw new IllegalArgumentException("Invalid team data.");
        }
        teamDAO.updateTeam(team);
    }

    public void deleteTeam(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("Team ID must be positive.");
        }
        teamDAO.deleteTeam(id);
    }
}
