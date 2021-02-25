package com.iot.db.dao;

import java.util.List;

public interface GeneralDAO<T, P> {
    List<T> getAll();
    T getById(P id);
    String create(T createObj);
    String deleteById(P id);
    String update(T updateObj);
}
