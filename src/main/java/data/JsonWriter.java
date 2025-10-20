package data;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import models.Informe;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

public class JsonWriter {

    private static Logger logger = Logger.getLogger(JsonWriter.class.getName());

    public void writeReport(Map<String, Informe> reporte, String filePath) {
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            mapper.writeValue(new File(filePath), reporte);
            logger.info("Report JSON has been written to: " + filePath);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
