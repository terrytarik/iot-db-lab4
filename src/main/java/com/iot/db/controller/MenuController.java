package com.iot.db.controller;

import com.iot.db.entity.Menu;
import com.iot.db.service.MenuService;
import java.util.List;

public class MenuController implements GeneralController<Menu, Integer> {
    private MenuService service = new MenuService();
    @Override
    public List<Menu> getAll() {
        return service.getAll();
    }

    @Override
    public Menu getById(Integer id) {
        return service.getById(id);
    }

    @Override
    public String create(Menu createObj) {
        return service.create(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return service.deleteById(id);
    }

    @Override
    public String update(Menu updateObj) {
        return service.update(updateObj);
    }
}
