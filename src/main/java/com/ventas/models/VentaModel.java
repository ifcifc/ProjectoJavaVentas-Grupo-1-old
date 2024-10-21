package com.ventas.models;

public class VentaModel extends BaseModel{
    private int id_venta, id_usuario;
    private double monto;
    private String fecha;

    public VentaModel() {
    }

    public VentaModel(int id_usuario, double monto, String fecha) {
        this.id_usuario = id_usuario;
        this.monto = monto;
        this.fecha = fecha;
    }

    @Override
    public int getID() {
        return this.id_venta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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
    public String toString() {
        return "VentaModel{" +
                "id_venta=" + id_venta +
                ", id_usuario=" + id_usuario +
                ", monto=" + monto +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
