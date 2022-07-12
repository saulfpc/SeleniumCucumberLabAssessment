package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class pimPage {
    WebDriver driver;

    @FindBy(id = "empsearch_employee_name_empName")
    private WebElement nameInputLocator;

    @FindBy(id = "searchBtn")
    private WebElement searchBtnLocator;

    @FindBy(xpath = "//td/a[contains(text(),'Linda')]")
    private WebElement result;

    public pimPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForEmployee(String name){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nameInputLocator));
        nameInputLocator.sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(searchBtnLocator));
        searchBtnLocator.click();
        wait.until(ExpectedConditions.visibilityOf(result));
    }

    public WebElement getResult(){
        return result;
    }


}
