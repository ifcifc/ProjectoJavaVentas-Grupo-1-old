package com.ventas.app;

import com.ventas.data.DataBase;
import com.ventas.models.BaseModel;
import com.ventas.services.IService;

import java.util.HashMap;

public abstract class AppBase implements Runnable{
    protected static AppTest INSTANCE;

    protected final DataBase db;

    private final HashMap<Class<?>, IService<? extends BaseModel>> services;
    public AppBase() {
        this.db = new DataBase();

        services = new HashMap<>();
    }
    public static AppTest getInstance() {
        if(INSTANCE==null)INSTANCE=new AppTest();
        return INSTANCE;
    }
    public DataBase getDb() {
        return db;
    }

    public <T extends IService<? extends BaseModel>> T getService(Class<T> type) {
        return type.cast(this.services.get(type));
    }

    public void addService(IService<? extends BaseModel> service){
        this.services.put(service.getClass(), service);
    }
}
