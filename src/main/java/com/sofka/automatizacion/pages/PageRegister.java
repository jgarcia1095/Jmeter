package com.sofka.automatizacion.pages;


import Singleton.ClienteSingleton;
import com.github.javafaker.Faker;
import com.sofka.automatizacion.bussiness.InternalAction;
import com.sofka.automatizacion.testData.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageRegister {

    Faker faker= new Faker();
    String password="Qwerty.1";
    ClienteSingleton clienteSingleton=ClienteSingleton.getInstance();


    @FindAll({@FindBy(xpath= "//div[@class='gender']/span")})List<WebElement> genero;
    @FindBy(id = "FirstName")WebElement txtFirstName;
    @FindBy(id = "LastName")WebElement txtLastName;
    @FindAll({@FindBy (xpath= "//select[@name='DateOfBirthDay']/option")})List<WebElement> lstBirthDay;
    @FindAll({@FindBy (xpath= "//select[@name='DateOfBirthMonth']/option")})List<WebElement> lstMonthDay;
    @FindAll({@FindBy (xpath= "//select[@name='DateOfBirthYear']/option")})List<WebElement> lstYear;
    @FindBy(id = "Email")WebElement txtEmail;
    @FindBy(id = "Company")WebElement txtCompany;
    @FindBy(id = "Newsletter")WebElement chkNewsletter;
    @FindBy(id = "Password")WebElement txtPassword;
    @FindBy(id = "ConfirmPassword")WebElement txtConfirmPassword;
    @FindBy(id = "register-button")WebElement btnregister;
    @FindBy(id = "Email-error")WebElement txtMsgEmailError;


    public void seleccionarGenero(InternalAction internalAction){
        int random= faker.number().numberBetween(0,1);
        internalAction.click(genero.get(random));


    }

    public void setTxtFirstName(InternalAction internalAction){
//        internalAction.sendText(txtFirstName,faker.name().firstName().toUpperCase());
        System.out.println("first name: "+clienteSingleton.getFirstName());
        internalAction.sendText(txtFirstName,clienteSingleton.getFirstName());
    }

    public void setTxtLastName(InternalAction internalAction) {
//        internalAction.sendText(txtLastName,faker.name().lastName().toUpperCase());
        System.out.println("last name: "+clienteSingleton.getLastName());
        internalAction.sendText(txtLastName,clienteSingleton.getLastName());
    }

    public void selectBirthday(InternalAction internalAction) {
        //lstBirthDay.get(faker.number().numberBetween(1,31)));
        internalAction.click(lstBirthDay.get(faker.number().numberBetween(1,31)));
    }

    public void selectMonthday(InternalAction internalAction) {
        internalAction.click(lstMonthDay.get(faker.number().numberBetween(1,12)));
    }

    public void selectYear(InternalAction internalAction) {
        String year=String.valueOf(faker.number().numberBetween(1908,2018));

        for (WebElement element: lstYear) {
            if (internalAction.getTextElement(element).equalsIgnoreCase(year)){
                internalAction.click(element);
                internalAction.printMessage("Se selecciono el año "+internalAction.getTextElement(element)+" , recibiendo un año aleatorio");
                break;
            }
        }
    }

    public void setTxtEmail(InternalAction internalAction) {
        internalAction.sendText(txtEmail,faker.internet().emailAddress());
    }

    public void setTxtCompany(InternalAction internalAction) {
        internalAction.sendText(txtCompany,faker.company().name());
    }

    public void setChkNewsletter(InternalAction internalAction) {
        internalAction.click(chkNewsletter);
    }

    public void setTxtPassword(InternalAction internalAction) {
        internalAction.sendText(txtPassword,password);
    }

    public void setTxtConfirmPassword(InternalAction internalAction) {
        internalAction.sendText(txtConfirmPassword,password);
    }

    public void setBtnregister(InternalAction internalAction) {
        internalAction.click(btnregister);
    }

    public void setTxtEmailFail(InternalAction internalAction) {
        internalAction.sendText(txtEmail,faker.beer().name());
    }

    public boolean getEmailError(InternalAction internalAction)  {
        boolean validation=false;
        if (internalAction.getTextElement(txtMsgEmailError).equalsIgnoreCase(Data.MSG_EMAIL_ERROR))
        {
            validation=true;
        }
        return validation;
    }

}
