package com.iot.db.controller;

import com.iot.db.entity.Technician;
import com.iot.db.service.TechnicianService;
import java.util.List;

public class TechnicianController implements GeneralController<Technician, Integer>{
    private TechnicianService technicianService = new TechnicianService();

    @Override
    public List<Technician> getAll() {
        return technicianService.getAll();
    }

    @Override
    public Technician getById(Integer id) {
        return technicianService.getById(id);
    }

    @Override
    public String create(Technician createObj) {
        return technicianService.create(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return technicianService.deleteById(id);
    }

    @Override
    public String update(Technician updateObj) {
        return technicianService.update(updateObj);
    }
}
