package com.mycompany.formula1.database;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author emanu
 */
public class CreateTable {
    public static void createTeams(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS teams (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY," +
                     "name VARCHAR(255) NOT NULL," +
                     "country VARCHAR(255) NOT NULL" +
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
                     "id INT AUTO_INCREMENT PRIMARY KEY," +
                     "name VARCHAR(255) NOT NULL );";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ Table 'drivers' created.");
        } catch (Exception e) {
            System.out.println("❌ Error creating 'drivers': " + e.getMessage());
        }
    }

    public static void createDriverTeam(Connection connection) {
    String sql = "CREATE TABLE IF NOT EXISTS driver_team (" +
                 "driver_id INT NOT NULL," +
                 "team_id INT NOT NULL," +
                 "PRIMARY KEY (driver_id, team_id)," +
                 "FOREIGN KEY (driver_id) REFERENCES drivers(id) ON DELETE CASCADE," +
                 "FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE CASCADE" +
                 ");";

    try (Statement stmt = connection.createStatement()) {
        stmt.execute(sql);
        System.out.println("✅ Table 'driver_team' created.");
    } catch (Exception e) {
        System.out.println("❌ Error creating 'driver_team': " + e.getMessage());
    }
}
    
    
    public static void createRaces(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS races (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY," +
                     "name VARCHAR(255) NOT NULL," +
                     "race_date DATE NOT NULL" +
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
                     "id INT AUTO_INCREMENT PRIMARY KEY," +
                     "driver_id INT," +
                     "race_id INT," +
                     "position INT," +
                     "time TIME," +
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