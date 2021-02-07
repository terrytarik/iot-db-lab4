package com.iot.db.service;

import java.util.List;

public interface GeneralService<T, P> {
    List<T> getAll();
    T getById(P id);
    String save(T createObj);
    String deleteById(P id);
}
