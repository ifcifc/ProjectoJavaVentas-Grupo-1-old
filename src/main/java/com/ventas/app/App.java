/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ventas.app;

/**
 *
 * @author igna
 */
public class App {
    protected static AppTest Singleton;

    public static AppTest getInstance() {
        if(Singleton==null){
            Singleton=new AppTest();
        }
        return Singleton;
    }
}
