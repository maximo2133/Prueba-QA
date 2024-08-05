package com.nttdata.stepsdefinitions;

import com.nttdata.steps.StoreStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StoreStepdefs {

    private StoreStep store;
    private WebDriver driver;
    private Scenario scenario;


    @Before(order = 0)
    public void setUp(){
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        store = new StoreStep(driver);
        store.navegarA("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    @And("me logueo con mi direccion de correo electronico {string} y clave {string}")
    public void meLogueoConMiDireccionDeCorreoElectronicoYClave(String usuario, String contrasena) {
        store.loguearse(usuario, contrasena);
        screenShot();

    }

    @When("navego a la categoría {string} y subcategoría {string}")
    public void navegoALaCategoríaYSubcategoría(String clothes, String men) {
        store.entrarMen(clothes, men);
        screenShot();
    }
    @And("hago click en la imagen del primer {string}")
    public void hagoClickEnLaImagenDel(String producto) {
        store.clickImagen();
        screenShot();

    }
    @And("agrego {string} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(String arg0) {
        store.agregoDosUnidadesDelPrimerProductoAlCarrito(arg0);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado {string}")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado(String producto) {
        store.validarProductoAgregado(producto);
        screenShot();
    }

    @And("valido en el popup que el monto total sea {string}")
    public void validoEnElPopupQueElMontoTotalSea(String monto) {
        store.validarMontoTotal(monto);
        screenShot();
    }
    @And("hago click en Finalizar Compra")
    public void hagoClickEnFinalizarCompra() {
        store.clickEnFinalizarCompra();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        screenShot();
    }
    @Then("valido el título de la página del carrito {string}")
    public void validoElTítuloDeLaPáginaDelCarrito(String titulo) {
        store.validarTítuloDeLaPáginaDelCarrtoe(titulo);
        screenShot();
    }
    @And("vuelvo a validar el cálculo de precios en el carrito que sea {string}")
    public void vuelvoAValidarElCálculoDePreciosEnElCarritoQueSea(String monto) {
        store.vuelvoAValidarElCálculoDePreciosEnElCarrito(monto);
        screenShot();
    }
    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }
}
