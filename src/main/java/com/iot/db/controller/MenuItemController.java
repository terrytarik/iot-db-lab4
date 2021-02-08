package com.iot.db.controller;

import com.iot.db.entity.Menu;
import com.iot.db.entity.MenuItem;
import com.iot.db.service.MenuItemService;
import com.iot.db.service.MenuService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu-item")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;
    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<MenuItem> findAllMenuItems() {
        return menuItemService.findAllMenuItems();
    }

    @GetMapping("/{id}")
    public MenuItem findMenuItemById(@PathVariable Integer id) {
        return menuItemService.findMenuItemById(id);
    }

    @PostMapping
    public MenuItem saveMenuItem(@RequestBody MenuItem menuItem, @RequestParam List<Integer> menuIds) {
        List<Menu> menus = new ArrayList<>();
        menuIds.forEach(id -> {
            menus.add(menuService.findMenuById(id));
        });
        menuItem.setMenuList(menus);
        return menuItemService.saveMenuItem(menuItem);
    }

    @PutMapping
    public MenuItem updateMenuItem(@RequestBody MenuItem menuItem, @RequestParam List<Integer> menuIds) {
        List<Menu> menus = new ArrayList<>();
        menuIds.forEach(id -> {
            menus.add(menuService.findMenuById(id));
        });
        menuItem.setMenuList(menus);
        return menuItemService.saveMenuItem(menuItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMenuItemById(@PathVariable Integer id) {
        menuItemService.deleteMenuItemById(id);
        return ResponseEntity.ok().build();
    }
}
