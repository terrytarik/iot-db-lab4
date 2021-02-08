package com.iot.db.service;

import com.iot.db.dao.MenuItemDao;
import com.iot.db.entity.MenuItem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemDao dao;

    public List<MenuItem> findAllMenuItems() {
        return dao.findAll();
    }

    public MenuItem findMenuItemById(Integer id) {
        return dao.findById(id).orElseThrow(() -> new RuntimeException("menu item with this id doesn't exist"));
    }

    public MenuItem saveMenuItem(MenuItem menuItem) {
        return dao.save(menuItem);
    }

    public void deleteMenuItemById(Integer id) {
        dao.deleteById(id);
    }
}
