package com.iot.db.dao;

import com.iot.db.config.HibernateUtils;
import com.iot.db.entity.MenuItem;
import com.iot.db.entity.VendingMachine;
import java.util.List;
import org.hibernate.Session;

public class MenuItemDao implements GeneralDAO<MenuItem, Integer> {
    private Session session;

    @Override
    public List<MenuItem> getAll() {
        List<MenuItem> menuItems;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            menuItems =
                session.createQuery("FROM MenuItem mi", MenuItem.class).getResultList();
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return menuItems;
    }

    @Override
    public MenuItem getById(Integer id) {
        MenuItem menuItem;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            menuItem =
                session.get(MenuItem.class, id);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return menuItem;
    }

    @Override
    public String save(MenuItem createObj) {
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
            MenuItem menuItem = session.get(MenuItem.class, id);
            if(menuItem != null){
                session.delete(menuItem);
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
