package com.iot.db.service;

import com.iot.db.dao.MoneyCollectionDao;
import com.iot.db.entity.MoneyCollection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyCollectionService {
    @Autowired
    private MoneyCollectionDao dao;

    public List<MoneyCollection> findAll() {
        return dao.findAll();
    }

    public MoneyCollection findById(Integer id) {
        return dao.findById(id).orElseThrow();
    }

    public MoneyCollection save(MoneyCollection moneyCollection) {
        return dao.save(moneyCollection);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }
}
