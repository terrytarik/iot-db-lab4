package com.iot.db.dao;

import com.iot.db.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDao extends JpaRepository<Menu, Integer> {
}
