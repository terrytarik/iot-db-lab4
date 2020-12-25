package com.iot.db.view;

import com.iot.db.controller.ItemLoadingController;
import com.iot.db.controller.MoneyCollectionController;
import com.iot.db.controller.TechnicianController;
import com.iot.db.controller.VendingMachineController;
import com.iot.db.entity.ItemLoading;
import com.iot.db.entity.MoneyCollection;
import com.iot.db.entity.Technician;
import com.iot.db.entity.VendingMachine;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private final VendingMachineController vendingMachineController = new VendingMachineController();
    private final TechnicianController technicianController = new TechnicianController();
    private final MoneyCollectionController moneyCollectionController = new MoneyCollectionController();
    private final ItemLoadingController itemLoadingController = new ItemLoadingController();


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

    }

    private void getAllVendingMachines() throws SQLException {
        System.out.println("\nVending machines:");
        System.out.println(vendingMachineController.getAll());
    }

    private void getVendingMachineById() throws SQLException {
        System.out.println("\nEnter ID for vending machine");
        int id = INPUT.nextInt();
        System.out.println(vendingMachineController.getVendingMachineById(id));
    }

    private void deleteVendingMachine() throws SQLException {
        System.out.println("\nEnter ID for an vending machine you want to delete");
        int id = INPUT.nextInt();
        System.out.println(vendingMachineController.deleteVendingMachine(id));
    }

    private void createVendingMachine() throws SQLException {
        System.out.println("\nEnter adress");
        String adress = INPUT.next();
        VendingMachine vendingMachine = new VendingMachine(adress);
        System.out.println(vendingMachineController.createVendingMachine(vendingMachine));
    }

    private void updateVendingMachine() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter adress");
        String adress = INPUT.next();
        VendingMachine vendingMachine = new VendingMachine(id, adress);
        System.out.println(vendingMachineController.updateVendingMachine(vendingMachine));
    }

    private void getAllTechnicians() throws SQLException {
        System.out.println("\nTechnicians:");
        System.out.println(technicianController.getAll());
    }

    private void getTechnicianById() throws SQLException {
        System.out.println("\nEnter ID for an technician");
        int id = INPUT.nextInt();
        System.out.println(technicianController.getTechnicianById(id));
    }

    private void deleteTechnician() throws SQLException {
        System.out.println("\nEnter ID for an coupon you want to delete");
        int id = INPUT.nextInt();
        System.out.println(technicianController.deleteTechnician(id));
    }

    private void createTechnician() throws SQLException {
        System.out.println("\nEnter name");
        String name = INPUT.next();
        System.out.println("\nEnter surname");
        String surname = INPUT.next();

        Technician technician = new Technician(name, surname);
        System.out.println(technicianController.createTechnician(technician));
    }

    private void updateTechnician() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter name");
        String name = INPUT.next();
        System.out.println("\nEnter surname");
        String surname = INPUT.next();
        Technician technician = new Technician(id, name, surname);
        System.out.println(technicianController.updateTechnician(technician));
    }

    private void getAllMoneyCollections() throws SQLException {
        System.out.println("\nMoney Collections:");
        System.out.println(moneyCollectionController.getAll());
    }

    private void getMoneyCollectionById() throws SQLException {
        System.out.println("\nEnter ID for money collection");
        String lastCollection = INPUT.next();
        System.out.println(moneyCollectionController.getMoneyCollectionByLastCollection(LocalDateTime.parse(lastCollection)));
    }

    private void deleteMoneyCollection() throws SQLException {
        System.out.println("\nEnter ID for money collection you want to delete");
        String lastCollection = INPUT.next();
        System.out.println(moneyCollectionController.deleteMoneyCollection(LocalDateTime.parse(lastCollection)));
    }

    private void createMoneyCollection() throws SQLException {
        System.out.println("\nEnter money amount");
        int moneyAmount = INPUT.nextInt();

        MoneyCollection moneyCollection = new MoneyCollection(moneyAmount);
        System.out.println(moneyCollectionController.createMoneyCollection(moneyCollection));
    }

    private void updateMoneyCollection() throws SQLException {
        System.out.println("\nEnter last collection");
        String lastCollection = INPUT.next();
        System.out.println("\nEnter money amount");
        int moneyAmount = INPUT.nextInt();

        MoneyCollection moneyCollection = new MoneyCollection(LocalDateTime.parse(lastCollection), moneyAmount);
        System.out.println(moneyCollectionController.updateMoneyCollection(moneyCollection));
    }

    private void getAllItemLoadings() throws SQLException {
        System.out.println("\nItem soadings:");
        System.out.println(itemLoadingController.getAll());
    }

    private void getItemLoadingById() throws SQLException {
        System.out.println("\nEnter ID for item loading");
        String lastLoading = INPUT.next();
        System.out.println(itemLoadingController.getItemLoadingByLastLoading(LocalDateTime.parse(lastLoading)));
    }

    private void deleteItemLoading() throws SQLException {
        System.out.println("\nEnter ID for item loading you want to delete");
        String lastLoading = INPUT.next();
        System.out.println(itemLoadingController.deleteItemLoading(LocalDateTime.parse(lastLoading)));
    }

    private void createItemLoading() throws SQLException {
        System.out.println("\nEnter money amount");
        int moneyAmount = INPUT.nextInt();

        ItemLoading itemLoading = new ItemLoading(moneyAmount);
        System.out.println(itemLoadingController.createItemLoading(itemLoading));
    }

    private void updateItemLoading() throws SQLException {
        System.out.println("\nEnter last loading");
        String lastLoading = INPUT.next();
        System.out.println("\nEnter money amount");
        int moneyAmount = INPUT.nextInt();

        ItemLoading itemLoading = new ItemLoading(LocalDateTime.parse(lastLoading), moneyAmount);
        System.out.println(itemLoadingController.updateItemLoading(itemLoading));
    }

    private final void showMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    private final void showMainMenu() {
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
            }

        } while (!keyMenu.equals("Q"));
    }
}
