package com.articulos.data;

import com.articulos.models.BaseModel;

import java.util.HashMap;
import java.util.List;

public class ModelManager<T extends BaseModel> {
    protected HashMap<Long, T> modelDictionary;
    protected long lastID;
    public ModelManager() {
        this.modelDictionary = new HashMap<>();
        this.lastID = 0;
    }

    public boolean add(T model){
        if( this.modelDictionary.containsValue(model) ||
            this.modelDictionary.containsKey(this.lastID+1) ||
            !model.setID(this.lastID+1))return false;

        this.modelDictionary.put(++this.lastID, model);

        return true;
    }


    public boolean delete(long id){
        if(!this.any(id) || this.modelDictionary.get(id).isDelete()) return false;
        this.modelDictionary
            .get(id)
            .setDelete(true);

        return true;
    }

    public boolean update(T model){
        boolean exist = this.any(model.getID());
        if(!exist) return false;

        this.modelDictionary.replace(model.getID(), model);

        return true;
    }

    public List<T> getAll(){
        return this.modelDictionary.values().stream().filter(model -> !model.isDelete()).toList();
    }

    public T getById(long id){
        return this.modelDictionary.getOrDefault(id, null);
    }

    public boolean any(long id){
        return this.modelDictionary.containsKey(id);
    }
}
