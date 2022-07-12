package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab5 extends TestBase{



    @Test
    public void actions() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement AccountAndList = driver.findElement(By.cssSelector("#nav-tools>a.nav-a-2>div.nav-line-1-container"));
        Actions builder = new Actions(driver);
        Action hover = builder.moveToElement(AccountAndList).build();
        hover.perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement container = driver.findElement(By.cssSelector("#nav-al-container"));
        wait.until(ExpectedConditions.visibilityOf(container));
        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("headset");
        Action select = builder.click(searchBox).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build();
        Action copy = builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build();
        Action paste = builder.click(searchBox).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build();
        select.perform();
        copy.perform();
        searchBox.clear();
        Thread.sleep(3000);
        paste.perform();
        Thread.sleep(3000);
        


    }


}
