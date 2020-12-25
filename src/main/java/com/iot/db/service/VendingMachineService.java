package com.iot.db.service;

import com.iot.db.dao.VendingMachineDao;
import com.iot.db.entity.VendingMachine;
import java.util.List;

public class VendingMachineService {
    private VendingMachineDao dao;

    public VendingMachineService() {
    }

    public List<VendingMachine> getAll() {
        return dao.getAll();
    }


    public VendingMachine getVendingMachineById(int id) {
        return dao.getVendingMachineById(id);
    }

    public boolean deleteVendingMachine(int id) {
        return dao.deleteVendingMachine(id);
    }

    public boolean createVendingMachine(VendingMachine vendingMachine) {
        return dao.createVendingMachine(vendingMachine);
    }

    public boolean updateVendingMachine(VendingMachine vendingMachine) {
        return dao.updateVendingMachine(vendingMachine);
    }
}
