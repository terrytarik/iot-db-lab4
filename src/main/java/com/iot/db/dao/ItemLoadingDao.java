package com.iot.db.dao;

import static com.iot.db.dao.Constants.*;

import com.iot.db.entity.ItemLoading;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemLoadingDao implements GeneralDAO<ItemLoading, String> {
    private static final String getAllQuery = "SELECT * FROM item_loading";
    private static final String getByIdQuery = "SELECT * FROM item_loading WHERE last_loading = ?";
    private static final String createQuery =
        "INSERT INTO item_loading (last_loading, amount, technician_id, vending_machine_id) VALUES (?, ?, ?, ?)";
    private static final String deleteQuery = "DELETE FROM item_loading WHERE last_loading = ?";
    private static final String updateQuery =
        "UPDATE item_loading SET amount = ?, technician_id = ?, vending_machine_id = ? WHERE last_loading = ?";

    @Override
    public List<ItemLoading> getAll() {
        List<ItemLoading> itemLoadings = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAllQuery)) {

            while (resultSet.next()) {
                ItemLoading itemLoading = new ItemLoading();
                itemLoading.setLastLoading(resultSet.getString("last_loading"));
                itemLoading.setMoneyAmount(resultSet.getInt("amount"));
                itemLoading.setTechnicianId(resultSet.getInt("technician_id"));
                itemLoading.setVendingMachineId(resultSet.getInt("vending_machine_id"));
                itemLoadings.add(itemLoading);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemLoadings;
    }

    @Override
    public ItemLoading getById(String id) {
        ItemLoading itemLoading = new ItemLoading();
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection.prepareStatement(getByIdQuery);) {
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                itemLoading.setLastLoading(id);
                itemLoading.setMoneyAmount(resultSet.getInt("amount"));
                itemLoading.setTechnicianId(resultSet.getInt("technician_id"));
                itemLoading.setVendingMachineId(resultSet.getInt("vending_machine_id"));
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
        return itemLoading;
    }

    @Override
    public String create(ItemLoading createObj) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection.prepareStatement(createQuery)) {
            statement.setString(1, createObj.getLastLoading());
            statement.setInt(2, createObj.getMoneyAmount());
            statement.setInt(3, createObj.getTechnicianId());
            statement.setInt(4, createObj.getVendingMachineId());
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
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setString(1, id);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result != 0 ? "Success" : "Fail";
    }

    @Override
    public String update(ItemLoading updateObj) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setInt(1, updateObj.getMoneyAmount());
            statement.setInt(2, updateObj.getTechnicianId());
            statement.setInt(3, updateObj.getVendingMachineId());
            statement.setString(4, updateObj.getLastLoading());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result != 0 ? "Success" : "Fail";
    }


}
