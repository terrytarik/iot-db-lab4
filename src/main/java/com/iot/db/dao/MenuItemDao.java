package com.iot.db.dao;

import com.iot.db.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemDao extends JpaRepository<MenuItem, Integer> {
}
