package com.ventas.services;

import com.ventas.models.BaseModel;

import java.util.List;

public interface IService <T>{
    List<T> getAll();
    T getById(int id);
    boolean delete(int id);
    boolean update(BaseModel model);
    boolean insert(BaseModel model);
}
