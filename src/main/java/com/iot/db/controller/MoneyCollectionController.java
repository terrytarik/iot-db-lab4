package com.iot.db.controller;

import com.iot.db.entity.MoneyCollection;
import com.iot.db.service.MoneyCollectionService;
import java.util.List;

public class MoneyCollectionController implements GeneralController<MoneyCollection, Integer>{
    private MoneyCollectionService service = new MoneyCollectionService();

    @Override
    public List<MoneyCollection> getAll() {
        return service.getAll();
    }

    @Override
    public MoneyCollection getById(Integer id) {
        return service.getById(id);
    }

    @Override
    public String save(MoneyCollection createObj) {
        return service.save(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return service.deleteById(id);
    }

}
