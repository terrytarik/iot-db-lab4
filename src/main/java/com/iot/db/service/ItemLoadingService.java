package com.iot.db.service;

import com.iot.db.dao.ItemLoadingDao;
import com.iot.db.entity.ItemLoading;
import java.util.List;

public class ItemLoadingService implements GeneralService<ItemLoading, String>{
    private ItemLoadingDao dao = new ItemLoadingDao();

    @Override
    public List<ItemLoading> getAll() {
        return dao.getAll();
    }

    @Override
    public ItemLoading getById(String id) {
        return dao.getById(id);
    }

    @Override
    public String create(ItemLoading createObj) {
        return dao.create(createObj);
    }

    @Override
    public String deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public String update(ItemLoading updateObj) {
        return dao.update(updateObj);
    }
}
