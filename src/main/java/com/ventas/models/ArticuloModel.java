package com.ventas.models;

public class ArticuloModel extends BaseModel{
    private int id_articulo;
    private long cod;
    private String nombre, descripcion;
    private double precio;

    public ArticuloModel() {
    }

    public ArticuloModel(long cod, String nombre, String descripción, double precio) {
        super();
        this.id_articulo = 0;
        this.cod = cod;
        this.nombre = nombre;
        this.descripcion = descripción;
        this.precio = precio;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int getID() {
        return this.id_articulo;
    }

    @Override
    public String toString() {
        return "ArticuloModel{" +
                "id_articulo=" + id_articulo +
                ", cod=" + cod +
                ", Nombre='" + nombre + '\'' +
                ", descripción='" + descripcion + '\'' +
                ", precio=" + precio +
                ", isDelete=" + isDelete +
                '}';
    }
}
