package com.mycompany.formula1.controller;

import com.mycompany.formula1.dao.DriverDAO;
import com.mycompany.formula1.database.DatabaseConnection;
import com.mycompany.formula1.model.Driver;
import java.sql.Connection;
import java.util.List;

public class DriverController {

    private final DriverDAO driverDAO;

    public DriverController() {
        Connection connection = DatabaseConnection.getConnection();
        this.driverDAO = new DriverDAO(connection);
    }

    public String createDriver(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Driver name cannot be null or empty.";
        }
        driverDAO.insertDriver(new Driver(name));
        return null;
    }

    public List<Driver> getAllDrivers() {
        return driverDAO.findAllDrivers();
    }

    public String updateDriver(int id, String name) {
        if (id <= 0) return "Driver ID must be a positive integer.";
        if (name == null || name.trim().isEmpty()) return "Driver name cannot be null or empty.";
        
        driverDAO.updateDriver(new Driver(id, name));
        return null;
    }

    public String deleteDriver(int id) {
        if (id <= 0) return "Driver ID must be a positive integer.";
        driverDAO.deleteDriver(id);
        return null;
    }

    public Driver getDriverById(int id) {
        if (id <= 0) return null;
        return driverDAO.findDriverById(id);
    }
}
