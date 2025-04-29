/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.controller;

import com.mycompany.formula1.Service.DriverService;
import com.mycompany.formula1.database.ConexaoDatabase;
import com.mycompany.formula1.model.Driver;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author emanu
 */


public class DriverController {

     private final DriverService driverService;
    private final Connection connection;

    public DriverController() {
        this.connection = ConexaoDatabase.getConnection();
        this.driverService = new DriverService(connection);
    }

    public void criarDriver(String nome, int teamId) throws Exception {
        try {
            driverService.addDriver(nome, teamId);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e; // Relança a exceção para ser tratada na View
        } finally {
            ConexaoDatabase.closeConnection(); // Fecha a conexão no finally
        }
    }

    public List<Driver> listarDrivers() throws Exception {
         try {
            List<Driver> drivers = driverService.getAllDrivers();
            connection.commit();
            return drivers;
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            ConexaoDatabase.closeConnection();
        }
    }

    public void atualizarDriver(int id, String nome, int teamId) throws Exception {
        try {
            driverService.updateDriver(id, nome, teamId);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
           ConexaoDatabase.closeConnection();
        }
    }

    public void removerDriver(int id) throws Exception {
        try {
            driverService.deleteDriver(id);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            ConexaoDatabase.closeConnection();
        }
    }
}
