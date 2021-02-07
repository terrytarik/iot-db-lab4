package com.iot.db.controller;

import com.iot.db.entity.VendingMachine;
import com.iot.db.service.VendingMachineService;
import java.util.List;

public class VendingMachineController implements GeneralController<VendingMachine, Integer>{
    private VendingMachineService service = new VendingMachineService();


    @Override
    public List<VendingMachine> getAll() {
        return service.getAll();
    }

    @Override
    public VendingMachine getById(Integer id) {
        return service.getById(id);
    }

    @Override
    public String save(VendingMachine createObj) {
        return service.save(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return service.deleteById(id);
    }

}
