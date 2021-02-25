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
    public String save(Technician createObj) {
        return technicianService.save(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return technicianService.deleteById(id);
    }

}
