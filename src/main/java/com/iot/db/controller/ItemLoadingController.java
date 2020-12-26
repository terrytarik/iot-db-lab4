package com.iot.db.controller;

import com.iot.db.entity.ItemLoading;
import com.iot.db.service.ItemLoadingService;
import java.util.List;

public class ItemLoadingController implements GeneralController<ItemLoading, String>{
    private ItemLoadingService service = new ItemLoadingService();


    @Override
    public List<ItemLoading> getAll() {
        return service.getAll();
    }

    @Override
    public ItemLoading getById(String id) {
        return service.getById(id);
    }

    @Override
    public String create(ItemLoading createObj) {
        return service.create(createObj);
    }

    @Override
    public String deleteById(String id) {
        return service.deleteById(id);
    }

    @Override
    public String update(ItemLoading updateObj) {
        return service.update(updateObj);
    }
}
