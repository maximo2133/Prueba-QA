package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StorePage {
    private WebDriver driver;

    private By botonIniciarSesionPaginaPrincipal =  By.xpath("//header/nav[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/a[1]/span[1]");
    private By CorreoInput =  By.xpath("//input[@id='field-email']");
    private By ContrasenaInput =  By.xpath("//input[@id='field-password']");
    private By BotonIniciarSesion =  By.xpath("//button[@id='submit-login']");


    private By BotonClothes=  By.xpath("//header/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]");
    private By BotonMen =  By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]");
    private By imgProduct=  By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[2]/section[1]/section[1]/div[3]/div[1]/div[1]/article[1]/div[1]/div[1]/a[1]/picture[1]/img[1]");

    private By iAumentar=  By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/span[3]/button[1]/i[1]");
    private By botonAnadir=  By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/button[1]");

    private By mensajeValidacion= By.xpath("//h4[@id='myModalLabel']");
    private By spanMonto= By.xpath("//body/div[@id='blockcart-modal']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/p[4]/span[2]");
    private By botonFinalizarCompra= By.xpath("//body/div[@id='blockcart-modal']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]");
    private By tituloCarrito= By.xpath("//h1[contains(text(),'Carrito')]");
    private By montoCarrito= By.xpath("//strong[contains(text(),'S/ 38.24')]");



    public StorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    private WebDriverWait wait;

    public void clickEnBarraIniciarSesion() {
        wait.until(ExpectedConditions.elementToBeClickable(botonIniciarSesionPaginaPrincipal));
        WebElement botonIniciarSesionMenu = driver.findElement(botonIniciarSesionPaginaPrincipal);
        botonIniciarSesionMenu.click();
    }

    public void ingresaUsuario(String user) {
        WebElement correoInputElement = driver.findElement(CorreoInput);
        correoInputElement.sendKeys(user);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(BotonIniciarSesion));
    }

    public void ingresaPassword(String password) {
        this.driver.findElement(ContrasenaInput).sendKeys(password);
    }

    public void clickEnBotonIniciarSesion() {
        WebElement botonIniciarSesion = driver.findElement(BotonIniciarSesion);
        botonIniciarSesion.click();
    }

    public void clickEnClothes(String arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement botonCloth = wait.until(ExpectedConditions.elementToBeClickable(BotonClothes));
        botonCloth.click();

    }

    public void clickMen(String arg1) {
        WebElement botonIniciarSesion = driver.findElement(BotonMen);
        botonIniciarSesion.click();
    }

    public void click() {
        WebElement imgPro = driver.findElement(imgProduct);
        imgPro.click();
    }

    public void agregar2unidades(String arg0) {
        WebElement botonIncrementar = driver.findElement(iAumentar);
        botonIncrementar.click();
    }

    public void clickEnAnadirAlCarrito() {
        WebElement botonAnadirCarrito = wait.until(ExpectedConditions.elementToBeClickable(botonAnadir));
        botonAnadirCarrito.click();
    }


    public String getTituloPrimerProductoValidado() {
        WebElement mensajeValidado;
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeValidacion));
            mensajeValidado= driver.findElement(mensajeValidacion);
        }catch (Exception e){
            wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeValidacion));
            mensajeValidado= driver.findElement(mensajeValidacion);
        }
        return mensajeValidado.getText();

    }

    public String getMontoTotal() {
        WebElement spanMontoTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(spanMonto));
        return spanMontoTotal.getText();
    }

    public void clickEnFinalizarCompra() {
        WebElement botonFinalizar = wait.until(ExpectedConditions.elementToBeClickable(botonFinalizarCompra));
        botonFinalizar.click();
    }

    public String getTituloCarrito() {
        WebElement tituloValidado;
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(tituloCarrito));
            tituloValidado= driver.findElement(tituloCarrito);
        }catch (Exception e){
            wait.until(ExpectedConditions.visibilityOfElementLocated(tituloCarrito));
            tituloValidado= driver.findElement(tituloCarrito);
        }
        return tituloValidado.getText();
    }

    public String getMontoTotalCarrito() {
        WebElement montoTotalCar = wait.until(ExpectedConditions.visibilityOfElementLocated(montoCarrito));
        return montoTotalCar.getText();
    }
}
