package com.dam.trinity;

import android.widget.ImageView;

public class PagadosModelo {
    private String nombre, curso, fecha;
    private int img;

    public PagadosModelo(String nombre, String curso, String fecha) {
        this.nombre = nombre;
        this.curso = curso;
        this.fecha = fecha;
        this.img = img;
    }

    public PagadosModelo() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
