package data;

import models.Devolucion;
import models.Producto;
import models.Venta;
import service.DataService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class CsvDataReader implements DataService {

    private static Logger logger = Logger.getLogger(CsvDataReader.class.getName());

    @Override
    public List<Producto> getProductos(String archivo) {

        var salida = new ArrayList<Producto>();

        logger.info("Iniciando productos del archivo " + archivo);

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            var contenido = br.lines().skip(1);
            logger.info("Iniciando parseo de productos");

            contenido.forEach(line -> {
                List<String> lineArray = Arrays.asList(line.split(","));
                Producto producto = new Producto();

                producto.setId(lineArray.get(0));
                producto.setNombre(lineArray.get(1));
                producto.setCategoria(lineArray.get(2));
                producto.setPrecio(Double.parseDouble(lineArray.get(3)));

                salida.add(producto);
            });



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return salida;
    }

    @Override
    public List<Venta> getVentas(String archivo) {


        var salida = new ArrayList<Venta>();

        logger.info("Iniciando ventas del archivo " + archivo);

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            var contenido = br.lines().skip(1);
            logger.info("Iniciando parseo de ventas");

            contenido.forEach(line -> {
                List<String> lineArray = Arrays.asList(line.split(","));
                Venta venta = new Venta();

                venta.setTimeStamp(lineArray.get(0));
                venta.setProductoID(lineArray.get(1));
                venta.setCantidadVendida(Integer.parseInt(lineArray.get(2)));
                venta.setCustomer(lineArray.get(3));

                salida.add(venta);
            });

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return salida;
    }

    @Override
    public List<Devolucion> getDevoluciones(String archivo) {

        var salida = new ArrayList<Devolucion>();
        logger.info("Iniciando devoluciones del archivo " + archivo);

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            var contenido = br.lines().skip(1);

            logger.info("Iniciando parseo de devoluciones");
            contenido.forEach(line -> {
                var lineaArray = parseo(line);

                Devolucion devolucion = new Devolucion();

                devolucion.setTimestamp(lineaArray.get(0));
                devolucion.setProductoID(lineaArray.get(1));
                devolucion.setCantidadDevuelta(Integer.parseInt(lineaArray.get(2)));
                devolucion.setMotivo(lineaArray.get(3));

                salida.add(devolucion);
            });

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return salida;
    }


    private List<String> parseo(String line) {
        var campos = new ArrayList<String>();
        StringBuilder camposTexto = new StringBuilder();
        boolean comillas = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                comillas = !comillas;
            } else if (c == ',' && !comillas) {
                campos.add(camposTexto.toString());
                camposTexto.setLength(0);
            }
            else {
                camposTexto.append(c);
            }

        }

        campos.add(camposTexto.toString());
        return campos;
    }

}
