/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.model;
    
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author emanu
 */


public class DriverDAO {

    private Connection connection;

    public DriverDAO(Connection connection) {
        this.connection = connection;
    }

    public void addDriver(Driver driver) throws SQLException {
        String sql = "INSERT INTO drivers (name, team_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, driver.getName());
            stmt.setInt(2, driver.getTeamId());
            stmt.executeUpdate();
        }
    }

    public Driver getDriverById(int id) throws SQLException{
        String sql = "SELECT * FROM drivers WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new Driver(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("team_id")
                );
            }
            return null;
        }
    }

    public List<Driver> getAllDrivers() throws SQLException {
        List<Driver> drivers = new ArrayList<>();
        String sql = "SELECT * FROM drivers";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int teamId = rs.getInt("team_id");
                drivers.add(new Driver(id, name, teamId));
            }
        }
        return drivers;
    }

    public void updateDriver(Driver driver) throws SQLException {
        String sql = "UPDATE drivers SET name = ?, team_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, driver.getName());
            stmt.setInt(2, driver.getTeamId());
            stmt.setInt(3, driver.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteDriver(int id) throws SQLException {
        String sql = "DELETE FROM drivers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}





