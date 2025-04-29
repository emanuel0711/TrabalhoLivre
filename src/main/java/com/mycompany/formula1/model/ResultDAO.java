package com.mycompany.formula1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emanu
 */
public class ResultDAO {
  private final Connection connection;

    public ResultDAO(Connection connection) {
        this.connection = connection;
    }

    // Adiciona um novo resultado na tabela 'results'
    public void addResult(Result result) throws SQLException {
        String sql = "INSERT INTO results (race_id, team_id, position, points) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, result.getRaceId());
            stmt.setInt(2, result.getTeamId());
            stmt.setInt(3, result.getPosition());
            stmt.setInt(4, result.getPoints());
            stmt.executeUpdate();
        }
    }

    // Recupera um resultado pelo ID
    public Result getResultById(int id) throws SQLException {
        String sql = "SELECT * FROM results WHERE id = ?";
        Result result = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new Result(
                    rs.getInt("id"),
                    rs.getInt("race_id"),
                    rs.getInt("team_id"),
                    rs.getInt("position"),
                    rs.getInt("points")
                );
            }
        }
        return result;
    }

    // Recupera todos os resultados da tabela 'results'
    public List<Result> getAllResults() throws SQLException {
        List<Result> results = new ArrayList<>();
        String sql = "SELECT * FROM results";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                results.add(new Result(
                    rs.getInt("id"),
                    rs.getInt("race_id"),
                    rs.getInt("team_id"),
                    rs.getInt("position"),
                    rs.getInt("points")
                ));
            }
        }
        return results;
    }

    // Atualiza um resultado existente
    public void updateResult(Result result) throws SQLException {
        String sql = "UPDATE results SET race_id = ?, team_id = ?, position = ?, points = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, result.getRaceId());
            stmt.setInt(2, result.getTeamId());
            stmt.setInt(3, result.getPosition());
            stmt.setInt(4, result.getPoints());
            stmt.setInt(5, result.getId());
            stmt.executeUpdate();
        }
    }

    // Deleta um resultado baseado no ID
    public void deleteResult(int id) throws SQLException {
        String sql = "DELETE FROM results WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

