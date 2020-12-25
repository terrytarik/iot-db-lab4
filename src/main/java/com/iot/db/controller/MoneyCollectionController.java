package com.iot.db.controller;

import com.iot.db.entity.MoneyCollection;
import com.iot.db.service.MoneyCollectionService;
import java.time.LocalDateTime;
import java.util.List;

public class MoneyCollectionController {
    MoneyCollectionService service;
    public List<MoneyCollection> getAll() {
        return service.getAll();
    }

    public MoneyCollection getMoneyCollectionByLastCollection(LocalDateTime parse) {
        return service.getMoneyCollectionByLastCollection(parse);
    }

    public boolean deleteMoneyCollection(LocalDateTime parse) {
        return service.deleteMoneyCollection(parse);
    }

    public boolean createMoneyCollection(MoneyCollection moneyCollection) {
        return service.createMoneyCollection(moneyCollection);
    }

    public boolean updateMoneyCollection(MoneyCollection moneyCollection) {
        return service.updateMoneyCollection(moneyCollection);
    }
}
