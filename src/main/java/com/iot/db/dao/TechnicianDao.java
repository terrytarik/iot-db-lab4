package com.iot.db.dao;

import static com.iot.db.dao.Constants.*;

import com.iot.db.entity.Technician;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TechnicianDao implements GeneralDAO<Technician, Integer> {
    private static final String getAllQuery = "SELECT * FROM technician";
    private static final String getByIdQuery = "SELECT * FROM technician WHERE id = ?";
    private static final String createQuery = "INSERT INTO technician (name, surname) VALUE (?, ?)";
    private static final String deleteQuery = "DELETE FROM technician WHERE id = ?";
    private static final String updateQuery = "UPDATE technician SET name = ?, surname = ? WHERE id = ?";

    @Override
    public List<Technician> getAll() {
        List<Technician> technicians = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAllQuery)) {
            while (resultSet.next()) {
                Technician technician = new Technician();
                technician.setId(resultSet.getInt("id"));
                technician.setName(resultSet.getString("name"));
                technician.setSurname(resultSet.getString("surname"));
                technicians.add(technician);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return technicians;
    }

    @Override
    public Technician getById(Integer id) {
        Technician technician = new Technician();
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection.prepareStatement(getByIdQuery)) {
            statement.setString(1, String.valueOf(id));
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                technician.setId(id);
                technician.setName(resultSet.getString("name"));
                technician.setSurname(resultSet.getString("surname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return technician;
    }

    @Override
    public String create(Technician createObj) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection.prepareStatement(createQuery)) {
            statement.setString(1, createObj.getName());
            statement.setString(2, createObj.getSurname());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result != 0 ? "Success" : "Fail";
    }

    @Override
    public String deleteById(Integer id) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection.prepareStatement(deleteQuery);) {
            statement.setInt(1, id);
            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result != 0 ? "Success" : "Fail";
    }

    @Override
    public String update(Technician updateObj) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, updateObj.getName());
            statement.setString(2, updateObj.getSurname());
            statement.setInt(3, updateObj.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result != 0 ? "Success" : "Fail";
    }
}
