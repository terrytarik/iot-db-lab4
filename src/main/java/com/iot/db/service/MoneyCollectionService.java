package com.iot.db.service;

import com.iot.db.dao.MoneyCollectionDao;
import com.iot.db.entity.MoneyCollection;
import java.util.List;

public class MoneyCollectionService implements GeneralService<MoneyCollection, Integer>{
    private MoneyCollectionDao dao = new MoneyCollectionDao();

    @Override
    public List<MoneyCollection> getAll() {
        return dao.getAll();
    }

    @Override
    public MoneyCollection getById(Integer id) {
        return dao.getById(id);
    }

    @Override
    public String save(MoneyCollection createObj) {
        return dao.save(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return dao.deleteById(id);
    }

}
