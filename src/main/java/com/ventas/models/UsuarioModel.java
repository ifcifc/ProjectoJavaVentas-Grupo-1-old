package com.ventas.models;

public class UsuarioModel extends BaseModel {
    private long id_usuario;
    private String nombre, email, password;
    private boolean isEmpleado;

    public UsuarioModel() {
    }

    public UsuarioModel(long id_usuario, String nombre, String email, String password, boolean isEmpleado) {
        super();
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.isEmpleado = isEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmpleado() {
        return isEmpleado;
    }

    public void setEmpleado(boolean empleado) {
        isEmpleado = empleado;
    }


    @Override
    public long getID() {
        return this.id_usuario;
    }

    @Override
    public String toString() {
        return "UsuariosModel{" +
                "id_usuario=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isEmpleado=" + isEmpleado +
                ", isDelete=" + isDelete +
                '}';
    }
}
