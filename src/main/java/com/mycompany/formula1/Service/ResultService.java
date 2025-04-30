/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formula1.service;

import com.mycompany.formula1.model.Result;
import com.mycompany.formula1.dao.ResultDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author emanu
 */
public class ResultService {
   private final ResultDAO resultDAO;
    private final Connection connection;

    public ResultService(Connection connection) {
        this.connection = connection;
        this.resultDAO = new ResultDAO(connection);
    }

    public void addResult(Result result) throws Exception {
        if (result == null) {
            throw new IllegalArgumentException("Result cannot be null.");
        }
        resultDAO.addResult(result);
    }

    public Result getResultById(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("Result ID must be positive.");
        }
        try {
            Result result = resultDAO.getResultById(id);
            if (result == null) {
                throw new Exception("Result not found");
            }
            return result;
        } catch (SQLException e) {
            throw new Exception("Error getting result: " + e.getMessage(), e);
        }
    }

    public List<Result> getAllResults() throws Exception {
        try {
            return resultDAO.getAllResults();
        } catch (SQLException e) {
            throw new Exception("Error retrieving results: " + e.getMessage(), e);
        }
    }

    public void updateResult(Result result) throws Exception {
        if (result == null || result.getId() <= 0) {
            throw new IllegalArgumentException("Invalid result data.");
        }
        resultDAO.updateResult(result);
    }

    public void deleteResult(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("Result ID must be positive.");
        }
        try {
            resultDAO.deleteResult(id);
        } catch (SQLException e) {
            throw new Exception("Error deleting result: " + e.getMessage(), e);
        }
    }
}
