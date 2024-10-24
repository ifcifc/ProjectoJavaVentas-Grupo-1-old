package com.ventas.app;

import com.ventas.services.*;


public class AppTest extends AppBase{

    public AppTest() {
        super();
        System.out.println("RUUUUN");
    }

    @Override
    public void run() {
        this.addService(new ArticuloService());
        this.addService(new CarritoService());
        this.addService(new MovimientoService());
        this.addService(new StockService());
        this.addService(new UsuarioService());
        this.addService(new VentaService());

        /*
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
        System.out.println("-------------");
        CarritoService cs = new CarritoService();
       cs.insert(new CarritoModel(1, 3, false));
        cs.insert(new CarritoModel(1, 3, false));
        cs.insert(new CarritoModel(1, 3, false));
        cs.insert(new CarritoModel(1, 30, false));
        //ss.insert(new StockModel(2, 3));

        System.out.println(cs.getAll());
        System.out.println(cs.delete(3));
        System.out.println(cs.getAll());
        System.out.println(cs.getById(3));
        System.out.println(cs.getById(2));
        CarritoModel byId = cs.getById(2);
        byId.setComprado(true);
        cs.update(byId);
        System.out.println(cs.getById(2));*/
        //this.addService(new VentaService());
        //VentaService vs = this.getService(VentaService.class);
        /*vs.insert(new VentaModel(1,1,"24/04/2024"));
        vs.insert(new VentaModel(2,1,"24/04/2024"));
        vs.insert(new VentaModel(3,1,"24/04/2024"));
        vs.insert(new VentaModel(4,1,"24/04/2024"));*/
        /*vs.getAll().forEach(System.out::println);
        System.out.println("----------------");
        System.out.println(vs.delete(2));
        System.out.println("----------------");
        VentaModel byId = vs.getById(1);
        System.out.println(byId);
        System.out.println("----------------");
        byId.setFecha("asdasd");
        System.out.println(vs.update(byId));
        System.out.println("----------------");
        vs.getAll().forEach(System.out::println);
        System.out.println("----------------");
        System.out.println(vs.getById(1));
        System.out.println("----------------");*/
        /*MovimientoService ms = this.getService(MovimientoService.class);
        ms.insert(new MovimientoModel(1,0,0,0, ""));
        ms.insert(new MovimientoModel(25,0,0,0, ""));
        ms.insert(new MovimientoModel(3,0,0,0, ""));


        Optional<MovimientoModel> max = ms.getAll().stream().max(Comparator.comparingInt(MovimientoModel::getID));
        System.out.println(max.get());
        ms.getAll().forEach(System.out::println);
        System.out.println("----------------");
        System.out.println(ms.delete(2));;
        System.out.println("----------------");
        ms.getAll().forEach(System.out::println);
        System.out.println("----------------");
        MovimientoModel byId = ms.getById(3);
        System.out.println(byId);
        System.out.println("----------------");
        byId.setFecha("algo");
        System.out.println(ms.update(byId));
        System.out.println("----------------");
        ms.getAll().forEach(System.out::println);
        System.out.println("----------------");*/

    } 
}
