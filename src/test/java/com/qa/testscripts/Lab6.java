package com.qa.testscripts;

import com.qa.utility.encapsulation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

@Listeners(com.qa.utility.Listeners.class)
public class Lab6 extends TestBase{

    encapsulation data = new encapsulation();

    @Test
    public void properties() throws IOException {
        String propertyFilePath= "src/test/java/com/qa/testdata/datafile.properties";
        BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
        Properties properties = new Properties();
        properties.load(reader);

        driver.get(properties.getProperty("url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(properties.getProperty("user"));
        password.sendKeys(properties.getProperty("password"));
        driver.findElement(By.id("btnLogin")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainMenu")));
        data.setTittle(driver.getTitle().toString());
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_admin_viewAdminModule")));
        WebElement menu = driver.findElement(By.id("menu_admin_viewAdminModule"));
        Actions builder = new Actions(driver);
        Action hover = builder.moveToElement(menu).build();
        hover.perform();
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        //driver.findElement(By.id("menu_admin_UserManagement")).isEnabled();
        //driver.findElement(By.id("menu_admin_UserManagement")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchSystemUser_userName")));
        driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Admin");
        driver.findElement(By.id("searchBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr.odd")));
        WebElement table = driver.findElement(By.cssSelector("tr.odd"));


    }

}
