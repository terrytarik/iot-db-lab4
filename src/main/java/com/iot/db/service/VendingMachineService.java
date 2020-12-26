package com.iot.db.service;

import com.iot.db.dao.VendingMachineDao;
import com.iot.db.entity.VendingMachine;
import java.util.List;

public class VendingMachineService implements GeneralService<VendingMachine, Integer>{
    private VendingMachineDao dao = new VendingMachineDao();


    @Override
    public List<VendingMachine> getAll() {
        return dao.getAll();
    }

    @Override
    public VendingMachine getById(Integer id) {
        return dao.getById(id);
    }

    @Override
    public String create(VendingMachine createObj) {
        return dao.create(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return dao.deleteById(id);
    }

    @Override
    public String update(VendingMachine updateObj) {
        return dao.update(updateObj);
    }
}
