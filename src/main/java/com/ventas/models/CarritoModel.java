package com.ventas.models;

public class CarritoModel extends BaseModel{
    private long id_carrito, id_usuario, id_articulo;
    private boolean isComprado;

    public CarritoModel(long id_carrito, long id_usuario, long id_articulo, boolean isComprado) {
        this.id_carrito = id_carrito;
        this.id_usuario = id_usuario;
        this.id_articulo = id_articulo;
        this.isComprado = isComprado;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public long getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(long id_articulo) {
        this.id_articulo = id_articulo;
    }

    public boolean isComprado() {
        return isComprado;
    }

    public void setComprado(boolean comprado) {
        isComprado = comprado;
    }

    public long getID() {
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

