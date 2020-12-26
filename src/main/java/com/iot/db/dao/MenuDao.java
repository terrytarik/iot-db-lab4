package com.iot.db.dao;

import static com.iot.db.dao.Constants.*;

import com.iot.db.entity.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MenuDao implements GeneralDAO<Menu, Integer> {
    private static final String getAllQuery = "SELECT * FROM menu";
    private static final String getByIdQuery = "SELECT * FROM menu WHERE id = ?";
    private static final String createQuery =
        "INSERT INTO menu (name, vending_machine_id) VALUES (?, ?)";
    private static final String deleteQuery = "DELETE FROM menu WHERE id = ?";
    private static final String updateQuery =
        "UPDATE menu SET name = ?, vending_machine_id = ? WHERE id = ?";

    @Override
    public List<Menu> getAll() {
        List<Menu> menus = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAllQuery)) {
            while (resultSet.next()) {
                Menu menu = new Menu();
                menu.setId(resultSet.getInt("id"));
                menu.setName(resultSet.getString("name"));
                menu.setVendingMachineId(resultSet.getInt("vending_machine_id"));
                menus.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }

    @Override
    public Menu getById(Integer id) {
        Menu menu = new Menu();
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection.prepareStatement(getByIdQuery)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                menu.setId(id);
                menu.setName(resultSet.getString("name"));
                menu.setVendingMachineId(resultSet.getInt("vending_machine_id"));
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
        return menu;
    }

    @Override
    public String create(Menu createObj) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection
                 .prepareStatement(createQuery)) {
            statement.setString(1, createObj.getName());
            statement.setInt(2, createObj.getVendingMachineId());
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
    public String update(Menu updateObj) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
             PreparedStatement statement = connection
                 .prepareStatement(updateQuery)) {
            statement.setString(1, updateObj.getName());
            statement.setInt(2, updateObj.getVendingMachineId());
            statement.setInt(3, updateObj.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result != 0 ? "Success" : "Fail";
    }
}
