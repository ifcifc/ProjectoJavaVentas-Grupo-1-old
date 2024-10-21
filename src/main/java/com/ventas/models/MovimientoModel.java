package com.ventas.models;

public class MovimientoModel extends BaseModel{
    private int id_movimiento, id_usuario, is_usuario_to, id_venta;
    private double monto;
    private String fecha;

    public MovimientoModel() {
    }

    public MovimientoModel(int id_usuario, int is_usuario_to, int id_venta, double monto, String fecha) {
        this.id_usuario = id_usuario;
        this.is_usuario_to = is_usuario_to;
        this.id_venta = id_venta;
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getIs_usuario_to() {
        return is_usuario_to;
    }

    public void setIs_usuario_to(int is_usuario_to) {
        this.is_usuario_to = is_usuario_to;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
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
        return this.id_movimiento;
    }

    @Override
    public String toString() {
        return "MovimientoModel{" +
                "id_movimiento=" + id_movimiento +
                ", id_usuario=" + id_usuario +
                ", is_usuario_to=" + is_usuario_to +
                ", id_venta=" + id_venta +
                ", monto=" + monto +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
