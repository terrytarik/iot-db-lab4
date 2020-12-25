package com.iot.db.service;

import com.iot.db.dao.MoneyCollectionDao;
import com.iot.db.entity.MoneyCollection;
import java.time.LocalDateTime;
import java.util.List;

public class MoneyCollectionService {
    MoneyCollectionDao dao;
    public List<MoneyCollection> getAll() {
        return dao.getAll();
    }

    public MoneyCollection getMoneyCollectionByLastCollection(LocalDateTime parse) {
        return dao.getMoneyCollectionByLastCollection(parse);
    }

    public boolean deleteMoneyCollection(LocalDateTime parse) {
        return dao.deleteMoneyCollection(parse);
    }

    public boolean createMoneyCollection(MoneyCollection moneyCollection) {
        return dao.createMoneyCollection(moneyCollection);
    }

    public boolean updateMoneyCollection(MoneyCollection moneyCollection) {
        return dao.updateMoneyCollection(moneyCollection);
    }
}
