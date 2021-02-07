package com.iot.db.view;

import com.iot.db.controller.*;
import com.iot.db.entity.*;
import java.sql.Timestamp;
import java.util.*;

public class View {

    private final VendingMachineController vendingMachineController = new VendingMachineController();
    private final TechnicianController technicianController = new TechnicianController();
    private final MoneyCollectionController moneyCollectionController = new MoneyCollectionController();
    private final MenuController menuController = new MenuController();
    private final MenuItemController menuItemController = new MenuItemController();

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner INPUT = new Scanner(System.in);

    public View() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("Q", "Q - exit program");
        menu.put("S", "S - show menu");

        menu.put("1", "\n1 - Get all vending machines");
        menu.put("2", "2 - Get vending machine by ID");
        menu.put("3", "3 - Create vending machine");
        menu.put("4", "4 - Delete vending machine");
        menu.put("5", "5 - Update vending machine\n");

        menu.put("6", "6 - Get all technicians");
        menu.put("7", "7 - Get technician by ID");
        menu.put("8", "8 - Create technician");
        menu.put("9", "9 - Delete technician");
        menu.put("10", "10 - Update technician\n");

        menu.put("11", "11 - Get all money collections");
        menu.put("12", "12 - Get money collection by ID");
        menu.put("13", "13 - Create money collection");
        menu.put("14", "14 - Delete money collection");
        menu.put("15", "15 - Update money collection\n");

        menu.put("16", "16 - Get item loadings");
        menu.put("17", "17 - Get item loading by ID");
        menu.put("18", "18 - Create item loading");
        menu.put("19", "19 - Delete item loading");
        menu.put("20", "20 - Update item loading\n");

        menu.put("21", "21 - Get menu");
        menu.put("22", "22 - Get menu by ID");
        menu.put("23", "23 - Create menu ");
        menu.put("24", "24 - Delete menu ");
        menu.put("25", "25 - Update menu \n");

        methodsMenu.put("S", this::showMenu);

        methodsMenu.put("1", this::getAllVendingMachines);
        methodsMenu.put("2", this::getVendingMachineById);
        methodsMenu.put("3", this::createVendingMachine);
        methodsMenu.put("4", this::deleteVendingMachine);
        methodsMenu.put("5", this::updateVendingMachine);

        methodsMenu.put("6", this::getAllTechnicians);
        methodsMenu.put("7", this::getTechnicianById);
        methodsMenu.put("8", this::createTechnician);
        methodsMenu.put("9", this::deleteTechnician);
        methodsMenu.put("10", this::updateTechnician);

        methodsMenu.put("11", this::getAllMoneyCollections);
        methodsMenu.put("12", this::getMoneyCollectionById);
        methodsMenu.put("13", this::createMoneyCollection);
        methodsMenu.put("14", this::deleteMoneyCollection);
        methodsMenu.put("15", this::updateMoneyCollection);

        methodsMenu.put("16", this::getAllMenuItem);
        methodsMenu.put("17", this::getMenuItemById);
        methodsMenu.put("18", this::createMenuItem);
        methodsMenu.put("19", this::deleteMenuItem);
        methodsMenu.put("20", this::updateMenuItem);

        methodsMenu.put("21", this::getAllMenus);
        methodsMenu.put("22", this::getMenuById);
        methodsMenu.put("23", this::createMenu);
        methodsMenu.put("24", this::deleteMenu);
        methodsMenu.put("25", this::updateMenu);

    }

    private void getAllVendingMachines() {
        System.out.println("\nVending machines:");
        System.out.println(vendingMachineController.getAll());
    }

    private void getVendingMachineById() {
        System.out.println("\nEnter ID for vending machine");
        int id = INPUT.nextInt();
        System.out.println(vendingMachineController.getById(id));
    }

    private void createVendingMachine() {
        System.out.println("\nEnter address");
        String address = INPUT.next();
        System.out.println("\nEnter menu id");
        Integer menuId = INPUT.nextInt();
        Menu menu = menuController.getById(menuId);
        VendingMachine vendingMachine = new VendingMachine(address, menu);
        System.out.println(vendingMachineController.save(vendingMachine));
    }

    private void deleteVendingMachine() {
        System.out.println("\nEnter ID for an vending machine you want to delete");
        int id = INPUT.nextInt();
        System.out.println(vendingMachineController.deleteById(id));
    }

    private void updateVendingMachine() {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter address");
        String address = INPUT.next();
        System.out.println("\nEnter menu id");
        Integer menuId = INPUT.nextInt();
        Menu menu = menuController.getById(menuId);

        VendingMachine vendingMachine = new VendingMachine(id, address, menu);
        System.out.println(vendingMachineController.save(vendingMachine));
    }

    private void getAllTechnicians() {
        System.out.println("\nTechnicians:");
        System.out.println(technicianController.getAll());
    }

    private void getTechnicianById() {
        System.out.println("\nEnter ID for an technician");
        int id = INPUT.nextInt();
        System.out.println(technicianController.getById(id));
    }

    private void deleteTechnician() {
        System.out.println("\nEnter ID for a technician you want to delete");
        int id = INPUT.nextInt();
        System.out.println(technicianController.deleteById(id));
    }

    private void createTechnician() {
        System.out.println("\nEnter name");
        String name = INPUT.next();
        System.out.println("\nEnter surname");
        String surname = INPUT.next();

        Technician technician = new Technician(name, surname);
        System.out.println(technicianController.save(technician));
    }

    private void updateTechnician() {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter name");
        String name = INPUT.next();
        System.out.println("\nEnter surname");
        String surname = INPUT.next();
        Technician technician = new Technician(id, name, surname);
        System.out.println(technicianController.save(technician));
    }

    private void getAllMoneyCollections() {
        System.out.println("\nMoney Collections:");
        System.out.println(moneyCollectionController.getAll());
    }

    private void getMoneyCollectionById() {
        System.out.println("\nEnter id of last collection");
        Integer id = INPUT.nextInt();
        System.out.println(moneyCollectionController.getById(id));
    }

    private void deleteMoneyCollection() {
        System.out.println("\nEnter id of last collection you want to delete");
        Integer id = INPUT.nextInt();
        System.out.println(moneyCollectionController.deleteById(id));
    }

    private void createMoneyCollection() {
        INPUT.nextLine();
        System.out.println("\nEnter date of last collection (yyyy-MM-dd HH:mm:ss)");
        String lastCollection = INPUT.nextLine();
        System.out.println("\nEnter money amount");
        Float moneyAmount = INPUT.nextFloat();
        System.out.println("\nEnter vending machine id");
        int vendingMachineId = INPUT.nextInt();
        VendingMachine vendingMachine = vendingMachineController.getById(vendingMachineId);
        System.out.println("\nEnter technician id");
        int technicianId = INPUT.nextInt();
        Technician technician = technicianController.getById(technicianId);
        MoneyCollection moneyCollection =
            new MoneyCollection(Timestamp.valueOf(lastCollection), moneyAmount, vendingMachine, technician);
        System.out.println(moneyCollectionController.save(moneyCollection));
    }

    private void updateMoneyCollection() {
        System.out.println("\nEnter id of last collection");
        Integer id = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("\nEnter date of last collection (yyyy-MM-dd HH:mm:ss)");
        String lastCollection = INPUT.nextLine();
        System.out.println("\nEnter money amount");
        Float moneyAmount = INPUT.nextFloat();
        System.out.println("\nEnter vending machine id");
        int vendingMachineId = INPUT.nextInt();
        VendingMachine vendingMachine = vendingMachineController.getById(vendingMachineId);
        System.out.println("\nEnter technician id");
        int technicianId = INPUT.nextInt();
        Technician technician = technicianController.getById(technicianId);
        MoneyCollection moneyCollection =
            new MoneyCollection(id, Timestamp.valueOf(lastCollection), moneyAmount, vendingMachine, technician);
        System.out.println(moneyCollectionController.save(moneyCollection));
    }

    private void getAllMenus() {
        System.out.println("\nMenus:");
        System.out.println(menuController.getAll());
    }

    private void getMenuById() {
        System.out.println("\nEnter ID for menu");
        int id = INPUT.nextInt();
        System.out.println(menuController.getById(id));
    }

    private void createMenu() {
        System.out.println("\nEnter name");
        String name = INPUT.next();
        System.out.println("\nEnter count of menu item");
        int count = INPUT.nextInt();
        System.out.println("Enter ids of items");
        int itemId;
        List<MenuItem> menuItems = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            itemId = INPUT.nextInt();
            MenuItem item = menuItemController.getById(itemId);
            menuItems.add(item);
        }
        Menu menu = new Menu(name, menuItems);
        System.out.println(menuController.save(menu));
    }

    private void deleteMenu() {
        System.out.println("\nEnter ID for a menu you want to delete");
        int id = INPUT.nextInt();
        System.out.println(menuController.deleteById(id));
    }

    private void updateMenu() {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter name");
        String name = INPUT.next();
        System.out.println("\nEnter count of menu item");
        int count = INPUT.nextInt();
        System.out.println("Enter ids of items");
        int itemId;
        List<MenuItem> menuItems = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            itemId = INPUT.nextInt();
            MenuItem item = menuItemController.getById(itemId);
            menuItems.add(item);
        }
        Menu menu = new Menu(id, name, menuItems);
        System.out.println(menuController.save(menu));
    }

    private void getAllMenuItem() {
        System.out.println("Menu items");
        System.out.println(menuItemController.getAll());
    }

    private void getMenuItemById() {
        System.out.println("Enter item id");
        Integer id = INPUT.nextInt();
        System.out.println(menuItemController.getById(id));
    }

    private void createMenuItem() {
        System.out.println("Enter item name");
        String name = INPUT.next();
        System.out.println("Enter item price");
        Float price = INPUT.nextFloat();
        System.out.println("Enter item brand");
        String brand = INPUT.next();
        MenuItem menuItem = new MenuItem(name, price, brand);
        System.out.println(menuItemController.save(menuItem));
    }

    private void deleteMenuItem() {
        System.out.println("Enter item id you want to delete");
        Integer id = INPUT.nextInt();
        System.out.println(menuItemController.deleteById(id));
    }

    private void updateMenuItem() {
        System.out.println("Enter item id");
        Integer id = INPUT.nextInt();
        System.out.println("Enter item name");
        String name = INPUT.next();
        System.out.println("Enter item price");
        Float price = INPUT.nextFloat();
        System.out.println("Enter item brand");
        String brand = INPUT.next();
        MenuItem menuItem = new MenuItem(id, name, price, brand);
        System.out.println(menuItemController.save(menuItem));
    }


    private void showMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    private void showMainMenu() {
        System.out.println(menu.get("S"));
        System.out.println(menu.get("Q"));
        System.out.println("Select menu option.");
    }

    public void show() {
        String keyMenu;
        showMainMenu();
        do {
            keyMenu = INPUT.next().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                e.getStackTrace();
            }

        } while (!keyMenu.equals("Q"));
    }
}
