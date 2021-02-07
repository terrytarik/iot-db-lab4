package com.iot.db.service;

import com.iot.db.dao.MenuItemDao;
import com.iot.db.entity.MenuItem;
import java.util.List;

public class MenuItemService implements GeneralService<MenuItem, Integer>{
    private MenuItemDao dao = new MenuItemDao();
    @Override
    public List<MenuItem> getAll() {
        return dao.getAll();
    }

    @Override
    public MenuItem getById(Integer id) {
        return dao.getById(id);
    }

    @Override
    public String save(MenuItem createObj) {
        return dao.save(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return dao.deleteById(id);
    }
}
