package com.iot.db.view;

import com.iot.db.controller.ItemLoadingController;
import com.iot.db.controller.MenuController;
import com.iot.db.controller.MoneyCollectionController;
import com.iot.db.controller.TechnicianController;
import com.iot.db.controller.VendingMachineController;
import com.iot.db.entity.ItemLoading;
import com.iot.db.entity.Menu;
import com.iot.db.entity.MoneyCollection;
import com.iot.db.entity.Technician;
import com.iot.db.entity.VendingMachine;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private final VendingMachineController vendingMachineController = new VendingMachineController();
    private final TechnicianController technicianController = new TechnicianController();
    private final MoneyCollectionController moneyCollectionController = new MoneyCollectionController();
    private final ItemLoadingController itemLoadingController = new ItemLoadingController();
    private final MenuController menuController = new MenuController();


    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner INPUT = new Scanner(System.in, "ISO-8859-1");

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

        menu.put("21", "21 - Get item loadings");
        menu.put("22", "22 - Get item loading by ID");
        menu.put("23", "23 - Create item loading");
        menu.put("24", "24 - Delete item loading");
        menu.put("25", "25 - Update item loading\n");

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

        methodsMenu.put("16", this::getAllItemLoadings);
        methodsMenu.put("17", this::getItemLoadingById);
        methodsMenu.put("18", this::createItemLoading);
        methodsMenu.put("19", this::deleteItemLoading);
        methodsMenu.put("20", this::updateItemLoading);

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
        System.out.println("\nEnter adress");
        String adress = INPUT.next();
        VendingMachine vendingMachine = new VendingMachine(adress);
        System.out.println(vendingMachineController.create(vendingMachine));
    }

    private void deleteVendingMachine() {
        System.out.println("\nEnter ID for an vending machine you want to delete");
        int id = INPUT.nextInt();
        System.out.println(vendingMachineController.deleteById(id));
    }

    private void updateVendingMachine() {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter adress");
        String adress = INPUT.next();
        VendingMachine vendingMachine = new VendingMachine(id, adress);
        System.out.println(vendingMachineController.update(vendingMachine));
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
        System.out.println(technicianController.create(technician));
    }

    private void updateTechnician() {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter name");
        String name = INPUT.next();
        System.out.println("\nEnter surname");
        String surname = INPUT.next();
        Technician technician = new Technician(id, name, surname);
        System.out.println(technicianController.update(technician));
    }

    private void getAllMoneyCollections() {
        System.out.println("\nMoney Collections:");
        System.out.println(moneyCollectionController.getAll());
    }

    private void getMoneyCollectionById() {
        INPUT.nextLine();
        System.out.println("\nEnter date of last collection (yyyy-MM-dd HH:mm:ss)");
        String lastCollection = INPUT.nextLine();
        System.out.println(moneyCollectionController.getById(lastCollection));
    }

    private void deleteMoneyCollection() {
        INPUT.nextLine();
        System.out.println("\nEnter date of last collection you want to delete (yyyy-MM-dd HH:mm:ss)");
        String lastCollection = INPUT.nextLine();
        System.out.println(moneyCollectionController.deleteById(lastCollection));
    }

    private void createMoneyCollection() {
        INPUT.nextLine();
        System.out.println("\nEnter date of last collection (yyyy-MM-dd HH:mm:ss)");
        String lastCollection = INPUT.nextLine();
        System.out.println("\nEnter money amount");
        int moneyAmount = INPUT.nextInt();
        System.out.println("\nEnter vending machine id");
        int vendingMachineId = INPUT.nextInt();

        MoneyCollection moneyCollection = new MoneyCollection(lastCollection, moneyAmount, vendingMachineId);
        System.out.println(moneyCollectionController.create(moneyCollection));
    }

    private void updateMoneyCollection() {
        INPUT.nextLine();
        System.out.println("\nEnter date of last collection (yyyy-MM-dd HH:mm:ss)");
        String lastCollection = INPUT.nextLine();
        System.out.println("\nEnter money amount");
        int moneyAmount = INPUT.nextInt();
        System.out.println("\nEnter vending machine id");
        int vendingMachineId = INPUT.nextInt();

        MoneyCollection moneyCollection = new MoneyCollection(lastCollection, moneyAmount, vendingMachineId);
        System.out.println(moneyCollectionController.update(moneyCollection));
    }

    private void getAllItemLoadings() {
        System.out.println("\nItem soadings:");
        System.out.println(itemLoadingController.getAll());
    }

    private void getItemLoadingById() throws SQLException {
        INPUT.nextLine();
        System.out.println("\nEnter date of last loading (yyyy-MM-dd HH:mm:ss)");
        String lastLoading = INPUT.nextLine();
        System.out.println(itemLoadingController.getById(lastLoading));
    }

    private void deleteItemLoading() throws SQLException {
        INPUT.nextLine();
        System.out.println("\nEnter date of last loading you want to delete (yyyy-MM-dd HH:mm:ss)");
        String lastLoading = INPUT.nextLine();
        System.out.println(itemLoadingController.deleteById(lastLoading));
    }

    private void createItemLoading() throws SQLException {
        INPUT.nextLine();
        System.out.println("\nEnter date of last loading");
        String lastLoading = INPUT.nextLine();
        System.out.println("\nEnter money amount");
        int moneyAmount = INPUT.nextInt();
        System.out.println("\nEnter technician id");
        int technicianId = INPUT.nextInt();
        System.out.println("\nEnter vending machine id");
        int vendingMachineId = INPUT.nextInt();

        ItemLoading itemLoading = new ItemLoading(lastLoading, moneyAmount, technicianId, vendingMachineId);
        System.out.println(itemLoadingController.create(itemLoading));
    }

    private void updateItemLoading() throws SQLException {
        INPUT.nextLine();
        System.out.println("\nEnter date of last loading");
        String lastLoading = INPUT.nextLine();
        System.out.println("\nEnter money amount");
        int moneyAmount = INPUT.nextInt();
        System.out.println("\nEnter technician id");
        int technicianId = INPUT.nextInt();
        System.out.println("\nEnter vending machine id");
        int vendingMachineId = INPUT.nextInt();

        ItemLoading itemLoading = new ItemLoading(lastLoading, moneyAmount, technicianId, vendingMachineId);
        System.out.println(itemLoadingController.update(itemLoading));
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
        System.out.println("\nEnter vending machine id");
        int vendingMachineId = INPUT.nextInt();
        Menu menu = new Menu(name, vendingMachineId);
        System.out.println(menuController.create(menu));
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
        String adress = INPUT.next();
        System.out.println("\nEnter vending machine id");
        int vendingMachineId = INPUT.nextInt();
        Menu menu = new Menu(id, adress, vendingMachineId);
        System.out.println(menuController.update(menu));
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
