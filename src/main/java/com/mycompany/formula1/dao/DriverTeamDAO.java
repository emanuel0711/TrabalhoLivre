/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.dao;

import com.mycompany.formula1.model.Driver;
import com.mycompany.formula1.model.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class DriverTeamDAO {

    private final Connection connection;

    public DriverTeamDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Driver> getDriversByTeamId(int teamId) {
        List<Driver> drivers = new ArrayList<>();
        String sql = """
            SELECT d.id, d.name
            FROM drivers d
            INNER JOIN driver_team dt ON d.id = dt.driver_id
            WHERE dt.team_id = ?
        """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, teamId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Driver currentDriver = new Driver(
                    rs.getInt("id"),
                    rs.getString("name"));
                currentDriver.setTeamId(teamId);
                drivers.add(currentDriver);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error retrieving drivers by team: " + e.getMessage());
        }

        return drivers;
    }

    public List<Team> getTeamsByDriverId(int driverId) {
        List<Team> teams = new ArrayList<>();
        String sql = """
            SELECT t.id, t.name, t.country
            FROM teams t
            INNER JOIN driver_team dt ON t.id = dt.team_id
            WHERE dt.driver_id = ?
        """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, driverId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                teams.add(new Team(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("country")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error retrieving teams by driver: " + e.getMessage());
        }

        return teams;
    }

    public void linkDriverToTeam(int driverId, int teamId) {
        String sql = "INSERT INTO driver_team (driver_id, team_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, driverId);
            stmt.setInt(2, teamId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("❌ Error linking driver to team: " + e.getMessage());
        }
    }

    public void unlinkDriverFromTeam(int driverId, int teamId) {
        String sql = "DELETE FROM driver_team WHERE driver_id = ? AND team_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, driverId);
            stmt.setInt(2, teamId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("❌ Error unlinking driver from team: " + e.getMessage());
        }
    }
}

