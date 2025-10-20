package service;

import models.Devolucion;
import models.Producto;
import models.Venta;

import java.util.List;

public interface DataService {

    public List<Producto> getProductos(String archivo);
    public List<Venta> getVentas(String archivo);
    public List<Devolucion> getDevoluciones(String archivo);

}
