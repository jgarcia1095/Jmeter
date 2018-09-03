package com.sofka.automatizacion.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GestionArchivos {
    private  String rutaArchivos = "c:\\temp\\";

    private void validarDirectorioArchivos() {
        File directorioJmeter = new File(rutaArchivos + "resultadosJmeter");
        File directorioConsulta = new File(rutaArchivos + "fuentesJmeter");
        File directorioEvidencias = new File(rutaArchivos + "evidencias");
        if (!directorioJmeter.exists()) {
            directorioJmeter.mkdirs();
        }
        if (!directorioConsulta.exists()) {
            directorioConsulta.mkdirs();
        }
        if (!directorioEvidencias.exists()) {
            directorioEvidencias.mkdirs();
        }
    }

    public void borrarArchivosExistentes(){
        File directorioJmeter = new File(rutaArchivos + "resultadosJmeter");
        File directorioConsulta = new File(rutaArchivos + "fuentesJmeter");
        borrarArchivosDirectorio(directorioJmeter);
        borrarArchivosDirectorio(directorioConsulta);
    }


    private boolean borrarArchivosDirectorio(File dir) {
        File[] children = dir.listFiles();
        boolean childrenDeleted = true;
        for (int i = 0; children != null && i < children.length; i++) {
            File child = children[i];
            if (child.isDirectory()) {
                childrenDeleted = this.borrarArchivosDirectorio(child) && childrenDeleted;
            }
            if (child.exists()) {
                childrenDeleted = child.delete() && childrenDeleted;
            }
        }
        return childrenDeleted;
    }



    public void escribirArchivo(String nombreArchivo, String datos) {
        validarDirectorioArchivos();
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(rutaArchivos + "fuentesJmeter\\"+nombreArchivo);
            pw = new PrintWriter(fichero);
            pw.print(datos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public String[] leerArchivo(String nombreArchivo) {
        validarDirectorioArchivos();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea="";
        String response = "";
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(rutaArchivos + "resultadosJmeter/" + nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero

            while ((linea = br.readLine()) != null) {
                response = response + linea;
                linea = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String [] auxiliar=response.split("\\n");
        return auxiliar;

    }
}