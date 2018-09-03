package com.sofka.automatizacion.api;

import com.sofka.automatizacion.files.Data;
import com.sofka.automatizacion.files.GestionArchivos;

import java.util.ArrayList;
import java.util.List;

public class ConsumoServicio {
    Data data=Data.getInstance();


    public List<String> validarServicio(String nombreScript, String request, int tiempo, int hilos) throws Exception {
        List<String> respuesta = new ArrayList<String>();
        String complementoTiempo = " -Jtiempo=" + tiempo;
        String complementoHilos = " -JbucleHilos=" + hilos;
        String complementoServicio = complementoTiempo + complementoHilos;

        GestionJmeter jmeter = new GestionJmeter();
        GestionArchivos archivo = new GestionArchivos();

        archivo.borrarArchivosExistentes();
        archivo.escribirArchivo(data.getNombreArchivoFuente(), request);
        respuesta.add(jmeter.ejecutarJmeter(nombreScript, complementoServicio));
        respuesta.add(archivo.leerArchivo(data.getNombreArchivoRespuesta())[0]);
        return respuesta;
    }

}
