package com.mycompany.formula1.controller;

import com.mycompany.formula1.service.DriverService;
import com.mycompany.formula1.database.DatabaseConnection;
import com.mycompany.formula1.model.Driver;
import java.sql.Connection;
import java.util.List;

public class DriverController {

    private final DriverService driverService;
    private final Connection connection;

    public DriverController() {
        this.connection = DatabaseConnection.getConnection();
        this.driverService = new DriverService(connection);
    }

    public String criarDriver(String name, int teamId) {
        try {
            driverService.addDriver(name, teamId);
            connection.commit();
            return null;
        } catch (Exception e) {
            try { connection.rollback(); } catch (Exception ex) {}
            return e.getMessage();
        } finally {
            DatabaseConnection.closeConnection();
        }
    }

    public List<Driver> listarDrivers() {
        try {
            List<Driver> drivers = driverService.getAllDrivers();
            connection.commit();
            return drivers;
        } catch (Exception e) {
            try { connection.rollback(); } catch (Exception ex) {}
            return null; 
        } finally {
            DatabaseConnection.closeConnection();
        }
    }

    public String atualizarDriver(int id, String name, int teamId) {
        try {
            driverService.updateDriver(id, name, teamId);
            connection.commit();
            return null;
        } catch (Exception e) {
            try { connection.rollback(); } catch (Exception ex) {}
            return e.getMessage();
        } finally {
            DatabaseConnection.closeConnection();
        }
    }

    public String removeDriver(int id) {
        try {
            driverService.deleteDriver(id);
            connection.commit();
            return null;
        } catch (Exception e) {
            try { connection.rollback(); } catch (Exception ex) {}
            return e.getMessage();
        } finally {
            DatabaseConnection.closeConnection();
        }
    }
}
