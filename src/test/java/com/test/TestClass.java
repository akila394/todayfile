package com.test;

import com.model.Planet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestClass {
    WebDriver driver;
    @BeforeEach
    public void setUp()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @Test
    public void findingDistanceTest() throws InterruptedException {
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        driver.findElement(By.cssSelector("[aria-label='planets']")).click();
        var planetsList = driver.findElements(By.cssSelector("[class='planet']"));
        for(WebElement planet: planetsList){
        }

        Thread.sleep(3000);
    }

    @Test
    public void ExploreTest()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("[aria-label='planets']")).click();
        Planet planet = new Planet(driver);
        planet.clickExplore("Earth");
        Assertions.assertEquals("Exploring Earth", driver.findElement(
                By.cssSelector("[class*='popup-message']")).getText());
    }

    @AfterEach
    public void cleanUp()
    {
        driver.quit();
    }
}
