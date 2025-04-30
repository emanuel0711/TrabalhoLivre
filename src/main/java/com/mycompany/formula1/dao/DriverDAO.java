package com.mycompany.formula1.dao;

import com.mycompany.formula1.model.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {

    private final Connection connection;

    public DriverDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertDriver(Driver driver) {
        String sql = "INSERT INTO drivers (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, driver.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting driver: " + e.getMessage());
        }
    }

    public Driver findDriverById(int id) {
        String sql = "SELECT * FROM drivers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Driver(
                    rs.getInt("id"),
                    rs.getString("name")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error finding driver by ID: " + e.getMessage());
        }
        return null;
    }

    public List<Driver> findAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        String sql = "SELECT * FROM drivers";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                drivers.add(new Driver(id, name));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving all drivers: " + e.getMessage());
        }
        return drivers;
    }

    public void updateDriver(Driver driver) {
        String sql = "UPDATE drivers SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, driver.getName());
            stmt.setInt(2, driver.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating driver: " + e.getMessage());
        }
    }

    public void deleteDriver(int id) {
        String sql = "DELETE FROM drivers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting driver: " + e.getMessage());
        }
    }
}
