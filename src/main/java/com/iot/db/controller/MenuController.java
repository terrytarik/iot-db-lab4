package com.iot.db.controller;

import com.iot.db.entity.Menu;
import com.iot.db.entity.MenuItem;
import com.iot.db.service.MenuItemService;
import com.iot.db.service.MenuService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuItemService menuItemService;

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public Menu getByMenuId(@PathVariable("id") Integer id) {
        return menuService.findMenuById(id);
    }

    @PostMapping
    public Menu saveMenu(@RequestBody Menu menu, @RequestParam List<Integer> menuItemIds) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItemIds.forEach(id -> {
            menuItems.add(menuItemService.findMenuItemById(id));
        });
        menu.setMenuItems(menuItems);
        return menuService.saveMenu(menu);
    }

    @PutMapping
    public Menu updateMenu(@RequestBody Menu menu, @RequestParam List<Integer> menuItemIds) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItemIds.forEach(id -> {
            menuItems.add(menuItemService.findMenuItemById(id));
        });
        menu.setMenuItems(menuItems);
        return menuService.saveMenu(menu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Integer id) {
        menuService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
