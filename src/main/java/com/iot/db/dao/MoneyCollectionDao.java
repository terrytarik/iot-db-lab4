package com.iot.db.dao;

import static com.iot.db.dao.Constants.*;

import com.iot.db.entity.MoneyCollection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MoneyCollectionDao implements GeneralDAO<MoneyCollection, String> {
    private static final String getAllQuery = "SELECT * FROM money_collection";
    private static final String getByIdQuery = "SELECT * FROM money_collection WHERE last_collection = ?";
    private static final String createQuery =
        "INSERT INTO money_collection (last_collection, money_amount, vending_machine_id) values (?, ?, ?)";
    private static final String deleteQuery = "DELETE FROM money_collection WHERE last_collection = ?";
    private static final String updateQuery = "UPDATE money_collection SET money_amount = ?, vending_machine_id = ? WHERE last_collection = ?";

    @Override
    public List<MoneyCollection> getAll() {
        List<MoneyCollection> moneyCollections = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAllQuery)) {
            while (resultSet.next()) {
                MoneyCollection moneyCollection = new MoneyCollection();
                moneyCollection.setLastCollection(resultSet.getString("last_collection"));
                moneyCollection.setMoneyAmount(resultSet.getInt("money_amount"));
                moneyCollection.setVendingMachineId(resultSet.getInt("vending_machine_id"));
                moneyCollections.add(moneyCollection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return moneyCollections;
    }

    @Override
    public MoneyCollection getById(String id) {
        MoneyCollection moneyCollection = new MoneyCollection();
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection.prepareStatement(getByIdQuery)) {
            statement.setString(1, String.valueOf(id));
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                moneyCollection.setLastCollection(id);
                moneyCollection.setMoneyAmount(resultSet.getInt("money_amount"));
                moneyCollection.setVendingMachineId(resultSet.getInt("vending_machine_id"));
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
        return moneyCollection;
    }

    @Override
    public String create(MoneyCollection createObj) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection.prepareStatement(createQuery)) {
            statement.setString(1, String.valueOf(createObj.getLastCollection()));
            statement.setInt(2, createObj.getMoneyAmount());
            statement.setInt(3, createObj.getVendingMachineId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result != 0 ? "Success" : "Fail";
    }

    @Override
    public String deleteById(String id) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement stmt = connection.prepareStatement(deleteQuery)) {
            stmt.setString(1, id);
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result != 0 ? "Success" : "Fail";
    }

    @Override
    public String update(MoneyCollection updateObj) {
        int result = 0;
        try {
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement(updateQuery);
            stmt.setInt(1, updateObj.getMoneyAmount());
            stmt.setInt(2, updateObj.getVendingMachineId());
            stmt.setString(3, String.valueOf(updateObj.getLastCollection()));
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result != 0 ? "Success" : "Fail";
    }
}
