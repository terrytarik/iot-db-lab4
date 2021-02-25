package com.iot.db.dao;

import com.iot.db.config.HibernateUtils;
import com.iot.db.entity.VendingMachine;
import java.util.List;
import org.hibernate.Session;

public class VendingMachineDao implements GeneralDAO<VendingMachine, Integer> {
    private Session session;

    @Override
    public List<VendingMachine> getAll() {
        List<VendingMachine> vendingMachines;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            vendingMachines =
                session.createQuery("FROM VendingMachine vm", VendingMachine.class).getResultList();
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return vendingMachines;
    }

    @Override
    public VendingMachine getById(Integer id) {
        VendingMachine vendingMachine;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            vendingMachine =
                session.get(VendingMachine.class, id);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return vendingMachine;
    }

    @Override
    public String save(VendingMachine createObj) {
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
            VendingMachine vendingMachine = session.get(VendingMachine.class, id);
            if (vendingMachine != null) {
                session.delete(vendingMachine);
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
