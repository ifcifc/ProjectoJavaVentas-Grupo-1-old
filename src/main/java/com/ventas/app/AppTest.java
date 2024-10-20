package com.ventas.app;

import com.ventas.models.UsuarioModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppTest extends AppBase{
    public AppTest() {
        super();
        INSTANCE = this;
    }

    @Override
    public void run() {
        ArrayList<UsuarioModel> usuarioModels = new ArrayList<>();
        this.db.secureTransaction(stmt->{
            try {
                ResultSet resultSet = stmt.executeQuery("SELECT * FROM usuario");
                usuarioModels.addAll(db.parseResults(resultSet, UsuarioModel.class));
            } catch (SQLException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
                throw new RuntimeException(e);
            }

            return true;
        });


        usuarioModels.forEach(System.out::println);
    }
}
