package com.sofka.automatizacion.api;


import com.sofka.automatizacion.dto.DTOOperaciones;

import java.util.ArrayList;
import java.util.List;

public class ControladorServiciosWebCalculator {

    public String obtenerRespuestaOperacion(DTOOperaciones dtoOperaciones) throws Exception {
        try{
            ConsumoServicio consumoServicio = new ConsumoServicio();
            List<String> respuesta = new ArrayList<String>();
            String data = dtoOperaciones.getN1().concat(",").concat(dtoOperaciones.getN2());
            respuesta = consumoServicio.validarServicio("ResultadoCalculator",data,15000,1);
            if(respuesta.get(0).equals("sinError")){
                return(respuesta.get(1));
            }else{
                throw new Exception("El consumo del servicio Calculator termino con error");
            }

        }catch (Exception e){
            throw new Exception("El consumo del servicio Calculator termino con error: " + e.getMessage());
        }
    }

    public DTOOperaciones obtenerInformacionSuma(DTOOperaciones dtoOperaciones) throws Exception {
        try{
            String informacionAdd = obtenerRespuestaOperacion(dtoOperaciones);
            String addResult = informacionAdd.substring(informacionAdd.indexOf("<AddResult>")+"<AddResult>".length(),informacionAdd.indexOf("</AddResult>"));
            dtoOperaciones.setAddResult(addResult);
            return dtoOperaciones;
        }catch (Exception e){
            throw new Exception("No se pudo obtener la suma: " + e.getMessage());
        }
    }
    public DTOOperaciones obtenerInformacionDivision(DTOOperaciones dtoDiv) throws Exception {
        try{
            String informacionDiv = obtenerRespuestaOperacion(dtoDiv);
            String divResult = informacionDiv.substring(informacionDiv.indexOf("<DivideResult>")+"<DivideResult>".length(),informacionDiv.indexOf("</DivideResult>"));
            dtoDiv.setAddResult(divResult);
            return dtoDiv;
        }catch (Exception e){
            throw new Exception("No se pudo obtener la division: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {

    }
}
