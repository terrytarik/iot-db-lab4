package com.iot.db.service;

import com.iot.db.dao.TechnicianDao;
import com.iot.db.entity.Technician;
import java.util.List;

public class TechnicianService {
    TechnicianDao technicianDao;
    public List<Technician> getAll() {
        return technicianDao.getAll();
    }

    public Technician getTechnicianById(int id) {
        return technicianDao.getTechnicianById(id);
    }

    public boolean deleteTechnician(int id) {
        return technicianDao.deleteTechnician(id);
    }

    public boolean updateTechnician(Technician technician) {
        return technicianDao.updateTechnician(technician);
    }

    public boolean createTechnician(Technician technician) {
        return technicianDao.createTechnician(technician);
    }
}
