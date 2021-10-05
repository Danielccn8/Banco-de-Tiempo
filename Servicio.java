package com.example.bancotiempo.user.servicio;


import android.graphics.Bitmap;

import com.example.bancotiempo.user.user.Usuarios;
import com.google.firebase.Timestamp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;


public class Servicio{


    public String nombre,tipo,descripcion,imageURL,categoria,ubicacion,id;
    Boolean bencurso;
    private Bitmap bitmap;
    private Timestamp diaCreacion;
    private static Servicio servicio;
    private double puntuacion;


    public Servicio(String nombre, String tipo, String ubicacion, String descripcion, String categoria,Boolean bencurso,String imageURL) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.bencurso = bencurso;
        this.imageURL=imageURL;
        BigDecimal bd = new BigDecimal(Math.random()).setScale(2, RoundingMode.HALF_UP);
        this.puntuacion = 4 + bd.doubleValue();
        this.diaCreacion = Timestamp.now();


    }

    public static Servicio of (Map<String, Object> data) {

        String nombre,tipo,ubicacion,descripcion,imageURL,categoria;
        boolean bencurso;

        double puntuacion;
        Timestamp diaCreacion;

        nombre = (String) data.get("nombre");
        tipo= (String) data.get("tipo");
        ubicacion = (String) data.get("ubicacion");
        descripcion = (String) data.get("descripcion");
        categoria = (String) data.get("categoria");
        bencurso = ((Boolean)data.get("enCurso")).booleanValue();
        imageURL = (String)data.get("ImageURL");
        diaCreacion = (Timestamp) data.get("diacreacion");
        puntuacion = (Double) data.get("puntuacion");
        Servicio servicio = new Servicio(nombre, tipo, ubicacion,descripcion,categoria,bencurso,imageURL);

        servicio.setPuntuacion(puntuacion);
        servicio.setDiaCreacion(diaCreacion);

        return servicio;
    }

    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("nombre", nombre);
        map.put("tipo", tipo);
        map.put("ubicacion", ubicacion);
        map.put("descripcion", descripcion);
        map.put("categoria", categoria);
        map.put("enCurso", bencurso);
        map.put("ImageURL", imageURL);
        map.put("diaCreacion", diaCreacion);
        map.put("puntuacion", puntuacion);


        return map;
    }

    public double getPuntuacion() {return puntuacion;}

    public String getId() {
        return id;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getCategoria() {
        return categoria;
    }

    public Boolean getEnCurso() {
        return bencurso;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public String getNombre() {
        return nombre;
    }

    public Timestamp getDiaCreacion() {return diaCreacion;}

    public void setDiaCreacion(Timestamp diaCreacion) {this.diaCreacion = diaCreacion;}

    public void setPuntuacion(double puntuacion) {this.puntuacion = puntuacion;}

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEnCurso(Boolean boolcurso) {
        this.bencurso = bencurso;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}