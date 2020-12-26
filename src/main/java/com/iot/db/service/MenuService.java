package com.iot.db.service;

import com.iot.db.dao.MenuDao;
import com.iot.db.entity.Menu;
import java.util.List;

public class MenuService implements GeneralService<Menu, Integer> {
    private MenuDao dao = new MenuDao();
    @Override
    public List<Menu> getAll() {
        return dao.getAll();
    }

    @Override
    public Menu getById(Integer id) {
        return dao.getById(id);
    }

    @Override
    public String create(Menu createObj) {
        return dao.create(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return dao.deleteById(id);
    }

    @Override
    public String update(Menu updateObj) {
        return dao.update(updateObj);
    }
}
