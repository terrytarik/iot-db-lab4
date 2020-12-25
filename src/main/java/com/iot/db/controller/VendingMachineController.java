package com.iot.db.controller;

import com.iot.db.entity.VendingMachine;
import com.iot.db.service.VendingMachineService;
import java.util.List;

public class VendingMachineController {
    private VendingMachineService service;


    public List<VendingMachine> getAll() {
        return service.getAll();
    }

    public VendingMachine getVendingMachineById(int id) {
        return service.getVendingMachineById(id);
    }

    public boolean deleteVendingMachine(int id) {
        return service.deleteVendingMachine(id);
    }

    public boolean createVendingMachine(VendingMachine vendingMachine) {
        return service.createVendingMachine(vendingMachine);
    }

    public boolean updateVendingMachine(VendingMachine vendingMachine) {
        return service.updateVendingMachine(vendingMachine);
    }
}
