package com.iot.db.service;

import com.iot.db.dao.VendingMachineDao;
import com.iot.db.entity.VendingMachine;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendingMachineService {
    @Autowired
    private VendingMachineDao dao;

    public List<VendingMachine> getAll() {
        return dao.findAll();
    }

    public VendingMachine getById(Integer id) {
        return dao.findById(id)
            .orElseThrow(() -> new RuntimeException("The vending machine does not exist by this id: " + id));
    }

    public VendingMachine save(VendingMachine createObj) {
        return dao.save(createObj);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }
}
