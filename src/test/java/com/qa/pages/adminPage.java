package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class adminPage {
    WebDriver driver;
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


    @FindBy(xpath = "(//li[@class='current main-menu-first-level-list-item']/ul/li/a)[(1)]")
    private WebElement userManagementLocator;

    @FindBy(xpath = "(//li[@class='current main-menu-first-level-list-item']/ul/li/a)[(2)]")
    private WebElement jobLocator;

    @FindBy(xpath = "(//li[@class='current main-menu-first-level-list-item']/ul/li/a)[(3)]")
    private WebElement organizationLocator;

    @FindBy(xpath = "(//li[@class='current main-menu-first-level-list-item']/ul/li/a)[(4)]")
    private WebElement qualificationLocator;

    @FindBy(xpath = "(//li[@class='current main-menu-first-level-list-item']/ul/li/a)[(5)]")
    private WebElement nationalitiesLocator;

    @FindBy(xpath = "(//li[@class='current main-menu-first-level-list-item']/ul/li/a)[(6)]")
    private WebElement corporateLocator;

    @FindBy(xpath = "(//li[@class='current main-menu-first-level-list-item']/ul/li/a)[(7)]")
    private WebElement configurationLocator;

    @FindBy(id="menu_admin_viewJobTitleList")
    private WebElement jobListLocator;

    public adminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserManagement(){
        return userManagementLocator;
    }
    public WebElement getJob(){
        return jobLocator;
    }
    public WebElement getOrganizationLocator(){
        return organizationLocator;
    }
    public WebElement getQualification(){
        return qualificationLocator;
    }

    public void clickJobs(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions builder = new Actions(driver);
        Action hover = builder.moveToElement(jobLocator).build();
        hover.perform();
        jobListLocator.click();
        wait.until(ExpectedConditions.urlContains("viewJobTitleList"));
    }

}
