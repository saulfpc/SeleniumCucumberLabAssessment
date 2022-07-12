package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class directoryMenu {
    WebDriver driver;

    @FindBy(id = "MP_btn")
    private WebElement marketplaceLocator;

    @FindBy(id = "welcome")
    private WebElement welcomeLocator;

    @FindBy(xpath = "(//li[contains(@class,'main-menu-first-level-list-item')])[(1)]")
    private WebElement adminNavigationLocator;

    @FindBy(xpath = "(//li[contains(@class,'main-menu-first-level-list-item')])[(2)]")
    private WebElement pimNavigationLocator;

    @FindBy(xpath = "(//li[contains(@class,'main-menu-first-level-list-item')])[(3)]")
    private WebElement leaveNavigationLocator;

    @FindBy(xpath = "(//li[contains(@class,'main-menu-first-level-list-item')])[(4)]")
    private WebElement timeNavigationLocator;

    @FindBy(xpath = "(//li[contains(@class,'main-menu-first-level-list-item')])[(5)]")
    private WebElement recruitmentNavigationLocator;

    @FindBy(xpath = "(//li[contains(@class,'main-menu-first-level-list-item')])[(6)]")
    private WebElement myInfoNavigationLocator;

    @FindBy(xpath = "(//li[contains(@class,'main-menu-first-level-list-item')])[(7)]")
    private WebElement performanceNavigationLocator;

    @FindBy(xpath = "(//li[contains(@class,'main-menu-first-level-list-item')])[(8)]")
    private WebElement dashboardNavigationLocator;

    @FindBy(xpath = "(//li[contains(@class,'main-menu-first-level-list-item')])[(9)]")
    private WebElement directoryNavigationLocator;

    @FindBy(xpath = "(//li[contains(@class,'main-menu-first-level-list-item')])[(10)]")
    private WebElement maintenancesNavigationLocator;

    @FindBy(xpath = "(//li[contains(@class,'main-menu-first-level-list-item')])[(11)]")
    private WebElement buzzNavigationLocator;

    @FindBy(css = "div.head>h1")
    private WebElement sectionHeaderLocator;

    @FindBy(id = "mainMenu")
    private WebElement mainMenuLocator;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logoutLocator;


    public directoryMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToAdmin(){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainMenu")));
        wait.until(ExpectedConditions.visibilityOf(adminNavigationLocator));
        wait.until(ExpectedConditions.elementToBeClickable(adminNavigationLocator));
        adminNavigationLocator.click();
        adminNavigationLocator.click();
        wait.until(ExpectedConditions.urlContains("/admin/viewSystemUsers"));
    }
    public void navigateToPim(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainMenu")));
        wait.until(ExpectedConditions.visibilityOf(pimNavigationLocator));
        wait.until(ExpectedConditions.elementToBeClickable(pimNavigationLocator));
        pimNavigationLocator.click();
        wait.until(ExpectedConditions.urlContains("/pim/"));
    }
    public void navigateToLeave(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainMenu")));
        wait.until(ExpectedConditions.visibilityOf(leaveNavigationLocator));
        wait.until(ExpectedConditions.elementToBeClickable(leaveNavigationLocator));
        leaveNavigationLocator.click();
        leaveNavigationLocator.click();
        wait.until(ExpectedConditions.urlContains("/leave/viewLeaveList"));
    }
    public void navigateToDashboard(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainMenu")));
        wait.until(ExpectedConditions.visibilityOf(dashboardNavigationLocator));
        wait.until(ExpectedConditions.elementToBeClickable(dashboardNavigationLocator));
        dashboardNavigationLocator.click();
        dashboardNavigationLocator.click();
        wait.until(ExpectedConditions.urlContains("/dashboard"));
    }
    public void navigateToDirectory(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainMenu")));
        wait.until(ExpectedConditions.visibilityOf(directoryNavigationLocator));
        wait.until(ExpectedConditions.elementToBeClickable(directoryNavigationLocator));
        directoryNavigationLocator.click();
        directoryNavigationLocator.click();
        wait.until(ExpectedConditions.urlContains("/directory/"));
    }
    public void navigateToMaintenances(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainMenu")));
        wait.until(ExpectedConditions.visibilityOf(maintenancesNavigationLocator));
        wait.until(ExpectedConditions.elementToBeClickable(maintenancesNavigationLocator));
        maintenancesNavigationLocator.click();
        maintenancesNavigationLocator.click();
        wait.until(ExpectedConditions.urlContains("/maintenance"));
    }

    public WebElement getHeader(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(sectionHeaderLocator));
        return sectionHeaderLocator;
    }

    public void highLighterMethod(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }
    public void highlightElement(){
        this.highLighterMethod(driver, adminNavigationLocator);
        this.highLighterMethod(driver, pimNavigationLocator);
        this.highLighterMethod(driver, timeNavigationLocator);
        this.highLighterMethod(driver, maintenancesNavigationLocator);
        this.highLighterMethod(driver, marketplaceLocator);
        this.highLighterMethod(driver, welcomeLocator);
    }

    public void visibilityNavigation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(adminNavigationLocator));
        wait.until(ExpectedConditions.visibilityOf(pimNavigationLocator));
        Assert.assertTrue(adminNavigationLocator.isDisplayed());
        Assert.assertTrue(pimNavigationLocator.isDisplayed());
        Assert.assertTrue(leaveNavigationLocator.isDisplayed());
        Assert.assertTrue(timeNavigationLocator.isDisplayed());
        Assert.assertTrue(recruitmentNavigationLocator.isDisplayed());
        Assert.assertTrue(myInfoNavigationLocator.isDisplayed());
        Assert.assertTrue(performanceNavigationLocator.isDisplayed());
        Assert.assertTrue(dashboardNavigationLocator.isDisplayed());
        Assert.assertTrue(directoryNavigationLocator.isDisplayed());
        Assert.assertTrue(maintenancesNavigationLocator.isDisplayed());
        Assert.assertTrue(buzzNavigationLocator.isDisplayed());
    }
    public void validateMainMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(mainMenuLocator));
        Assert.assertTrue(mainMenuLocator.isDisplayed());
    }

    public void validateWelcome(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(welcomeLocator));
        Assert.assertTrue(welcomeLocator.isDisplayed());
        welcomeLocator.click();
    }

    public void logout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logoutLocator));
        logoutLocator.click();
    }


}
