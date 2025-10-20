package models;

import lombok.Data;

@Data
public class Venta {

    private String timeStamp;
    private String productoID;
    private int cantidadVendida;
    private String customer;

}
