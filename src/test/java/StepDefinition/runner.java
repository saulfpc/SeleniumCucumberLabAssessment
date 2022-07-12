package StepDefinition;

import io.cucumber.testng.CucumberOptions;

public class runner {

    @CucumberOptions(
            features = "src\\test\\resources\\features",
            glue={"MySetdefs"}
    )
    public class testRunner{

    }
}
