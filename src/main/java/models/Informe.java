package models;


import lombok.Data;

@Data
public class Informe {


    private int ventasNetas;
    private int stockFinal;
    private double ingresosTotales;
    private EstadoDevolucion estadoDevolucion;

    public void calculoVentasNetas(int vendido, int devuelto) {
         ventasNetas = vendido - devuelto;
    }

    public void calculoStockFinal() {
        stockFinal = 100 - ventasNetas;
    }

    public void calculoIngresosTotales(double precioUnidad) {
        ingresosTotales = ventasNetas * precioUnidad;
    }


}
