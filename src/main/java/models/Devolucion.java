package models;


import lombok.Data;

@Data
public class Devolucion {

    private String timestamp;
    private String productoID;
    private int cantidadDevuelta;
    private String motivo;


}
