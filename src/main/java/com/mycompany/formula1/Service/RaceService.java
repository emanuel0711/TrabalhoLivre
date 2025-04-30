package com.mycompany.formula1.service;

import com.mycompany.formula1.model.Race;
import com.mycompany.formula1.dao.RaceDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author emanu
 */
public class RaceService {
private final RaceDAO raceDAO;
    private final Connection connection;

    public RaceService(Connection connection) {
        this.connection = connection;
        this.raceDAO = new RaceDAO(connection); 
    }

    public void addRace(String name) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Race name cannot be null or empty.");
        }
        try {
            Race race = new Race(name);
            raceDAO.addRace(race);
        } catch (SQLException e) {
            throw new Exception("Error adding race: " + e.getMessage(), e);
        }
    }

    public Race getRaceById(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("Race ID must be positive.");
        }
        try {
            Race race = raceDAO.getRaceById(id);
            if (race == null) {
                throw new Exception("Race not found");
            }
            return race;
        } catch (SQLException e) {
            throw new Exception("Error getting race: " + e.getMessage(), e);
        }
    }

    public List<Race> getAllRaces() throws Exception {
        try {
            return raceDAO.getAllRaces();
        } catch (SQLException e) {
            throw new Exception("Error retrieving races: " + e.getMessage(), e);
        }
    }

    public void updateRace(int id, String name) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("Race ID must be positive.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Race name cannot be null or empty.");
        }
        try {
            Race race = new Race(id, name);
            raceDAO.updateRace(race);
        } catch (SQLException e) {
            throw new Exception("Error updating race: " + e.getMessage(), e);
        }
    }

    public void deleteRace(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("Race ID must be positive.");
        }
        try {
            raceDAO.deleteRace(id);
        } catch (SQLException e) {
            throw new Exception("Error deleting race: " + e.getMessage(), e);
        }
    }
}
