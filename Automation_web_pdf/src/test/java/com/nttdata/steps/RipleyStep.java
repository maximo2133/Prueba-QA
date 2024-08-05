package com.nttdata.steps;

import com.nttdata.page.RipleyPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class RipleyStep {
    WebDriver driver;
    RipleyPage ripley;

    public RipleyStep(WebDriver driver){
        this.driver = driver;
        ripley = new RipleyPage(driver);
    }

    public void navegarA(String url) {
        driver.get(url);
    }


    public void buscarProducto(String arg0) throws InterruptedException {
        ripley.buscarEnBarraBusqueda(arg0);
        ripley.clickEnLupaBarraBusqueda();
    }

    public void validarPrecioPrimerResultado(String precioProducto) {
        Assertions.assertEquals(precioProducto, ripley.getPrecioPrimerProducto());
    }
}
