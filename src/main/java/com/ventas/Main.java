package com.ventas;

import com.ventas.data.DataBase;
import com.ventas.models.ArticuloModel;
import com.ventas.models.UsuarioModel;
import com.ventas.utils.FileRead;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    public static final DataBase  DB = new DataBase();

    public static void main(String[] args) {
        ArrayList<UsuarioModel> usuarioModels = new ArrayList<>();

        DB.secureTransaction(stmt->{
            try {
                ResultSet resultSet = stmt.executeQuery("SELECT * FROM usuario");
                usuarioModels.addAll(DB.parseResults(resultSet, UsuarioModel.class));
            } catch (SQLException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
                throw new RuntimeException(e);
            }

            return true;
        });

        usuarioModels.forEach(System.out::println);
    }
}