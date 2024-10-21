package com.ventas.models;

public class VentaArticuloModel extends BaseModel{
    private int id_venta_articulo, id_venta, id_articulo;
    private double monto;
    private String fecha;

    public VentaArticuloModel() {
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public int getID() {
        return this.id_venta_articulo;
    }


    @Override
    public String toString() {
        return "VentaArticuloModel{" +
                "id_venta_articulo=" + id_venta_articulo +
                ", id_venta=" + id_venta +
                ", id_articulo=" + id_articulo +
                ", monto=" + monto +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
