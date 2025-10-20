package service;

import models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InformeService {

    public Map<String, Informe> getInformeMap(List<Producto> productos, List<Venta> ventas, List<Devolucion> devoluciones) {

        Map<String, Informe> map = new HashMap<>();

        for (Producto producto : productos) {
            String productoId = producto.getId();
            String nombreProducto = producto.getNombre();
            double precioUnidad = producto.getPrecio();
            int devuelto = 0;
            int vendido = 0;

            if (!map.containsKey(nombreProducto)) {
                map.put(nombreProducto, new Informe());
            }
            Informe informe = map.get(nombreProducto);

            for (Venta venta : ventas) {
                if (venta.getProductoID().equals(productoId)) {
                    vendido += venta.getCantidadVendida();
                }
            }

            for (Devolucion devolucion : devoluciones) {
                if (devolucion.getProductoID().equals(productoId)) {
                    devuelto += devolucion.getCantidadDevuelta();
                }
            }

            informe.calculoVentasNetas(vendido, devuelto);
            informe.calculoStockFinal();
            informe.calculoIngresosTotales(precioUnidad);
            if (devuelto > 5) {
                informe.setEstadoDevolucion(EstadoDevolucion.REQUIERE_REVISION);
            }
            else  {
                informe.setEstadoDevolucion(EstadoDevolucion.OK);
            }
        }

        return map;
    }
}
