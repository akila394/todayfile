package com.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlanetPage {
    private final WebElement planetElement;

    public PlanetPage(WebElement planetElement) {
        this.planetElement = planetElement;
    }

    public String getName(){
        return planetElement.findElement(By.xpath())
    }

    public void clickExplore()
    {

    }
}
