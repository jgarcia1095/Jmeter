package com.sofka.automatizacion.bussiness;

import com.sofka.automatizacion.api.ControladorServiciosWebCalculator;
import com.sofka.automatizacion.dto.DTOOperaciones;
import com.sofka.automatizacion.files.Data;

public class BCOperaciones {
    Data data=Data.getInstance();
    DTOOperaciones dtoSuma;
    DTOOperaciones dtoDiv;
    static BCOperaciones bcOperaciones=new BCOperaciones();
    ControladorServiciosWebCalculator controladorServiciosWebCalculator = new ControladorServiciosWebCalculator();

    public  void seleccionarOperacion(String operacion) {
       operacion=operacion.toUpperCase();
        switch (operacion) {
            case "SUMA":
                bcOperaciones.asignarFuentesResultadosSuma();
                break;
            case "RESTA":

            case "DIVISION":
                bcOperaciones.asignarFuentesResultadosDivision();
                break;

            default:
                throw new IllegalArgumentException("Operacion invalida: "
                        + operacion);
        }

    }

    public void asignarFuentesResultadosSuma(){
        data.setNombreArchivoFuente("DataSuma.csv");
        data.setNombreArchivoRespuesta("resultadoServicioCalculadoraSuma.csv");
    }

    public void asignarFuentesResultadosDivision(){
        data.setNombreArchivoFuente("DataDivision.csv");
        data.setNombreArchivoRespuesta("resultadoServicioCalculadoraDivision.csv");

    }

    public void insertarNumerosAOperar(String operacion, String numero1, String numero2){
        operacion=operacion.toUpperCase();
        switch (operacion) {
            case "SUMA":
                dtoSuma = new DTOOperaciones(numero1,numero2);
                break;
            case "RESTA":

            case "DIVISION":
                dtoDiv = new DTOOperaciones(numero1,numero2);
                break;

            default:
                throw new IllegalArgumentException("Operacion invalida: "
                        + operacion);
        }


    }

    public void obtenerRespuestaSuma() throws Exception {

        dtoSuma = controladorServiciosWebCalculator.obtenerInformacionSuma(dtoSuma);
        System.out.println("El resultado de la suma es: "+ dtoSuma.getAddResult());
    }
public void obtenerRespuestaDivision() throws Exception {

        dtoDiv = controladorServiciosWebCalculator.obtenerInformacionDivision(dtoDiv);
        System.out.println("El resultado de la division es: "+dtoDiv.getAddResult());
    }

    public void obtenerRespuestaOperacion(String operacion) throws Exception {
        operacion=operacion.toUpperCase();
        switch (operacion) {
            case "SUMA":
               obtenerRespuestaSuma();
                break;
            case "RESTA":

            case "DIVISION":
                obtenerRespuestaDivision();
                break;

            default:
                throw new IllegalArgumentException("Operacion invalida: "
                        + operacion);
        }
    }
}
