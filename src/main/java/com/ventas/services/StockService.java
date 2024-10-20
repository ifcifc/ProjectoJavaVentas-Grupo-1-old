package com.ventas.services;

import com.ventas.app.AppBase;
import com.ventas.data.DataBase;
import com.ventas.models.UsuarioModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class StockService implements IService<UsuarioModel>{
    @Override
    public List<UsuarioModel> getAll() {
        DataBase db = AppBase.getInstance().getDb();
        ArrayList<UsuarioModel> usuarioModels = new ArrayList<>();
        db.secureTransaction(stmt->{
            try {
                ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE NOT isDelete");
                usuarioModels.addAll(db.parseResults(rs, UsuarioModel.class));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        });
        return usuarioModels;
    }

    @Override
    public UsuarioModel getById(int id) {
        DataBase db = AppBase.getInstance().getDb();
        AtomicReference<UsuarioModel> usuario = new AtomicReference<>();
        db.secureTransaction(stmt->{
                    try {
                        stmt.setInt(1, id);
                        ResultSet rs = stmt.executeQuery();
                        if(!rs.next())return false;
                        usuario.set(db.parseResult(rs, UsuarioModel.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                    return true;
        },"SELECT * FROM usuario WHERE NOT isDelete AND id_usuario=?");

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
        },"UPDATE usuario SET isDelete=1 WHERE id_usuario=?");
    }

    @Override
    public boolean update(UsuarioModel model) {
        DataBase db = AppBase.getInstance().getDb();
        return db.secureTransaction(stmt->{
            try {
                stmt.setString(1, model.getNombre());
                stmt.setString(2, model.getEmail());
                stmt.setBoolean(3, model.isEmpleado());
                stmt.setInt(4, model.getID());
                return stmt.executeUpdate()!=0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        },"UPDATE usuario SET nombre=?, email=?, isEmpleado=? WHERE id_usuario=?");



    }

    @Override
    public boolean insert(UsuarioModel model) {
        DataBase db = AppBase.getInstance().getDb();
        return db.secureTransaction(stmt->{
            try {
                stmt.setString(1, model.getNombre());
                stmt.setString(2, model.getEmail());
                stmt.setString(3, model.getPassword());
                stmt.setBoolean(4, model.isEmpleado());
                return stmt.executeUpdate()!=0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        },"INSERT INTO usuario (id_usuario, nombre, email, password, isEmpleado) VALUES (NULL, ?, ?, ?, ?)");
    }

    public boolean changePassword(int id, String oldPassword, String newPassword) {
        DataBase db = AppBase.getInstance().getDb();
        return db.secureTransaction(stmt->{
            try {
                stmt.setString(1, newPassword);
                stmt.setString(2, oldPassword);
                stmt.setInt(3, id);
                return stmt.executeUpdate()!=0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        },"UPDATE usuario SET password=? WHERE password=? AND id_usuario=?");
    }

}
