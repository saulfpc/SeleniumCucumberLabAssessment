package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Lab4 extends TestBase{

    @Test
    public void alertHandle() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header>a>img")));
        List<WebElement> buttons = driver.findElements(By.cssSelector("button.btn"));
        this.findAlertButton("Click Button to see alert");
        driver.switchTo().alert().accept();
        this.findAlertButton("On button click, confirm box will appear");
        driver.switchTo().alert().accept();
        this.findAlertButton("On button click, prompt box will appear");
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().dismiss();
        this.findByTextAndClick("Browser Windows");
        this.findByTextAndClick("New Tab");
        this.findByTextAndClick("New Tab");
        this.multipleTabs();

    }

    public void findAlertButton(String option){
        WebElement firstButton = driver.findElement(By.xpath("//*[contains(text(),'"+option+"')]"));
        WebElement parent = firstButton.findElement(By.xpath("./../..")).findElement(By.cssSelector("button[type='button']"));
        parent.click();
    }
    public void findByTextAndClick(String option){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement locator = driver.findElement(By.xpath("//*[contains(text(),'"+option+"')]"));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }

    public void multipleTabs(){
        String parent=driver.getWindowHandle();
        Set<String> s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext())
        {
            String child_window=I1.next();
            if(!parent.equals(child_window))
            {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getCurrentUrl());
                driver.close();
            }
        }
        driver.switchTo().window(parent);
    }
}
