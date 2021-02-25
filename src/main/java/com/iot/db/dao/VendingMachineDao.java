package com.iot.db.dao;

import static com.iot.db.dao.Constants.*;

import com.iot.db.entity.VendingMachine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineDao implements GeneralDAO<VendingMachine, Integer> {
    private static final String getAllQuery = "SELECT * FROM vending_machine";
    private static final String getByIdQuery = "SELECT * FROM vending_machine WHERE id = ?";
    private static final String createQuery = "INSERT INTO vending_machine (adress) VALUES (?)";
    private static final String deleteQuery = "DELETE FROM vending_machine WHERE id = ?";
    private static final String updateQuery = "UPDATE vending_machine SET adress = ? WHERE id = ?";

    @Override
    public List<VendingMachine> getAll() {
        List<VendingMachine> vendingMachines = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAllQuery)) {
            while (resultSet.next()) {
                VendingMachine vendingMachine = new VendingMachine();
                vendingMachine.setId(resultSet.getInt("id"));
                vendingMachine.setAdress(resultSet.getString("adress"));
                vendingMachines.add(vendingMachine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendingMachines;
    }

    @Override
    public VendingMachine getById(Integer id) {
        VendingMachine vendingMachine = new VendingMachine();
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection.prepareStatement(getByIdQuery)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vendingMachine.setId(id);
                vendingMachine.setAdress(resultSet.getString("adress"));
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
        return vendingMachine;
    }

    @Override
    public String create(VendingMachine createObj) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection
                 .prepareStatement(createQuery)) {
            statement.setString(1, createObj.getAdress());
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
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result != 0 ? "Success" : "Fail";
    }

    @Override
    public String update(VendingMachine updateObj) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection
                 .prepareStatement(updateQuery)) {
            statement.setString(1, updateObj.getAdress());
            statement.setInt(2, updateObj.getId());
            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result != 0 ? "Success" : "Fail";
    }
}
