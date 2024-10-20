package com.ventas.app;

import com.ventas.data.DataBase;

public abstract class AppBase implements Runnable{
    protected static AppTest INSTANCE;

    protected final DataBase db;
    public AppBase() {
        this.db = new DataBase();
    }
    public static AppTest getInstance() {
        if(INSTANCE==null)INSTANCE=new AppTest();
        return INSTANCE;
    }
    public DataBase getDb() {
        return db;
    }
}
