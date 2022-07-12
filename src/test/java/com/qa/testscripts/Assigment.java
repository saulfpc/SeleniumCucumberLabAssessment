package com.qa.testscripts;

import com.qa.pages.*;
import com.qa.utility.ListenersAssignment;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenersAssignment.class)
public class Assigment extends TestBaseAssigment{

    String url ="https://opensource-demo.orangehrmlive.com/";

    @Test(priority = 1)
    public void printTheTitle(){
        driver.get(url);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }

    @Test(priority = 1)
    public void login(){
        driver.get(url);
        LoginPage login = new LoginPage(driver);
        login.enterUser("Admin");
        login.enterPassword("admin123");
        login.clickLoginButton();
    }
    @Test
    public void validationAdminText(){
        driver.get(url);
        LoginPage login = new LoginPage(driver);
        login.enterUser("Admin");
        login.enterPassword("admin123");
        login.clickLoginButton();
        directoryMenu directory = new directoryMenu(driver);
        directory.navigateToAdmin();
        adminPage admin = new adminPage(driver);
        Assert.assertEquals(admin.getUserManagement().getText(), "User Management");
        Assert.assertEquals(admin.getJob().getText(), "Job");
        Assert.assertEquals(admin.getOrganizationLocator().getText(), "Organization");
        Assert.assertEquals(admin.getQualification().getText(),"Qualifications");
    }

    @Test
    public void navigation(){
        driver.get(url);
        LoginPage login = new LoginPage(driver);
        login.enterUser("Admin");
        login.enterPassword("admin123");
        login.clickLoginButton();
        directoryMenu directory = new directoryMenu(driver);
        directory.navigateToAdmin();
        System.out.println(driver.getTitle());
        directory.navigateToPim();
        System.out.println(driver.getTitle());
        directory.navigateToLeave();
        System.out.println(driver.getTitle());
        directory.navigateToDashboard();
        System.out.println(driver.getTitle());
        directory.navigateToDirectory();
        System.out.println(driver.getTitle());
        directory.navigateToMaintenances();
        System.out.println(driver.getTitle());
    }

    @Test
    public void minimizeExample(){
        driver.manage().window().minimize();
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().maximize();
    }

    @Test
    public void printSectionHeader(){
        driver.get(url);
        LoginPage login = new LoginPage(driver);
        login.enterUser("Admin");
        login.enterPassword("admin123");
        login.clickLoginButton();
        directoryMenu directory = new directoryMenu(driver);
        System.out.println(directory.getHeader().getText());
    }

    @Test(retryAnalyzer = com.qa.utility.RetryAnalyzer.class)
    public void retryTest(){
        Assert.assertEquals(false, true);
    }

    @Test
    public void pimSearch(){
        driver.get(url);
        LoginPage login = new LoginPage(driver);
        login.enterUser("Admin");
        login.enterPassword("admin123");
        login.clickLoginButton();
        directoryMenu directory = new directoryMenu(driver);
        directory.navigateToPim();
        pimPage pim = new pimPage(driver);
        pim.searchForEmployee("Linda Anderson");
        Assert.assertEquals(pim.getResult().getText(),"Linda Jane");
    }

    @Test
    public void highlight(){
        driver.get(url);
        LoginPage login = new LoginPage(driver);
        login.enterUser("Admin");
        login.enterPassword("admin123");
        login.clickLoginButton();
        directoryMenu directory = new directoryMenu(driver);
        directory.highlightElement();
        HomePage homePage = new HomePage(driver);
        homePage.highlightElements();
    }

}
