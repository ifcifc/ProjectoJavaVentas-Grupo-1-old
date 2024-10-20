package com.ventas.app;

import com.ventas.models.ArticuloModel;
import com.ventas.models.UsuarioModel;
import com.ventas.services.ArticuloService;
import com.ventas.services.UsuarioService;

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
        /*UsuarioService us = new UsuarioService();
        System.out.println(us.getAll());
        System.out.println(us.getById(1));*/

        ArticuloService as = new ArticuloService();
        System.out.println(as.getAll());
        System.out.println(as.delete(2));
        System.out.println(as.getAll());
        System.out.println(as.getById(3));
    }
}
