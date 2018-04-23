package com.dalvik.bookreaderapp.model;

/**
 * Created by alckon on 22/04/16.
 * Copyright Todos los Derechos Reservados | Dalvik 2016
 * Desarrollador: Osmar I. Cancino <o.cancinodiaz@gmail.com>
 */

public class Book {
    public String id_libro;
    public String categoria_id_categoria;
    public String nombre;
    public String descripcion;
    public String nombre_archivo;
    public String categoria;

    public Book(){
        this.id_libro ="";
        this.categoria_id_categoria ="";
        this.nombre ="";
        this.descripcion ="";
        this.nombre_archivo ="";
        this.categoria ="";
    }
}
