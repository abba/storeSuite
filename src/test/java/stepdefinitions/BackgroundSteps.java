package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import core.HomePage;

/**
 * Created by zsuleiman on 22/06/2020.
 */
public class BackgroundSteps {


    HomePage homepage = new HomePage();

    @Given("^User navigates to MyStore$")
    public void userNavigatesToMyStore() throws Throwable {

        homepage.gotoHomePage();

    }

    @Then("^User should be on MyStore$")
    public void userShouldBeOnMyStore() throws Throwable {
        Assert.assertThat(homepage.pageTitle(), CoreMatchers.containsString("My Store"));

    }
}
