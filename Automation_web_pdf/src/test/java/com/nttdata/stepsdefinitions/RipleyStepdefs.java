package com.nttdata.stepsdefinitions;

import com.nttdata.steps.RipleyStep;
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

public class RipleyStepdefs {
    private RipleyStep ripley;
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

    @Given("el usuario está en la página de inicio de Ripley")
    public void elUsuarioEstáEnLaPáginaDeInicioDeRipley() {
        ripley = new RipleyStep(driver);
        ripley.navegarA("https://simple.ripley.com.pe/");
        screenShot();
    }

    @When("el usuario ingresa {string} en el campo de búsqueda")
    public void elUsuarioIngresaEnElCampoDeBúsqueda(String arg0) throws InterruptedException {
        ripley.buscarProducto(arg0);
        screenShot();
    }

    @Then("una lista de resultados")
    public void unaListaDeResultados() {
    }
    @And("valido el primer precio del resultado sea {string}")
    public void validoElPrimerPrecioDelResultadoSea(String arg0) {
        ripley.validarPrecioPrimerResultado(arg0);
        screenShot();
    }
    private void screenShot() {
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

}
