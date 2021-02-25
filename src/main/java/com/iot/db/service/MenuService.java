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
    public String save(Menu createObj) {
        return dao.save(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return dao.deleteById(id);
    }
}
