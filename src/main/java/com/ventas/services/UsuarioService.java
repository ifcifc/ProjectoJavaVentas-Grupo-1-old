package com.ventas.services;

import com.ventas.app.AppBase;
import com.ventas.data.DataBase;
import com.ventas.models.BaseModel;

import java.sql.ResultSet;
import java.util.List;

public class UsuarioService implements IService{
    @Override
    public List<BaseModel> getAll() {
        DataBase db = AppBase.getInstance().getDb();
        ResultSet rs;
        db.secureTransaction(stmt->{

            return true;
        });
        return null;
    }

    @Override
    public BaseModel getById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(BaseModel model) {
        return false;
    }

    @Override
    public boolean insert(BaseModel model) {
        return false;
    }
}
