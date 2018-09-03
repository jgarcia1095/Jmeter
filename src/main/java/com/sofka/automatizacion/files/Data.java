package com.sofka.automatizacion.files;

public class Data {

    private static volatile Data data;
    private  String NOMBRE_ARCHIVO_FUENTE = "Data2.csv";
    private  String NOMBRE_ARCHIVO_RESPUESTA = "resultadoServicioCalculadoraSuma.csv";

    private Data(){


        //Prevenir instanciacion de un nuevo objeto con reflection api.
        if (data != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }  //private constructor.

    public static Data getInstance(){
        if (data == null) { //Check for the first time

            synchronized (Data.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (data == null) data = new Data();
            }
        }
        return data;
    }

    public String getNombreArchivoFuente() {
        return NOMBRE_ARCHIVO_FUENTE;
    }

    public void setNombreArchivoFuente(String nombreArchivoFuente) {
        NOMBRE_ARCHIVO_FUENTE = nombreArchivoFuente;
    }

    public String getNombreArchivoRespuesta() {
        return NOMBRE_ARCHIVO_RESPUESTA;
    }

    public void setNombreArchivoRespuesta(String nombreArchivoRespuesta) {
        NOMBRE_ARCHIVO_RESPUESTA = nombreArchivoRespuesta;
    }
}