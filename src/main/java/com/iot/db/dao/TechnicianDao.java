package com.iot.db.dao;

import com.iot.db.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianDao extends JpaRepository<Technician, Integer> {
}
