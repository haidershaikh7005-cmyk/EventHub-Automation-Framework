package testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Rerun failed tests from rerun.txt file
        //MyLoginrunner→Login.feature → LoginSteps → LoginPage → DriverFactory →Hooks → Playwright → browse
        features = {"src/test/resources/features/MyLogin.feature"},
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"  // Save Failed test scenarios in rerun.txt file
        }
)

public class MyLoginRunner  {
}
