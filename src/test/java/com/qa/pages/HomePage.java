package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    @FindBy(css = "div.head>h1")
    private WebElement sectionHeaderLocator;

    @FindBy(css ="table.quickLaungeContainer td:nth-child(1)")
    private WebElement assignLeaveLocator;

    @FindBy(css ="table.quickLaungeContainer td:nth-child(2)")
    private WebElement leaveListLocator;

    @FindBy(css ="table.quickLaungeContainer td:nth-child(3)")
    private WebElement timesheetLocator;

    @FindBy(css ="table.quickLaungeContainer td:nth-child(4)")
    private WebElement applyLeavesLocator;

    @FindBy(css ="table.quickLaungeContainer td:nth-child(5)")
    private WebElement myLeaveLocator;

    @FindBy(css ="table.quickLaungeContainer td:nth-child(6)")
    private WebElement myTimesheetLocator;

    @FindBy(id = "div_graph_display_emp_distribution")
    private WebElement graphicLocator;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void highLighterMethod(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }

    public void highlightElements(){
        this.highLighterMethod(driver, assignLeaveLocator);
        this.highLighterMethod(driver, timesheetLocator);
        this.highLighterMethod(driver, leaveListLocator);
        this.highLighterMethod(driver, graphicLocator);
    }

    public void validateDashboard(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(sectionHeaderLocator));
        wait.until(ExpectedConditions.visibilityOf(assignLeaveLocator));
        wait.until(ExpectedConditions.visibilityOf(leaveListLocator));
        wait.until(ExpectedConditions.visibilityOf(timesheetLocator));
        wait.until(ExpectedConditions.visibilityOf(graphicLocator));
        Assert.assertTrue(sectionHeaderLocator.isDisplayed());
    }

}
