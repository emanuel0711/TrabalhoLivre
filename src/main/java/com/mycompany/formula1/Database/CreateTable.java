package com.mycompany.formula1.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author emanu
 */
public class CreateTable {


public class ConexaoDatabase {
 private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:formula1.db");
            } catch (SQLException e) {
                System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
    public static void createTeams(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS teams (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "name TEXT NOT NULL," +
                     "country TEXT NOT NULL" +
                     ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ Table 'teams' created.");
        } catch (Exception e) {
            System.out.println("❌ Error creating 'teams': " + e.getMessage());
        }
    }

    public static void createDrivers(Connection connection) {
     String sql = "CREATE TABLE IF NOT EXISTS drivers (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "name TEXT NOT NULL," +
        "team INTEGER," +  
        "FOREIGN KEY (team) REFERENCES teams(id) ON DELETE CASCADE" + 
        ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ Table 'drivers' created.");
        } catch (Exception e) {
            System.out.println("❌ Error creating 'drivers': " + e.getMessage());
        }
    }

    public static void createRaces(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS races (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "name TEXT NOT NULL," +
                     "race_date TEXT NOT NULL" +   // Armazena como string: "2025-04-28"
                     ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ Table 'races' created.");
        } catch (Exception e) {
            System.out.println("❌ Error creating 'races': " + e.getMessage());
        }
    }

    public static void createRaceResults(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS race_results (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "driver_id INTEGER," +
                     "race_id INTEGER," +
                     "position INTEGER," +
                     "time TEXT," +   // Armazena como string: "01:23:45"
                     "FOREIGN KEY (driver_id) REFERENCES drivers(id) ON DELETE CASCADE," +
                     "FOREIGN KEY (race_id) REFERENCES races(id) ON DELETE CASCADE" +
                     ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ Table 'race_results' created.");
        } catch (Exception e) {
            System.out.println("❌ Error creating 'race_results': " + e.getMessage());
        }
    }
}
