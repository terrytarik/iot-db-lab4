package com.iot.db.controller;

import com.iot.db.entity.MenuItem;
import com.iot.db.service.MenuItemService;
import java.util.List;

public class MenuItemController implements GeneralController<MenuItem, Integer> {
    private MenuItemService menuItemService = new MenuItemService();

    @Override
    public List<MenuItem> getAll() {
        return menuItemService.getAll();
    }

    @Override
    public MenuItem getById(Integer id) {
        return menuItemService.getById(id);
    }

    @Override
    public String save(MenuItem createObj) {
        return menuItemService.save(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return menuItemService.deleteById(id);
    }
}
