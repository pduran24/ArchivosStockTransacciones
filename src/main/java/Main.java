import data.CsvDataReader;
import data.JsonWriter;
import models.Informe;
import service.DataService;
import service.InformeService;

import java.util.Map;

public class Main {
    static void main() {

        DataService ds = new CsvDataReader();


        ds.getProductos("productos.csv").forEach(System.out::println);
        ds.getVentas("ventas.csv").forEach(System.out::println);
        ds.getDevoluciones("devoluciones.csv").forEach(System.out::println);

        var productos = ds.getProductos("productos.csv");
        var ventas = ds.getVentas("ventas.csv");
        var devoluciones =  ds.getDevoluciones("devoluciones.csv");

        InformeService i = new InformeService();
        Map<String, Informe> reporte = i.getInformeMap(productos, ventas, devoluciones);

        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.writeReport(reporte, "reporte.json");

    }
}
