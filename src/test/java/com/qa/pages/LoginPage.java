package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    @FindBy(css = "input#txtUsername")
    private WebElement username;

    @FindBy(css ="input#txtPassword")
    private WebElement password;

    @FindBy(id = "btnLogin")
    private WebElement loginBtn;

    @FindBy(xpath = "(//a[@href])[(1)]")
    private WebElement forgetPasswordLink;

    @FindBy(xpath = "(//a[@href])[(2)]")
    private WebElement orangeIncLink;

    @FindBy(xpath = "(//a[@href])[(3)]")
    private WebElement lindeInLink;

    @FindBy(xpath = "(//a[@href])[(4)]")
    private WebElement facebookLink;

    @FindBy(xpath = "(//a[@href])[(5)]")
    private WebElement twitterLink;

    @FindBy(xpath = "(//a[@href])[(6)]")
    private WebElement youtubeLink;

    @FindBy(css = "img[alt$='Facebook']")
    private WebElement facebookLogo;

    @FindBy(css="img[alt^='LinkedIn']")
    private WebElement linkedinLogo;

    @FindBy(css = "img[alt$='twitter']")
    private WebElement twitterLogo;

    @FindBy(css = "img[alt$='youtube']")
    private WebElement youtubeLogo;

    @FindBy(css = "#divLogo>img")
    private WebElement loginLogo;

    @FindBy(css = "g>image")
    private WebElement loginContainerImage;

    @FindBy(id = "spanMessage")
    private WebElement alertLocator;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterUser(String user){
        username.sendKeys(user);
    }

    public void enterPassword(String pass){
        password.sendKeys(pass);
    }
    public void clickLoginButton(){
        loginBtn.click();
    }

    public void validateLoginElement(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginContainerImage));
        Assert.assertTrue(loginLogo.isDisplayed());
        Assert.assertTrue(loginContainerImage.isDisplayed());
        Assert.assertTrue(username.isDisplayed());
    }

    public void wrongCredentialAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(alertLocator));
        Assert.assertTrue(alertLocator.isDisplayed());
        Assert.assertEquals(alertLocator.getText(),"Invalid credentials");
    }

}
