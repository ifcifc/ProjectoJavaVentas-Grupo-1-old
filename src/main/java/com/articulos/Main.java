package com.articulos;

import com.articulos.data.ModelManager;
import com.articulos.models.BaseModel;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ModelManager<BaseModel> d = new ModelManager<>();

        BaseModel baseModel = new BaseModel() {
            @Override
            public String toString() {
                return null;
            }
        };
        System.out.println("Add1: " + d.add(baseModel));
        System.out.println("Add2: " + d.add(baseModel));

        System.out.println("Set ID: " + baseModel.setID(33));

        System.out.println("Del1: " + d.delete(baseModel.getID()));
        System.out.println("Del2: " + d.delete(baseModel.getID()));
    }
}