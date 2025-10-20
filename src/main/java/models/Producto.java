package models;

import lombok.Data;

@Data
public class Producto {

    private String id;
    private String nombre;
    private String categoria;
    private double precio;

}
