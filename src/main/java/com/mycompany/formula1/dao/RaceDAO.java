package com.mycompany.formula1.dao;


import com.mycompany.formula1.model.Race;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emanu
 */
public class RaceDAO {
   private final Connection connection;

    public RaceDAO(Connection connection) {
        this.connection = connection;
    }

    public void addRace(Race race) throws SQLException {
        String sql = "INSERT INTO races (name) VALUES (?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, race.getName());
            stmt.executeUpdate();
        }
    }

    public Race getRaceById(int id) throws SQLException {
        String sql = "SELECT * FROM races WHERE id = ?";
        Race race = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                race = new Race(
                    rs.getInt("id"),
                    rs.getString("name")
                );
            }
        }

        return race;
    }

    public List<Race> getAllRaces() throws SQLException {
        List<Race> races = new ArrayList<>();
        String sql = "SELECT * FROM races";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                races.add(new Race(
                    rs.getInt("id"),
                    rs.getString("name")
                ));
            }
        }

        return races;
    }

    public void updateRace(Race race) throws SQLException {
        String sql = "UPDATE races SET name = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, race.getName());
            stmt.setInt(2, race.getId());
            stmt.executeUpdate();
        }
    }

  public void deleteRace(int id) throws SQLException {
    String sql = "DELETE FROM races WHERE id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();
        }
    }

}