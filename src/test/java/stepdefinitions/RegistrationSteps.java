package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;
import core.UserRegistrationPage;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by zsuleiman on 25/06/2020.
 */
public class RegistrationSteps {

    UserRegistrationPage userRegistrationPage = new UserRegistrationPage();

    @Given("^User is on account registration page$")
    public void userIsOnAccountRegistrationPage() throws Throwable {

        userRegistrationPage.gotoUserRegistrationPage();

    }

    @When("^User provides valid details for registration$")
    public void userProvidesValidDetailsForRegistration() throws Throwable {
        userRegistrationPage.setFirstName().setLastName().setPassword()
                .setAddress().setCity().setState()
                .setZipCode().setMobilePhone().register();

    }

    @Then("^User should be successfully registered on my store$")
    public void userShouldBeRegisteredSuccessfully() throws Throwable {
        assertThat(userRegistrationPage.registeredSuccessfully(), CoreMatchers.is(true));
    }


}
