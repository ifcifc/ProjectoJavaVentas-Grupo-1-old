package com.ventas.services;

import com.ventas.app.App;
import com.ventas.app.AppBase;
import com.ventas.data.DataBase;
import com.ventas.models.VentaModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class VentaService implements IService<VentaModel>{
    private DataBase db;

    public VentaService() {
        db = App.getInstance().getDb();
    }
    
    @Override
    public List<VentaModel> getAll() {
        
        ArrayList<VentaModel> models = new ArrayList<>();
        db.secureTransaction(stmt->{
            try {
                ResultSet rs = stmt.executeQuery("SELECT * FROM venta WHERE NOT isDelete");
                models.addAll(db.parseResults(rs, VentaModel.class));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        });
        return models;
    }

    @Override
    public VentaModel getById(int id) {
        
        AtomicReference<VentaModel> usuario = new AtomicReference<>();
        db.secureTransaction(stmt->{
                    try {
                        stmt.setInt(1, id);
                        ResultSet rs = stmt.executeQuery();
                        if(!rs.next())return false;
                        usuario.set(db.parseResult(rs, VentaModel.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                    return true;
        },"SELECT * FROM venta WHERE NOT isDelete AND id_venta=?");

        return usuario.get();
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
        },"UPDATE venta SET isDelete=1 WHERE id_venta=? AND NOT isDelete");
    }

    @Override
    public boolean update(VentaModel model) {
        
        return db.secureTransaction(stmt->{
            try {
                stmt.setLong(1, model.getId_usuario());
                stmt.setString(2, model.getFecha());
                stmt.setDouble(3, model.getMonto());
                stmt.setInt(4, model.getID());
                return stmt.executeUpdate()!=0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        },"UPDATE venta SET id_usuario=?, fecha=?, monto=? WHERE id_venta=?");

    }

    @Override
    public boolean insert(VentaModel model) {
        
        return db.secureTransaction(stmt->{
            try {
                stmt.setLong(1, model.getId_usuario());
                stmt.setString(2, model.getFecha());
                stmt.setDouble(3, model.getMonto());
                return stmt.executeUpdate()!=0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        },"INSERT INTO venta (id_venta, id_usuario, fecha, monto) VALUES(NULL, ?, ?, ?)");

    }


}
