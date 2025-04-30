/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.service;

import com.mycompany.formula1.model.Driver;
import com.mycompany.formula1.dao.DriverDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author emanu
 */
public class DriverService {
 
   private final DriverDAO driverDAO;
    private final Connection connection;

    public DriverService(Connection connection) {
        this.connection = connection;
        this.driverDAO = new DriverDAO(connection);
    }

    public void addDriver(String name, int teamId) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Driver name cannot be null or empty.");
        }
        if (teamId <= 0) {
            throw new IllegalArgumentException("Team ID must be a positive integer.");
        }
       
        try {
            Driver driver = new Driver(name, teamId);
            driverDAO.addDriver(driver);
        } catch (SQLException e) {
            throw new Exception("Error adding driver: " + e.getMessage(), e); 
        }
    }

     public Driver getDriverById(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("Driver ID must be a positive integer.");
        }
        try {
            Driver driver = driverDAO.getDriverById(id);
            if (driver == null) {
                throw new Exception("Driver not found.");
            }
            return driver;
        } catch (SQLException e) {
           throw new Exception("Error getting driver: " + e.getMessage(), e);
        }
    }

    public List<Driver> getAllDrivers() throws Exception {
        try {
            return driverDAO.getAllDrivers();
        } catch (SQLException e) {
            throw new Exception("Error retrieving drivers: " + e.getMessage(), e);
        }
    }

    public void updateDriver(int id, String name, int teamId) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("Driver ID must be a positive integer.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Driver name cannot be null or empty.");
        }
        if (teamId <= 0) {
             throw new IllegalArgumentException("Team ID must be a positive integer.");
        }
      
        try {
            Driver driver = new Driver(id, name, teamId);
            driverDAO.updateDriver(driver);
        } catch (SQLException e) {
            throw new Exception("Error updating driver: " + e.getMessage(), e);
        }
    }

    public void deleteDriver(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("Driver ID must be a positive integer.");
        }
        try {
            driverDAO.deleteDriver(id);
        } catch (SQLException e) {
            throw new Exception("Error deleting driver: " + e.getMessage(), e);
        }
    }
}


