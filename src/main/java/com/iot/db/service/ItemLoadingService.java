package com.iot.db.service;

import com.iot.db.dao.ItemLoadingDao;
import com.iot.db.entity.ItemLoading;
import java.time.LocalDateTime;
import java.util.List;

public class ItemLoadingService {
    ItemLoadingDao dao;
    public List<ItemLoading> getAll() {
        return dao.getAll();
    }

    public ItemLoading getItemLoadingByLastLoading(LocalDateTime parse) {
        return dao.getItemLoadingByLastLoading(parse);
    }

    public boolean deleteItemLoading(LocalDateTime parse) {
        return dao.deleteItemLoading(parse);
    }

    public boolean createItemLoading(ItemLoading itemLoading) {
        return dao.createItemLoading(itemLoading);
    }

    public boolean updateItemLoading(ItemLoading itemLoading) {
        return dao.updateItemLoading(itemLoading);
    }
}
