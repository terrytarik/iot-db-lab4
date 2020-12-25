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

public class TechnicianDao {
    public List<Technician> getAll() {
        List<Technician> technicians = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            Statement stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from technician");
            while (rs.next()) {
                Technician technician = new Technician();
                technician.setId(rs.getInt("id"));
                technician.setName(rs.getString("name"));
                technician.setSurname(rs.getString("surname"));
                technicians.add(technician);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return technicians;
    }

    public Technician getTechnicianById(int id) {
        Technician technician = new Technician();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("select * from technician where id = ?");
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                technician.setId(id);
                technician.setName(rs.getString("name"));
                technician.setName(rs.getString("surname"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return technician;
    }

    public boolean createTechnician(Technician technician) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("insert into technician (name, surname) values (?, ?)");
            stmt.setString(1, technician.getName());
            stmt.setString(2, technician.getSurname());
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    public boolean deleteTechnician(int id) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("delete from technician where id = ?");
            stmt.setString(1, String.valueOf(id));
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    public boolean updateTechnician(Technician technician) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL.value, DB_USERNAME.value, DB_PASSWORD.value);
            PreparedStatement stmt = connection.prepareStatement("update technician set name = ?, surname = ? where id = ?");
            stmt.setString(1, technician.getName());
            stmt.setString(2, technician.getSurname());
            stmt.setInt(3, technician.getId());
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }
}
