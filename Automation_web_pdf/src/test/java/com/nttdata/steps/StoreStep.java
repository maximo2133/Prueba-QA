package com.nttdata.steps;

import com.nttdata.page.StorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class StoreStep {

    WebDriver driver;
    StorePage page;

    public StoreStep(WebDriver driver){
        this.driver = driver;
        page = new StorePage(driver);

    }
    public void navegarA(String url) {
        driver.get(url);
    }
    public void loguearse(String usuario, String contrasena) {
        page.clickEnBarraIniciarSesion();
        page.ingresaUsuario(usuario);
        page.ingresaPassword(contrasena);
        page.clickEnBotonIniciarSesion();
    }

    public void entrarMen(String clothes, String men) {

        page.clickEnClothes(clothes);
        page.clickMen(men);
    }
    public void clickImagen() {
        page.click();
    }

    public void agregoDosUnidadesDelPrimerProductoAlCarrito(String arg0) {
        page.agregar2unidades(arg0);
        page.clickEnAnadirAlCarrito();
    }
    public void validarProductoAgregado(String producto) {
        Assertions.assertEquals(producto, page.getTituloPrimerProductoValidado());;
    }
    public void validarMontoTotal(String monto) {
        Assertions.assertEquals(monto, page.getMontoTotal());;
    }
    public void clickEnFinalizarCompra() {
        page.clickEnFinalizarCompra();
    }
    public void validarTítuloDeLaPáginaDelCarrtoe(String titulo) {
        Assertions.assertEquals(titulo, page.getTituloCarrito());;
    }
    public void vuelvoAValidarElCálculoDePreciosEnElCarrito(String monto) {
        Assertions.assertEquals(monto, page.getMontoTotalCarrito());
    }
}
