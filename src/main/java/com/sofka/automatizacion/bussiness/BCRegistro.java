package com.sofka.automatizacion.bussiness;


import com.sofka.automatizacion.pages.PageHome;
import com.sofka.automatizacion.pages.PageRegister;
import com.sofka.automatizacion.pages.PageResultRegister;
import com.sofka.automatizacion.testData.Data;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BCRegistro {
    InternalAction internalAction=InternalAction.getInstance();
    WebDriver driver;

    public void iniciarAplicacion(int navegador, String url, String carpeta, String funcionalidad) throws Exception {

        try {
            driver=internalAction.getDriverRemotoLocal(Data.AMBIENTE_NAVEGADOR,navegador );
        } catch (Exception e) {
            internalAction.printFailure("No fué posible obtener del driver del navegador para pruebas" + e);
            internalAction.closeAndQuitTest();
            Assert.fail("No fué posible obtener del driver del navegador para pruebas");
        }
//        internalAction = new InternalAction();
        internalAction.setFuncionalidad(funcionalidad);
        internalAction.setDriver(driver);
        internalAction.printMessage("*****************************************************************************");
        internalAction.printMessage("INICIO TRANSACCIÓN: " + funcionalidad + "");
        internalAction.printMessage("*****************************************************************************");
        try {
            internalAction.openUrl(url);
            internalAction.printMessage("Se abrió la url " + url + " exitosamente");
        } catch (Exception e) {
            internalAction.printFailure("No se abrió la URL de la aplicación parametrizada:" + " " + e);

        }
    }

    public void registroValidandoFuenteCliente(String fuente) {
        if (fuente.equalsIgnoreCase("rest")){
            registrarConRestData();
        }
    }

    private void registrarConRestData() {
        try {
            PageHome pageHome = PageFactory.initElements(internalAction.getDriver(), PageHome.class);
            PageRegister pageRegister= PageFactory.initElements(internalAction.getDriver(), PageRegister.class);
            pageHome.clicBtnRegistro(internalAction);
            pageRegister.seleccionarGenero(internalAction);
            pageRegister.setTxtFirstName(internalAction);
            pageRegister.setTxtLastName(internalAction);
            pageRegister.selectBirthday(internalAction);
            pageRegister.selectMonthday(internalAction);
            pageRegister.selectYear(internalAction);
            pageRegister.setTxtEmail(internalAction);
            pageRegister.setTxtCompany(internalAction);
            pageRegister.setChkNewsletter(internalAction);
            pageRegister.setTxtPassword(internalAction);
            pageRegister.setTxtConfirmPassword(internalAction);
            pageRegister.setBtnregister(internalAction);
        } catch (Exception e) {
            internalAction.getDriver().close();
        }
    }

    public boolean validarRegistro() {
        PageResultRegister pageResultRegister = PageFactory.initElements(internalAction.getDriver(),PageResultRegister.class);
        return pageResultRegister.getLblRegistrationComplete(internalAction);
    }


    /*

    public void registrarEmailCorrecto() {

        try {
            PageHome pageHome = PageFactory.initElements(internalAction.getDriver(), PageHome.class);
            PageRegister pageRegister= PageFactory.initElements(internalAction.getDriver(), PageRegister.class);
            pageHome.clicBtnRegistro(internalAction);
            pageRegister.seleccionarGenero(internalAction);
            pageRegister.setTxtFirstName(internalAction);
            pageRegister.setTxtLastName(internalAction);
            pageRegister.selectBirthday(internalAction);
            pageRegister.selectMonthday(internalAction);
            pageRegister.selectYear(internalAction);
            pageRegister.setTxtEmail(internalAction);
            pageRegister.setTxtCompany(internalAction);
            pageRegister.setChkNewsletter(internalAction);
            pageRegister.setTxtPassword(internalAction);
            pageRegister.setTxtConfirmPassword(internalAction);
            pageRegister.setBtnregister(internalAction);
        } catch (Exception e) {
            internalAction.getDriver().close();
        }
    }

    public void registrarEmailIncorrecto() {

        try {
            PageHome pageHome = PageFactory.initElements(internalAction.getDriver(), PageHome.class);
            PageRegister pageRegister= PageFactory.initElements(internalAction.getDriver(), PageRegister.class);
            pageHome.clicBtnRegistro(internalAction);
            pageRegister.seleccionarGenero(internalAction);
            pageRegister.setTxtFirstName(internalAction);
            pageRegister.setTxtLastName(internalAction);
            pageRegister.selectBirthday(internalAction);
            pageRegister.selectMonthday(internalAction);
            pageRegister.selectYear(internalAction);
            pageRegister.setTxtEmailFail(internalAction);
            pageRegister.setTxtCompany(internalAction);
            pageRegister.setChkNewsletter(internalAction);
            pageRegister.setTxtPassword(internalAction);
            pageRegister.setTxtConfirmPassword(internalAction);
            pageRegister.setBtnregister(internalAction);
        } catch (Exception e) {
            internalAction.getDriver().close();
        }
    }

*/
/*
    public void registroValindandoEmail(String tipoEmail){

        if (tipoEmail.equalsIgnoreCase(Data.EMAIL_CORRECTO)){
            registrarEmailCorrecto();
        }else if (tipoEmail.equalsIgnoreCase(Data.EMAIL_INCORRECTO)){
            registrarEmailIncorrecto();
        }

    }
*/

//validar resultados al final de la prueba
/*

    public boolean validarEmailError() {
        PageRegister pageRegister= PageFactory.initElements(internalAction.getDriver(), PageRegister.class);
        return pageRegister.getEmailError(internalAction);
    }
*/

    public void cerrarApp(){
        internalAction.getDriver().close();
    }

}
