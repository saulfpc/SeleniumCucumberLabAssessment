package com.qa.testscripts;

import org.testng.annotations.Test;

public class Lab2 extends TestBase{

    @Test
    public void print(){
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        driver.get("https://www.google.com/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
    }

}
