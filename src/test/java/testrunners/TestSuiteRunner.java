package testrunners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by zsuleiman on 22/06/2020.
 */


@RunWith(Cucumber.class)
@CucumberOptions(
        features="./src/main/resources/storeFeatures/",
        glue={"core","testrunners","hooks","stepdefinitions"},
        plugin={ "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "junit:target/cucumber-results.xml"},
        tags = {"~@ignore"})
public class TestSuiteRunner {


}
