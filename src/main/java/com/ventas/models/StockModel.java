package com.ventas.models;

public class StockModel extends BaseModel{
    private long id_stock, id_articulo;
    private int cantidad;

    public StockModel(long id_stock, long id_articulo, int cantidad) {
        super();
        this.id_stock = id_stock;
        this.id_articulo = id_articulo;
        this.cantidad = cantidad;
    }

    public long getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(long id_articulo) {
        this.id_articulo = id_articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public long getID() {
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
