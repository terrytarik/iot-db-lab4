package com.iot.db.dao;

import static com.iot.db.dao.Constants.*;

import com.iot.db.config.HibernateUtils;
import com.iot.db.entity.Technician;
import com.iot.db.entity.VendingMachine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class TechnicianDao implements GeneralDAO<Technician, Integer> {
    private Session session;

    @Override
    public List<Technician> getAll() {
        List<Technician> technicians;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            technicians =
                session.createQuery("FROM Technician vm", Technician.class).getResultList();
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return technicians;
    }

    @Override
    public Technician getById(Integer id) {
        Technician technician;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            technician =
                session.get(Technician.class, id);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return technician;
    }

    @Override
    public String save(Technician createObj) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(createObj);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return "Success";
    }

    @Override
    public String deleteById(Integer id) {
        boolean result = false;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            Technician technician = session.get(Technician.class, id);
            if(technician != null){
                session.delete(technician);
                result = true;
            }
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result ? "Success" : "Fail";
    }
}
