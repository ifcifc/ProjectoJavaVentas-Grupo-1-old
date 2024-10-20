package com.ventas.services;

import com.ventas.app.AppBase;
import com.ventas.data.DataBase;
import com.ventas.models.BaseModel;
import com.ventas.models.UsuarioModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class UsuarioService implements IService<UsuarioModel>{
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
        AtomicReference<UsuarioModel> usuario = null;
        db.secureTransaction(stmt->{
            try {
                ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE NOT isDelete AND id_usuario=" + id);
                usuario.set(db.parseResult(rs, UsuarioModel.class));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        });

        return usuario.get();
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
