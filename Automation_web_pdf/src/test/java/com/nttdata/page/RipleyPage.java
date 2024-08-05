package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RipleyPage {
    private By barraBusquedaInput = By.xpath("//header/section[1]/nav[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/input[1]");
    private By buscar = By.xpath("//header/section[1]/nav[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[2]/button[1]");
    private By primerElementoInput = By.xpath("//body/div[8]/div[2]/div[1]/div[2]/div[3]/section[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[3]/div[5]/div[1]/ul[1]/li[3]");

    private final WebDriver driver;
    private WebDriverWait wait;
    public RipleyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
    }

    public void  buscarEnBarraBusqueda(String texto) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(barraBusquedaInput));
        WebElement barraBusqueda = driver.findElement(barraBusquedaInput);
        barraBusqueda.sendKeys(texto);

    }
    public void clickEnLupaBarraBusqueda() {
        wait.until(ExpectedConditions.elementToBeClickable(buscar));
        WebElement botonBusqueda = driver.findElement(buscar);
        botonBusqueda.click();

    }
    public String getPrecioPrimerProducto() {
        WebElement primerElemento;
        wait.until(ExpectedConditions.visibilityOfElementLocated(primerElementoInput));
        primerElemento= driver.findElement(primerElementoInput);
        //primerElemento.click();
        return primerElemento.getText();
    }
}
