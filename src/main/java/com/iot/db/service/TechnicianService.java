package com.iot.db.service;

import com.iot.db.dao.TechnicianDao;
import com.iot.db.entity.Technician;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicianService {
    @Autowired
    private TechnicianDao dao;

    public List<Technician> findAll() {
        return dao.findAll();
    }

    public Technician findById(Integer id) {
        return dao.findById(id).orElseThrow();
    }

    public Technician save(Technician technician) {
        return dao.save(technician);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }
}
