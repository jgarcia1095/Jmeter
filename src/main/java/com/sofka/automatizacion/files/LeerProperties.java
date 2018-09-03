package com.sofka.automatizacion.files;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LeerProperties {
    String RUTA_ARCHIVO_PROPERTIES="src/main/resources/properties/configuracion.properties";
    String CLAVE_RUTA_JMETER="jmeter.ruta";

    private Properties iniciarProperties() {
        Properties prop = new Properties();
        InputStream is = null;

        try {
            is = new FileInputStream(RUTA_ARCHIVO_PROPERTIES);
            prop.load(is);
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return prop;
    }

    public String obtenerRutaJmeter(){
        Properties prop= iniciarProperties();
        return prop.getProperty(CLAVE_RUTA_JMETER);
    }

}