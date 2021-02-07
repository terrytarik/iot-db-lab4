package com.iot.db.dao;

import com.iot.db.config.HibernateUtils;
import com.iot.db.entity.MoneyCollection;
import java.util.List;
import org.hibernate.Session;

public class MoneyCollectionDao implements GeneralDAO<MoneyCollection, Integer> {
    private Session session;

    @Override
    public List<MoneyCollection> getAll() {
        List<MoneyCollection> moneyCollections;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            moneyCollections =
                session.createQuery("FROM MoneyCollection vm", MoneyCollection.class).getResultList();
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return moneyCollections;
    }

    @Override
    public MoneyCollection getById(Integer id) {
        MoneyCollection moneyCollection;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            moneyCollection =
                session.get(MoneyCollection.class, id);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return moneyCollection;
    }

    @Override
    public String save(MoneyCollection createObj) {
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
            MoneyCollection moneyCollection = session.get(MoneyCollection.class, id);
            if (moneyCollection != null) {
                session.delete(moneyCollection);
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
