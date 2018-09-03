package com.sofka.automatizacion.steps;

import Singleton.ClienteSingleton;
import com.sofka.automatizacion.api.ConsumoRest;
import com.sofka.automatizacion.bussiness.BCRegistro;
import com.sofka.automatizacion.testData.Data;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RestSteps {
    ConsumoRest consumoRest=new ConsumoRest();
    BCRegistro bcRegistro=new BCRegistro();


    @Given("^Ingreso a la pagina de inicio con el navegardor \"([^\"]*)\"$")
    public void ingreso_a_la_pagina_de_inicio_con_el_navegardor(int arg1) throws Throwable {
        bcRegistro.iniciarAplicacion(arg1, Data.url,"PruebaFramework1","Registro");
    }

    @When("^hago el registro con los datos obtenidos de la fuente \"([^\"]*)\"$")
    public void hago_el_registro_con_los_datos_obtenidos_de_la_fuente(String fuente) throws Throwable {
        //se obtienen datos del rest service
        consumoRest.consumirRest();
        bcRegistro.registroValidandoFuenteCliente(fuente);
    }

    @Then("^obtengo resultado del registro$")
    public void obtengo_resultado_del_registro() throws Throwable {
        if ("correcto".equalsIgnoreCase(Data.EMAIL_CORRECTO)){
            Assert.assertTrue("Se esperaba true ", bcRegistro.validarRegistro());
            bcRegistro.cerrarApp();
        }/*else if ("incorrecto".equalsIgnoreCase(Data.EMAIL_INCORRECTO)){
            Assert.assertTrue("Se esperaba true ", bcRegistro.validarEmailError());
            bcRegistro.cerrarApp();        }*/


    }


}
