package com.iot.db.dao;

import static com.iot.db.dao.Constants.*;

import com.iot.db.entity.MoneyCollection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MoneyCollectionDao {
    public List<MoneyCollection> getAll() {
        List<MoneyCollection> moneyCollections = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            Statement stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from money_collection");
            while (rs.next()) {
                MoneyCollection moneyCollection = new MoneyCollection();
                moneyCollection.setLastCollection(LocalDateTime.parse(rs.getString("last_collection")));
                moneyCollection.setMoneyAmount(rs.getInt("money_amount"));
                moneyCollections.add(moneyCollection);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return moneyCollections;
    }

    public MoneyCollection getMoneyCollectionByLastCollection(LocalDateTime lastCollection) {
        MoneyCollection moneyCollection = new MoneyCollection();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("select * from money_collection where last_collection = ?");
            stmt.setString(1, String.valueOf(lastCollection));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                moneyCollection.setLastCollection(lastCollection);
                moneyCollection.setMoneyAmount(rs.getInt("money_amount"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return moneyCollection;
    }

    public boolean createMoneyCollection(MoneyCollection moneyCollection) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("insert into money_collection (last_collection, money_amount) values (?, ?)");
            stmt.setString(1, String.valueOf(moneyCollection.getLastCollection()));
            stmt.setInt(2, moneyCollection.getMoneyAmount());
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    public boolean deleteMoneyCollection(LocalDateTime lastCollection) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("delete from money_collection where last_collection = ?");
            stmt.setString(1, String.valueOf(lastCollection));
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    public boolean updateMoneyCollection(MoneyCollection moneyCollection) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("update money_collection set money_amount = ? where last_collection = ?");
            stmt.setInt(1, moneyCollection.getMoneyAmount());
            stmt.setString(2, String.valueOf(moneyCollection.getLastCollection()));
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }
}
