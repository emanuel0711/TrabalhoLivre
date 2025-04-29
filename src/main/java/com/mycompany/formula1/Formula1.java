/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.formula1;

import com.mycompany.formula1.Database.CreateTable;
import com.mycompany.formula1.database.ConexaoDatabase;
import java.sql.Connection;

/**
 *
 * @author emanu
 */
public class Formula1 {

      public static void main(String[] args) {
        Connection connection = ConexaoDatabase.getConnection();
        
        CreateTable.createTeams(connection);
        CreateTable.createDrivers(connection);
        CreateTable.createRaces(connection);
        CreateTable.createRaceResults(connection);
        
        System.out.println("🏁 Banco de dados e tabelas criados com sucesso!");

        ConexaoDatabase.closeConnection();
    }
}
