package com.mycompany.formula1.controller;

import com.mycompany.formula1.model.Race;
import com.mycompany.formula1.service.RaceService;
import com.mycompany.formula1.database.DatabaseConnection;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author emanu
 */
public class RaceController {
    private final RaceService raceService;

    public RaceController() {
        // Obtenha a conexão do banco de dados e passe para o serviço
        Connection connection = DatabaseConnection.getConnection();
        this.raceService = new RaceService(connection);
    }

    public void createRace(String name) throws Exception {
        raceService.addRace(name);
    }

    public List<Race> getRaces() throws Exception {
        return raceService.getAllRaces();
    }

    public void updateRace(int id, String name) throws Exception {
        raceService.updateRace(id, name);
    }

    public void deleteRace(int id) throws Exception {
        raceService.deleteRace(id);
    }
}
