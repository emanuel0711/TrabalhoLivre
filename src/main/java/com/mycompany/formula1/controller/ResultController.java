/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.controller;

import com.mycompany.formula1.Service.ResultService;
import com.mycompany.formula1.database.ConexaoDatabase;
import com.mycompany.formula1.model.Result;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author emanu
 */
public class ResultController {
   private final ResultService resultService;
    private final Connection connection; // Adicione o campo Connection

    public ResultController() {
        this.connection = ConexaoDatabase.getConnection(); // Obtenha a conexão
        this.resultService = new ResultService(connection); // Passe a conexão para o Service
    }

    // Método para criar um novo resultado
    public void createResult(int raceId, int teamId, int position, int points) throws Exception {
        Result result = new Result(raceId, teamId, position, points);
        resultService.addResult(result);
        ConexaoDatabase.closeConnection();
    }

    // Método para obter um resultado pelo ID
    public Result getResultById(int id) throws Exception {
        Result result = resultService.getResultById(id);
        ConexaoDatabase.closeConnection();
        return result;
    }

    // Método para listar todos os resultados
    public List<Result> getAllResults() throws Exception {
        List<Result> results = resultService.getAllResults();
        ConexaoDatabase.closeConnection();
        return results;
    }

    // Método para atualizar um resultado
    public void updateResult(int id, int raceId, int teamId, int position, int points) throws Exception {
        Result result = new Result(id, raceId, teamId, position, points);
        resultService.updateResult(result);
        ConexaoDatabase.closeConnection();
    }

    // Método para deletar um resultado
    public void deleteResult(int id) throws Exception {
        resultService.deleteResult(id);
        ConexaoDatabase.closeConnection();
    }
}
