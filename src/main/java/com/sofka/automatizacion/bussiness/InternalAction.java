package com.sofka.automatizacion.bussiness;

import co.com.sofka.test.gui.GeneralActions;
import co.com.sofka.test.gui.ManagementBrowser;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class InternalAction extends GeneralActions {
//
//    public InternalAction(String carpeta) {
//        super(carpeta);
//    }


    private static volatile InternalAction utilInstance;

    private InternalAction(){


        //Prevenir instanciacion de un nuevo objeto con reflection api.
        if (utilInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }  //private constructor.

    public static InternalAction getInstance(){
        if (utilInstance == null) { //Check for the first time

            synchronized (InternalAction.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (utilInstance == null) utilInstance = new InternalAction();
            }
        }
        return utilInstance;
    }
    public WebDriver getDriverRemotoLocal (String remotoLocal,int navegador) throws Exception {
        remotoLocal=remotoLocal.toUpperCase();
        switch(remotoLocal) {
            case "REMOTO":
                    driver=getRemote(navegador);
                break;
            case "LOCAL":
                ManagementBrowser browser = new ManagementBrowser();
                try {

                    driver = browser.getDriverBrowser(navegador);
                } catch (Exception e) {

                    printFailure("No fué posible obtener del driver del navegador para pruebas" + e);
                    closeAndQuitTest();
                    Assert.fail("No fué posible obtener del driver del navegador para pruebas");
                }
                break;
            default:
                throw new Exception("Error al iniciar el driver : " + remotoLocal);
        }

        return this.driver;
    }


    public WebDriver getRemote(int navegador) throws MalformedURLException {
        if (navegador==0){
            DesiredCapabilities capabilities1 = DesiredCapabilities.chrome();
            capabilities1.setCapability("maxInstances", "1");
            capabilities1.setCapability("maxSession", "2");
            capabilities1.setCapability("version","");
            capabilities1.setCapability("platform","LINUX");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities1);
        }else if (navegador==2){
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("maxInstances", "1");
            capabilities.setCapability("maxSession", "2");
//                capabilities.setCapability("marionette", true);
            capabilities.setCapability("version","");
            capabilities.setCapability("platform","LINUX");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
        }
        return driver;
    }

}
