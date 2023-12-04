package testRun;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = ".//Features/Amazon.feature",
		glue = "stepsDefinations",
		plugin= {"pretty","html:target/cucumber/cucumber.html"},
		dryRun = false,
		tags ="@Amazonstore")


public class TestNGRunner extends AbstractTestNGCucumberTests{

}

