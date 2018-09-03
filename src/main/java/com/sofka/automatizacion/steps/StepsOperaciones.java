package com.sofka.automatizacion.steps;

import com.sofka.automatizacion.bussiness.BCOperaciones;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsOperaciones {
    BCOperaciones bcOperaciones=new BCOperaciones();

    @Given("^las rutas para leer datos y almacenar resultados de la \"([^\"]*)\"$")
    public void las_rutas_para_leer_datos_y_almacenar_resultados_de_la(String arg1){
        System.out.println("se va a ejecutar bcoperaciones.seleccionaroperacion");
        bcOperaciones.seleccionarOperacion(arg1);
    }
    @When("^ingreso los numeros \"([^\"]*)\" y \"([^\"]*)\" los proceso con la operacion \"([^\"]*)\"$")
    public void ingreso_los_numeros_y_los_proceso_con_la_operacion(String numero1, String numero2,String operacion) throws Throwable {

        bcOperaciones.insertarNumerosAOperar(operacion,numero1,numero2);
    }
    @Then("^obtengo resultado de la operacion$")
    public void obtengo_resultado_de_la_operacion() throws Throwable {
        bcOperaciones.obtenerRespuestaSuma();
    }
    @Then("^obtengo resultado de la \"([^\"]*)\"$")
    public void obtengo_resultado_de_la(String operacion) throws Throwable {
      bcOperaciones.obtenerRespuestaOperacion(operacion);
    }




}
