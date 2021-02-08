package com.iot.db.dao;

import com.iot.db.entity.VendingMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendingMachineDao extends JpaRepository<VendingMachine, Integer> {
}
