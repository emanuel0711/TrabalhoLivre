/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.formula1;

import com.mycompany.formula1.database.CreateTable;
import com.mycompany.formula1.database.DatabaseConnection;
import com.mycompany.formula1.view.InitialScreen;

import java.sql.Connection;

/**
 *
 * @author emanu
 */
public class App {

      public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        
        CreateTable.createTeams(connection);
        CreateTable.createDrivers(connection);
        CreateTable.createRaces(connection);
        CreateTable.createRaceResults(connection);
        
        System.out.println("🏁 Banco de dados e tabelas criados com sucesso!");
        
        new InitialScreen().setVisible(true);
    }
}
