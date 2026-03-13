package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/CreateSalesForceAccount.feature",
				 glue = "week6.day4",
				 plugin = {"pretty","html:target/cucumber-report.html"},
				 monochrome = true)

public class CucumberRunner extends AbstractTestNGCucumberTests {

}
