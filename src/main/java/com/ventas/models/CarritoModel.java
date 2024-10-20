package com.ventas.models;

public class CarritoModel extends BaseModel{
    private int id_carrito;
    private int id_usuario;
    private int id_articulo;
    private boolean isComprado;

    public CarritoModel(int id_carrito, int id_usuario, int id_articulo, boolean isComprado) {
        this.id_carrito = id_carrito;
        this.id_usuario = id_usuario;
        this.id_articulo = id_articulo;
        this.isComprado = isComprado;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public long getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public boolean isComprado() {
        return isComprado;
    }

    public void setComprado(boolean comprado) {
        isComprado = comprado;
    }

    public int getID() {
        return this.id_carrito;
    }

    @Override
    public String toString() {
        return "CarritoModel{" +
                "id_carrito=" + id_carrito +
                ", id_usuario=" + id_usuario +
                ", id_articulo=" + id_articulo +
                ", isComprado=" + isComprado +
                ", isDelete=" + isDelete +
                '}';
    }
}

