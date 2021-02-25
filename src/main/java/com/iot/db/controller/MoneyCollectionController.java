package com.iot.db.controller;

import com.iot.db.entity.MoneyCollection;
import com.iot.db.service.MoneyCollectionService;
import java.util.List;

public class MoneyCollectionController implements GeneralController<MoneyCollection, String>{
    private MoneyCollectionService service = new MoneyCollectionService();

    @Override
    public List<MoneyCollection> getAll() {
        return service.getAll();
    }

    @Override
    public MoneyCollection getById(String id) {
        return service.getById(id);
    }

    @Override
    public String create(MoneyCollection createObj) {
        return service.create(createObj);
    }

    @Override
    public String deleteById(String id) {
        return service.deleteById(id);
    }

    @Override
    public String update(MoneyCollection updateObj) {
        return service.update(updateObj);
    }
}
