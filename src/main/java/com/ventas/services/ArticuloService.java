package com.ventas.services;

import com.ventas.app.AppBase;
import com.ventas.data.DataBase;
import com.ventas.models.ArticuloModel;
import com.ventas.models.UsuarioModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ArticuloService implements IService<ArticuloModel>{
    @Override
    public List<ArticuloModel> getAll() {
        DataBase db = AppBase.getInstance().getDb();
        ArrayList<ArticuloModel> models = new ArrayList<>();
        db.secureTransaction(stmt->{
            try {
                ResultSet rs = stmt.executeQuery("SELECT * FROM articulo WHERE NOT isDelete");
                models.addAll(db.parseResults(rs, ArticuloModel.class));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        });
        return models;
    }

    @Override
    public ArticuloModel getById(int id) {
        DataBase db = AppBase.getInstance().getDb();
        AtomicReference<ArticuloModel> usuario = new AtomicReference<>();
        db.secureTransaction(stmt->{
                    try {
                        stmt.setInt(1, id);
                        ResultSet rs = stmt.executeQuery();
                        if(!rs.next())return false;
                        usuario.set(db.parseResult(rs, ArticuloModel.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                    return true;
        },"SELECT * FROM articulo WHERE NOT isDelete AND id_articulo=?");

        return usuario.get();
    }

    @Override
    public boolean delete(int id) {
        DataBase db = AppBase.getInstance().getDb();
        return db.secureTransaction(stmt->{
            try {
                stmt.setInt(1, id);
                return stmt.executeUpdate()>0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        },"UPDATE articulo SET isDelete=1 WHERE id_articulo=? AND NOT isDelete");
    }

    @Override
    public boolean update(ArticuloModel model) {
        DataBase db = AppBase.getInstance().getDb();
        return db.secureTransaction(stmt->{
            try {
                stmt.setLong(1, model.getCod());
                stmt.setString(2, model.getNombre());
                stmt.setString(3, model.getDescripcion());
                stmt.setDouble(4, model.getPrecio());
                stmt.setInt(5, model.getID());
                return stmt.executeUpdate()!=0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        },"UPDATE articulo SET cod=?,nombre=?, descripcion=?, precio=? WHERE id_articulo=? AND NOT isDelete");
    }

    @Override
    public boolean insert(ArticuloModel model) {
        DataBase db = AppBase.getInstance().getDb();
        return db.secureTransaction(stmt->{
            try {
                stmt.setLong(1, model.getCod());
                stmt.setString(2, model.getNombre());
                stmt.setString(3, model.getDescripcion());
                stmt.setDouble(4, model.getPrecio());
                return stmt.executeUpdate()!=0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        },"INSERT INTO articulo (id_articulo, cod, nombre, descripcion, precio) VALUES (NULL, ?, ?, ?, ?)");
    }


}
