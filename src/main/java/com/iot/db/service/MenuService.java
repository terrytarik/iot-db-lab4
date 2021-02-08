package com.iot.db.service;

import com.iot.db.dao.MenuDao;
import com.iot.db.entity.Menu;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    @Autowired
    private MenuDao dao;

    public List<Menu> getAllMenus() {
        return dao.findAll();
    }

    public Menu findMenuById(Integer id) {
        return dao.findById(id).orElseThrow(() -> new RuntimeException("menu with this id not exist"));
    }

    public Menu saveMenu(Menu createObj) {
        return dao.save(createObj);
    }

    public void deleteById(Integer id) {
         dao.deleteById(id);
    }
}
