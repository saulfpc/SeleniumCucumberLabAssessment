package com.qa.testscripts;

import org.testng.annotations.Test;

public class Lab1 extends TestBase{

    @Test
    public void openWeb(){
        driver.get("https://www.google.com/");
        String url = driver.getCurrentUrl();
        if (url.contains("google")){
            System.out.println("The url contain google");
        }
    }

}
