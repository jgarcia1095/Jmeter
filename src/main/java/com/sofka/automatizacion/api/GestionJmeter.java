package com.sofka.automatizacion.api;

import com.sofka.automatizacion.files.LeerProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GestionJmeter {
    private String rutaInternaScripts = "src/main/resources/";
    String falloConsumo = "sinError";

    public String ejecutarJmeter(String scriptJmeter, String condicionAdicional) throws IOException {
        LeerProperties leer = new LeerProperties();
        Runtime rt = Runtime.getRuntime();

        String rutaScript = null;


        try {
            rutaScript = rutaInternaScripts + scriptJmeter + ".jmx";
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        String aux = leer.obtenerRutaJmeter() + " -n -t " + rutaScript;
        if (condicionAdicional != null) {
            aux = aux + " " + condicionAdicional;
        }

        final Process p = rt.exec(aux);
        new Thread(new Runnable() {
            public void run() {
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line = null;
                int aux = 0;
                try {
                    while ((line = input.readLine()) != null) {
                        aux = aux + 1;
                        if (line.contains("summary ")) {
                            if (!line.contains("Err:     0")) {
                                falloConsumo = "Error";
                                //System.out.println("Error al consumir el servicio, no se obtiene una respuesta adecuada");
                                //throw new PruebaFallidaExcepcion("Error al consumir el servicio, no se obtiene una respuesta adecuada");
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return falloConsumo;
    }
}