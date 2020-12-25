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

public class VendingMachineDao {

    public List<VendingMachine> getAll() {
        List<VendingMachine> vendingMachines = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            Statement stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from vending_machine");
            while (rs.next()) {
                VendingMachine vendingMachine = new VendingMachine();
                vendingMachine.setId(rs.getInt("id"));
                vendingMachine.setAdress(rs.getString("adress"));
                vendingMachines.add(vendingMachine);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return vendingMachines;
    }

    public VendingMachine getVendingMachineById(int id) {
        VendingMachine vendingMachine = new VendingMachine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("select * from vending_machine where id = ?");
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                vendingMachine.setId(id);
                vendingMachine.setAdress(rs.getString("adress"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return vendingMachine;
    }

    public boolean createVendingMachine(VendingMachine vendingMachine) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("insert into vending_machine (adress) values (?)");
            stmt.setString(1, vendingMachine.getAdress());
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    public boolean deleteVendingMachine(int id) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("delete from vending_machine where id = ?");
            stmt.setString(1, String.valueOf(id));
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    public boolean updateVendingMachine(VendingMachine vendingMachine) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("update vending_machine set adress = ? where id = ?");
            stmt.setString(1, vendingMachine.getAdress());
            stmt.setInt(2, vendingMachine.getId());
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }
}
