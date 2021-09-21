package com.example.bancotiempo.user;


import com.google.firebase.Timestamp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class  Usuarios
{

    private String nombre;
    private String email, direccion,password;

    //private Timestamp diaCreacion;
    private static Usuarios usuarios;
    //private double puntuacion;

    public Usuarios(String nombre, String email, String direccion,String password) {

        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.password = password;
        //BigDecimal bd = new BigDecimal(Math.random()).setScale(2, RoundingMode.HALF_UP);
        //this.puntuacion = 4 + bd.doubleValue();
        //this.diaCreacion = Timestamp.now();
    }

    public static Usuarios of (Map<String, Object> data) {
        String nombre, email, direccion,password;

        //double puntuacion;
        //Timestamp diaCreacion;

        nombre = (String) data.get("Nombre");
        email = (String) data.get("Email");
        direccion= (String) data.get("Direccion");
        password = (String) data.get("Password");
        //diaCreacion = (Timestamp) data.get("DiaCreacion");
        //puntuacion = (Double) data.get("Puntuacion");
        Usuarios usuarios = new Usuarios(nombre, email, direccion,password);

        //usuarios.setPuntuacion(puntuacion);
        //usuarios.setDiaCreacion(diaCreacion);

        return usuarios;
    }

    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("Nombre", nombre);
        map.put("Email", email);
        map.put("Direccion", direccion);
        map.put("Password", password);
        //map.put("DiaCreacion", diaCreacion);
        //map.put("Puntuacion", puntuacion);

        return map;
    }

    private Usuarios()
    {

    }

    public static Usuarios getInstance()
    {
        if(usuarios == null)
            usuarios = new Usuarios();
        return usuarios;
    }

    //public double getPuntuacion() {return puntuacion;}

    public String getEmail() {
        return email;
    }

    public  String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPassword() {
        return password;
    }

   // public Timestamp getDiaCreacion() {return diaCreacion;}

    //public void setDiaCreacion(Timestamp diaCreacion) {this.diaCreacion = diaCreacion;}

    //public void setPuntuacion(double puntuacion) {this.puntuacion = puntuacion;}

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void setUsuarios(Usuarios usuarios) {
        Usuarios.usuarios = usuarios;
    }
}