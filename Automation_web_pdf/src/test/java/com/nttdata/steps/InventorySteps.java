package com.nttdata.steps;

import com.nttdata.page.InventoryPage;
import org.openqa.selenium.WebDriver;

public class InventorySteps {
    private WebDriver driver;

    //contrsuctor
    public InventorySteps(WebDriver driver){
        this.driver = driver;
    }
    public String getTitle(){
        return this.driver.findElement(InventoryPage.eventTitle).getText();
    }

}
