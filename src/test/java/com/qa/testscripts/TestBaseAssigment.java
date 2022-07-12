package com.qa.testscripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestBaseAssigment {
    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriver driver;

    @BeforeTest
    public void startUp(){
        System.out.println("starting .........");
    }

    @AfterTest
    public void stopTest(){
        System.out.println("End ================");
    }

    @BeforeSuite
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.quit();
    }

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
