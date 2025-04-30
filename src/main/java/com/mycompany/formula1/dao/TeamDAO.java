/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.dao;


import com.mycompany.formula1.model.Team;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author emanu
 */
public class TeamDAO {
    private Connection connection;

    public TeamDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar um time
    public void addTeam(Team team) {
        String sql = "INSERT INTO teams (name, country) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, team.getName());
            stmt.setString(2, team.getCountry());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error to add a team: " + e.getMessage());
        }
    }

    // Método para obter um time pelo ID
    public Team getTeamById(int id) {
        String sql = "SELECT * FROM teams WHERE id = ?";
        Team team = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                team = new Team(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("country")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error to get a team: " + e.getMessage());
        }
        return team;
    }

    // Método para listar todos os times
    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM teams";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                teams.add(new Team(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("country")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error to get all teams: " + e.getMessage());
        }
        return teams;
    }

    // Método para atualizar um time
    public void updateTeam(Team team) {
        String sql = "UPDATE teams SET name = ?, country = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, team.getName());
            stmt.setString(2, team.getCountry());
            stmt.setInt(3, team.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error to update a team" + e.getMessage());
        }
    }

    // Método para remover um time
    public void deleteTeam(int id) {
        String sql = "DELETE FROM teams WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error to delete a team " + e.getMessage());
        }
    }
}