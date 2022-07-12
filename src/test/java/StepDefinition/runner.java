package StepDefinition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



    @CucumberOptions(
            features = {"src/test/resources/features"},
            glue={"StepDefinition"},
            plugin={"pretty","html:target/HtmlReport"}
    )
    public class runner extends AbstractTestNGCucumberTests {

    }

