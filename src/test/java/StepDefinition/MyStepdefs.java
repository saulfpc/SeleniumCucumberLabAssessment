package StepDefinition;

import com.qa.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class MyStepdefs {

    WebDriver driver;
    LoginPage loginPage;

    List<List<Integer>> numbers;
    Integer finalResult =1;

    @Given("I open My application")
    public void i_open_my_application() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Then("Validate landing page")
    public void validate_landing_page() {
        System.out.println("Hello");
    }


    @When("I login with the following credentials")
    public void i_login_with_the_following_credentials(String user, String pass) {
        loginPage.enterUser(user);
        loginPage.enterPassword(pass);
        loginPage.clickLoginButton();
    }


    @When("I login with the following credentials <user> <password>")
    public void iLoginWithTheFollowingCredentialsUserPassword(String user, String pass) {
        loginPage.enterUser(user);
        loginPage.enterPassword(pass);
        loginPage.clickLoginButton();
    }

    @When("type username {string}")
    public void type_username(String string) {
        loginPage.enterUser(string);
    }

    @When("type password {string}")
    public void type_password(String string) {
        loginPage.enterPassword(string);
        loginPage.clickLoginButton();
    }

    @Given("a list of numbers")
    public void aListOfNumbers(io.cucumber.datatable.DataTable dataTable) {
        numbers = dataTable.asLists(Integer.class);
    }

    @When("I Multiply them")
    public void iMultiplyThem() {
        for (List<Integer> list: numbers) {
            for(Integer integer:list){
                finalResult = finalResult * integer;
            }
        }
        System.out.println("final result is: " + finalResult);
    }

    @Then("should I get {int}")
    public void shouldIGet(int arg0) {
        int i = finalResult;
        Assert.assertEquals(i , arg0);

    }

    @Given("The user wants to find a specific employee")
    public void theUserWantsToFindASpecificEmployee() {
        directoryMenu directory = new directoryMenu(driver);
        directory.navigateToDirectory();
    }

    @When("I search the user with the name {string}")
    public void iSearchTheUserWithTheName(String arg0) {
        directoryPage directoryPage = new directoryPage(driver);
        directoryPage.inputEmployeeName(arg0);

    }

    @Then("Find the employee with {string}")
    public void findTheEmployeeWith(String arg0) {
        directoryPage directoryPage = new directoryPage(driver);
        directoryPage.assertSearchResult(arg0);
    }

    @Then("Validate that I am not login since the credential were incorrect")
    public void validateThatIAmNotLoginSinceTheCredentialWereIncorrect() {
    }

    @Given("When I click on Admin Link")
    public void whenIClickOnAdminLink() {
        directoryMenu directory = new directoryMenu(driver);
        directory.navigateToAdmin();
    }

    @Then("Click on Job")
    public void clickOnJob() {
        adminPage admin = new adminPage(driver);
        admin.clickJobs();
    }

    @And("validate text – Job Title")
    public void validateTextJobTitle() {
        directoryMenu directory = new directoryMenu(driver);
        Assert.assertEquals(directory.getHeader().getText(),"Job Titles");
    }

    @Given("The user enters the site")
    public void theUserEntersTheSite() {
        loginPage.enterUser("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
    }

    @When("He needs to see the main navigation options")
    public void heNeedsToSeeTheMainNavigationOptions() {
        directoryMenu directory = new directoryMenu(driver);
        directory.validateMainMenu();
    }

    @Then("The navigation are visible")
    public void theNavigationAreVisible() {
        directoryMenu directory = new directoryMenu(driver);
        directory.visibilityNavigation();
    }

    @Given("when I am in OrangeHRP Application")
    public void whenIAmInOrangeHRPApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Then("Login to Application")
    public void loginToApplication() {
        loginPage.enterUser("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
    }

    @Then("I am logged into Orange Application.")
    public void iAmLoggedIntoOrangeApplication() {
        loginPage.enterUser("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
    }

    @When("Dashboard page is available")
    public void dashboardPageIsAvailable() {
        HomePage home = new HomePage(driver);
        home.validateDashboard();
    }

    @And("click on Admin menu")
    public void clickOnAdminMenu() {
        directoryMenu directory = new directoryMenu(driver);
        directory.navigateToAdmin();
    }

    @Given("I want to logout")
    public void iWantToLogout() {
        directoryMenu directory = new directoryMenu(driver);
        directory.validateWelcome();
    }

    @When("I click on logout")
    public void iClickOnLogout() {
        directoryMenu directory = new directoryMenu(driver);
        directory.logout();
    }

    @Then("I am returned to the login Page")
    public void iAmReturnedToTheLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.validateLoginElement();
    }
}
