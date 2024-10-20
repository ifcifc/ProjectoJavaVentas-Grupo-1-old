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
        try (Connection conn = DB.getDataSource().getConnection()){
            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("SELECT * FROM usuario");
            ArrayList<UsuarioModel> usuarioModels = DB.<UsuarioModel>parseResults(resultSet, UsuarioModel.class);
            usuarioModels.forEach(System.out::println);
        } catch (SQLException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}