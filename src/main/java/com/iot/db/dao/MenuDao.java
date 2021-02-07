package com.iot.db.dao;

import com.iot.db.config.HibernateUtils;
import com.iot.db.entity.Menu;
import java.util.List;
import org.hibernate.Session;

public class MenuDao implements GeneralDAO<Menu, Integer> {
    private Session session;

    @Override
    public List<Menu> getAll() {
        List<Menu> menus;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            menus =
                session.createQuery("FROM Menu m", Menu.class).getResultList();
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return menus;
    }

    @Override
    public Menu getById(Integer id) {
        Menu menu;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            menu =
                session.get(Menu.class, id);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return menu;
    }

    @Override
    public String save(Menu createObj) {
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
            Menu menu = session.get(Menu.class, id);
            if (menu != null) {
                session.delete(menu);
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
