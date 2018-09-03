package com.sofka.automatizacion.pages;

import com.sofka.automatizacion.bussiness.InternalAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHome {
    @FindBy(linkText = "Register")WebElement btnRegistro;

    public void clicBtnRegistro(InternalAction internalAction)
    {
        internalAction.click(btnRegistro);
    }

}
