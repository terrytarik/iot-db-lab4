package com.iot.db.controller;

import com.iot.db.entity.ItemLoading;
import com.iot.db.service.ItemLoadingService;
import java.time.LocalDateTime;
import java.util.List;

public class ItemLoadingController {
    ItemLoadingService service;
    public List<ItemLoading> getAll() {
        return service.getAll();
    }

    public ItemLoading getItemLoadingByLastLoading(LocalDateTime parse) {
        return service.getItemLoadingByLastLoading(parse);
    }

    public boolean deleteItemLoading(LocalDateTime parse) {
        return service.deleteItemLoading(parse);
    }

    public boolean createItemLoading(ItemLoading itemLoading) {
        return service.createItemLoading(itemLoading);
    }

    public boolean updateItemLoading(ItemLoading itemLoading) {
        return service.updateItemLoading(itemLoading);
    }
}
