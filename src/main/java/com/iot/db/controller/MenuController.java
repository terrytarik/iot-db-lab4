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
    public String save(Menu createObj) {
        return service.save(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return service.deleteById(id);
    }

}
