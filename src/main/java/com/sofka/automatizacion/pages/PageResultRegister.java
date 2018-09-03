package com.sofka.automatizacion.pages;

import com.sofka.automatizacion.bussiness.InternalAction;
import com.sofka.automatizacion.testData.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageResultRegister {
    @FindBy(xpath = "//div[@class='result']")WebElement lblRegistrationComplete;

    public boolean getLblRegistrationComplete(InternalAction internalAction)  {
        boolean validation=false;

        if (internalAction.getTextElement(lblRegistrationComplete).equalsIgnoreCase(Data.msjConfirmationRegister)){
            validation=true;
        }


        return validation;
    }
}
