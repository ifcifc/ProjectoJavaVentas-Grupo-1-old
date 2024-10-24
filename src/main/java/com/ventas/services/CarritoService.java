package com.ventas.services;

import com.ventas.app.App;
import com.ventas.app.AppBase;
import com.ventas.data.DataBase;
import com.ventas.models.CarritoModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CarritoService implements IService<CarritoModel>{
        
    private DataBase db;

    public CarritoService() {
        db = App.getInstance().getDb();
    }
    
    @Override
    public List<CarritoModel> getAll() {
        ArrayList<CarritoModel> CarritoModels = new ArrayList<>();
        db.secureTransaction(stmt->{
            try {
                ResultSet rs = stmt.executeQuery("SELECT * FROM carrito WHERE NOT isDelete");
                CarritoModels.addAll(db.parseResults(rs, CarritoModel.class));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        });
        return CarritoModels;
    }

    @Override
    public CarritoModel getById(int id) {
        AtomicReference<CarritoModel> carrito = new AtomicReference<>();
        db.secureTransaction(stmt->{
                    try {
                        stmt.setInt(1, id);
                        ResultSet rs = stmt.executeQuery();
                        if(!rs.next())return false;
                        carrito.set(db.parseResult(rs, CarritoModel.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                    return true;
        },"SELECT * FROM carrito WHERE NOT isDelete AND id_carrito=?");

        return carrito.get();
    }

    @Override
    public boolean delete(int id) {
        return db.secureTransaction(stmt->{
            try {
                stmt.setInt(1, id);
                return stmt.executeUpdate()>0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        },"UPDATE carrito SET isDelete=1 WHERE id_carrito=?");
    }

    @Override
    public boolean update(CarritoModel model) {
        return db.secureTransaction(stmt->{
            try {
                stmt.setInt(1, model.getId_usuario());
                stmt.setInt(2, model.getId_articulo());
                stmt.setInt(3, model.getID());
                return stmt.executeUpdate()!=0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        },"UPDATE carrito SET id_usuario=?, id_articulo=? WHERE id_carrito=? AND NOT isDelete");
    }

    @Override
    public boolean insert(CarritoModel model) {
        return db.secureTransaction(stmt->{
            try {
                stmt.setInt(1, model.getId_usuario());
                stmt.setInt(2, model.getId_articulo());
                return stmt.executeUpdate()!=0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        },"INSERT INTO carrito (id_carrito, id_usuario, id_articulo) VALUES (NULL, ?, ?)");

    }


}
