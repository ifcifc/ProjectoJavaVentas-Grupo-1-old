package com.ventas.app;

import com.ventas.models.ArticuloModel;
import com.ventas.models.StockModel;
import com.ventas.models.UsuarioModel;
import com.ventas.services.ArticuloService;
import com.ventas.services.StockService;
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
        UsuarioService us = new UsuarioService();
        System.out.println(us.getAll());
        System.out.println(us.getById(1));

        ArticuloService as = new ArticuloService();
        System.out.println(as.getAll());
        System.out.println(as.delete(2));
        System.out.println(as.getAll());
        System.out.println(as.getById(3));
        System.out.println("-------------");
        StockService ss = new StockService();
        //ss.insert(new StockModel(1, 3));
        //ss.insert(new StockModel(2, 3));

        System.out.println(ss.getAll());
        System.out.println(ss.delete(3));
        System.out.println(ss.getAll());
        System.out.println(ss.getById(3));
        System.out.println(ss.getById(2));
    }
}
