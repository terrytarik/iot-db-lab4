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
    public String save(Technician createObj) {
        return technicianDao.save(createObj);
    }

    @Override
    public String deleteById(Integer id) {
        return technicianDao.deleteById(id);
    }

}
