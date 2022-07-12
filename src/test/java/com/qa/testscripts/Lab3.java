package com.qa.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Lab3 extends TestBase{

    @Test
    public void google(){
        driver.get("https://www.google.com/");
        System.out.println(driver.findElement(By.xpath("//input[@role='combobox']")).getAriaRole());
        System.out.println(driver.findElement(By.cssSelector("input[name='q']")).getAriaRole());

    }

    @Test
    public void facebook(){
        driver.get("https://www.facebook.com/");
        System.out.println(driver.findElement(By.cssSelector("#email")).getAriaRole());
        System.out.println(driver.findElement(By.cssSelector("#passContainer")).getAriaRole());
        System.out.println(driver.findElement(By.cssSelector("button[name=login]")).getAriaRole());
        System.out.println(driver.findElement(By.cssSelector("._6ltg>a[role=button]")).getAriaRole());
    }

}
