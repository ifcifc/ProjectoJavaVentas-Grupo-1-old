package com.ventas.models;

public class StockModel extends BaseModel{
    private int id_stock;
    private int id_articulo;
    private int cantidad;

    public StockModel() {
    }

    public StockModel(int id_articulo, int cantidad) {
        super();
        this.id_stock = id_stock;
        this.id_articulo = id_articulo;
        this.cantidad = cantidad;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int getID() {
        return this.id_articulo;
    }

    @Override
    public String toString() {
        return "StockModel{" +
                "id_stock=" + id_stock +
                ", id_articulo=" + id_articulo +
                ", cantidad=" + cantidad +
                ", isDelete=" + isDelete +
                '}';
    }
}
