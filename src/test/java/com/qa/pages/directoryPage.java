package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class directoryPage {
    WebDriver driver;
    @FindBy(id = "searchDirectory_emp_name_empName")
    private WebElement inputSearchNameLocator;

    @FindBy(id ="searchDirectory_job_title")
    private WebElement comboBoxJobSelectionLocator;

    @FindBy(id = "searchDirectory_location")
    private WebElement comboBoxLocationSelectLocator;

    @FindBy(css = "input#searchBtn")
    private WebElement searchBtnLocator;

    @FindBy(xpath = "//input[@id='resetBtn']")
    private WebElement resetBtnLocator;

    @FindBy(css = "table#resultTable")
    private WebElement tableLocator;

    @FindBy(xpath = "//li/b[contains(text(),'Odis')]")
    private WebElement odisLocator;



    public directoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void inputEmployeeName(String name){
        inputSearchNameLocator.sendKeys(name);
        searchBtnLocator.click();
    }

    public void assertSearchResult(String name){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(odisLocator));
        Assert.assertEquals(odisLocator.getText(), name);
    }



}
