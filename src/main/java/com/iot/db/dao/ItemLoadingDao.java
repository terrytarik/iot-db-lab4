package com.iot.db.dao;

import static com.iot.db.dao.Constants.*;

import com.iot.db.entity.ItemLoading;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ItemLoadingDao {
    public List<ItemLoading> getAll() {
        List<ItemLoading> itemLoadings = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            Statement stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from item_loading");
            while (rs.next()) {
                ItemLoading itemLoading = new ItemLoading();
                itemLoading.setLastLoading(LocalDateTime.parse(rs.getString("last_loading")));
                itemLoading.setMoneyAmount(rs.getInt("money_amount"));
                itemLoadings.add(itemLoading);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return itemLoadings;
    }

    public ItemLoading getItemLoadingByLastLoading(LocalDateTime lastLoading) {
        ItemLoading itemLoading = new ItemLoading();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("select * from item_loading where last_loading = ?");
            stmt.setString(1, String.valueOf(lastLoading));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                itemLoading.setLastLoading(lastLoading);
                itemLoading.setMoneyAmount(rs.getInt("money_amount"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return itemLoading;
    }

    public boolean createItemLoading(ItemLoading itemLoading) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("insert into item_loading (last_loading, money_amount) values (?, ?)");
            stmt.setString(1, String.valueOf(itemLoading.getLastLoading()));
            stmt.setInt(2, itemLoading.getMoneyAmount());
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    public boolean deleteItemLoading(LocalDateTime lastLoading) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("delete from item_loading where last_loading = ?");
            stmt.setString(1, String.valueOf(lastLoading));
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    public boolean updateItemLoading(ItemLoading itemLoading) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("update item_loading set money_amount = ? where last_loading = ?");
            stmt.setInt(1, itemLoading.getMoneyAmount());
            stmt.setString(2, String.valueOf(itemLoading.getLastLoading()));
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }
}
