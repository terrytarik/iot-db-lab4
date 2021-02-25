package com.iot.db.dao;

import com.iot.db.entity.MoneyCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyCollectionDao extends JpaRepository<MoneyCollection, Integer> {
}
