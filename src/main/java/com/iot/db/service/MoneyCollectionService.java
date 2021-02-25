package com.iot.db.service;

import com.iot.db.dao.MoneyCollectionDao;
import com.iot.db.entity.MoneyCollection;
import java.util.List;

public class MoneyCollectionService implements GeneralService<MoneyCollection, String>{
    private MoneyCollectionDao dao = new MoneyCollectionDao();

    @Override
    public List<MoneyCollection> getAll() {
        return dao.getAll();
    }

    @Override
    public MoneyCollection getById(String id) {
        return dao.getById(id);
    }

    @Override
    public String create(MoneyCollection createObj) {
        return dao.create(createObj);
    }

    @Override
    public String deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public String update(MoneyCollection updateObj) {
        return dao.update(updateObj);
    }
}
