package com.iot.db.controller;

import com.iot.db.entity.Technician;
import com.iot.db.service.TechnicianService;
import java.util.List;

public class TechnicianController {
    TechnicianService technicianService;
    public List<Technician> getAll() {
        return technicianService.getAll();
    }

    public Technician getTechnicianById(int id) {
        return technicianService.getTechnicianById(id);
    }

    public boolean deleteTechnician(int id) {
        return technicianService.deleteTechnician(id);
    }

    public boolean createTechnician(Technician technician) {
        return technicianService.createTechnician(technician);
    }

    public boolean updateTechnician(Technician technician) {
        return technicianService.updateTechnician(technician);
    }
}
