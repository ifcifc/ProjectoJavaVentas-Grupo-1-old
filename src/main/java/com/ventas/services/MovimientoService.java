package com.ventas.services;

import com.ventas.app.AppBase;
import com.ventas.data.DataBase;
import com.ventas.models.MovimientoModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MovimientoService implements IService<MovimientoModel>{

    @Override
    public List<MovimientoModel> getAll() {
        DataBase db = AppBase.getInstance().getDb();
        ArrayList<MovimientoModel> models = new ArrayList<>();
        db.secureTransaction(stmt->{
            try {
                ResultSet rs = stmt.executeQuery("SELECT * FROM movimiento WHERE NOT isDelete");
                models.addAll(db.parseResults(rs, MovimientoModel.class));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        });
        return models;
    }

    @Override
    public MovimientoModel getById(int id) {
        DataBase db = AppBase.getInstance().getDb();
        AtomicReference<MovimientoModel> usuario = new AtomicReference<>();
        db.secureTransaction(stmt->{
                    try {
                        stmt.setInt(1, id);
                        ResultSet rs = stmt.executeQuery();
                        if(!rs.next())return false;
                        usuario.set(db.parseResult(rs, MovimientoModel.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                    return true;
        },"SELECT * FROM movimiento WHERE NOT isDelete AND id_movimiento=?");

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
        },"UPDATE movimiento SET isDelete=1 WHERE id_movimiento=? AND NOT isDelete");
    }

    @Override
    public boolean update(MovimientoModel model) {
        DataBase db = AppBase.getInstance().getDb();
        return db.secureTransaction(stmt->{
            try {
                stmt.setLong(1, model.getId_usuario());
                stmt.setDouble(2, model.getMonto());
                stmt.setLong(3, model.getIs_usuario_to());
                stmt.setLong(4, model.getId_venta());
                stmt.setString(5, model.getFecha());
                stmt.setInt(6, model.getID());
                return stmt.executeUpdate()!=0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        },"UPDATE movimiento SET id_usuario=?, monto=?, id_usuario_to=?, id_venta=?, fecha=? WHERE id_movimiento=? AND NOT isDelete");
    }

    @Override
    public boolean insert(MovimientoModel model) {
        DataBase db = AppBase.getInstance().getDb();
        return db.secureTransaction(stmt->{
            try {
                stmt.setLong(1, model.getId_usuario());
                stmt.setDouble(2, model.getMonto());
                stmt.setLong(3, model.getIs_usuario_to());
                stmt.setLong(4, model.getId_venta());
                stmt.setString(5, model.getFecha());
                return stmt.executeUpdate()!=0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        },"INSERT INTO movimiento (id_movimiento, id_usuario, monto, id_usuario_to, id_venta, fecha) VALUES(NULL, ?, ?, ?, ?, ?);");

    }


}
