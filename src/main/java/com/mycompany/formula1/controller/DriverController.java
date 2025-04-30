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

    public String criarDriver(String name, int teamId) {
        if (name == null || name.isEmpty()) {
            return "Driver name cannot be null or empty.";
        }
        if (teamId <= 0) {
            return "Team ID must be a positive integer.";
        }
        driverDAO.addDriver(new Driver(name, teamId));
        return null;

    }

    public List<Driver> listarDrivers() {
        return driverDAO.getAllDrivers();
    }

    public String atualizarDriver(int id, String name, int teamId) {
        if (id <= 0) return "Driver ID must be a positive integer.";
        if (name == null || name.isEmpty()) return "Driver name cannot be null or empty.";
        if (teamId <= 0) return "Team ID must be a positive integer.";
        
        driverDAO.updateDriver(new Driver(id, name, teamId));
        return null;

    }

    public String removerDriver(int id) {
        if (id <= 0) return "Driver ID must be a positive integer.";
        
        driverDAO.deleteDriver(id);
        return null;

    }

    public Driver buscarDriverPorId(int id) {
        if (id <= 0) return null;
        return driverDAO.getDriverById(id);
    }
}
