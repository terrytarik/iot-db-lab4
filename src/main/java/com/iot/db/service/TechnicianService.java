package com.iot.db.service;

import com.iot.db.dao.TechnicianDao;
import com.iot.db.entity.Technician;
import java.util.List;

public class TechnicianService implements GeneralService<Technician, Integer>{
    private TechnicianDao technicianDao = new TechnicianDao();

    @Override
    public List<Technician> getAll() {
        return technicianDao.getAll();
    }

    @Override
    public Technician getById(Integer id) {
        return technicianDao.getById(id);
    }

    @Override
    public String create(Technician createObj) {
        return technicianDao.create(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return technicianDao.deleteById(id);
    }

    @Override
    public String update(Technician updateObj) {
        return technicianDao.update(updateObj);
    }
}
