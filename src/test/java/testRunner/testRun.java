package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "D://_Team//HepsiBurada//Features",
        glue = "stepDefinitions",
        dryRun = true,
        monochrome = true,
        plugin = {"html:target/cucumber-html-report.html","pretty", "html:test-output", "json:target/cucumber.json","json:target/cucumber-reports/cucumber.xml"}
)

public class testRun {


}





