package com.ventas.services;

import com.ventas.app.AppBase;
import com.ventas.data.DataBase;
import com.ventas.models.StockModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class StockService implements IService<StockModel>{
    @Override
    public List<StockModel> getAll() {
        DataBase db = AppBase.getInstance().getDb();
        ArrayList<StockModel> StockModels = new ArrayList<>();
        db.secureTransaction(stmt->{
            try {
                ResultSet rs = stmt.executeQuery("SELECT * FROM stock WHERE NOT isDelete");
                StockModels.addAll(db.parseResults(rs, StockModel.class));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        });
        return StockModels;
    }

    @Override
    public StockModel getById(int id) {
        DataBase db = AppBase.getInstance().getDb();
        AtomicReference<StockModel> stock = new AtomicReference<>();
        db.secureTransaction(stmt->{
                    try {
                        stmt.setInt(1, id);
                        ResultSet rs = stmt.executeQuery();
                        if(!rs.next())return false;
                        stock.set(db.parseResult(rs, StockModel.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                    return true;
        },"SELECT * FROM stock WHERE NOT isDelete AND id_stock=?");

        return stock.get();
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
        },"UPDATE stock SET isDelete=1 WHERE id_stock=?");
    }

    @Override
    public boolean update(StockModel model) {
        DataBase db = AppBase.getInstance().getDb();
        return db.secureTransaction(stmt->{
            try {
                stmt.setInt(1, model.getCantidad());
                stmt.setInt(2, model.getId_articulo());
                stmt.setInt(3, model.getID());
                return stmt.executeUpdate()!=0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        },"UPDATE stock SET cantidad=?, id_articulo=? WHERE id_stock=?");

    }

    @Override
    public boolean insert(StockModel model) {
        DataBase db = AppBase.getInstance().getDb();
        return db.secureTransaction(stmt->{
            try {
                stmt.setInt(1, model.getId_articulo());
                stmt.setInt(2, model.getCantidad());
                return stmt.executeUpdate()!=0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        },"INSERT INTO stock (id_stock, id_articulo, cantidad) VALUES (NULL, ?, ?)");

    }

}
