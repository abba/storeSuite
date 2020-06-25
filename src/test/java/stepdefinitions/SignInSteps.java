package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import core.SignInPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by zsuleiman on 22/06/2020.
 */
public class SignInSteps {

    SignInPage signInPage = new SignInPage();


    @Given("^User is on SignIn Page$")
    public void userIsOnLoginPage() {
        signInPage.goToSignInPage();

    }

    @Given("^User Signin using \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void userSigninUsingAndPassword(String email, String password) throws Throwable {
        signInPage.setEmailAddress(email).setPassword(password).signIn();

    }


    @Then("^User should be notified Message \"([^\"]*)\"$")
    public void UserShouldBeNotifiedMessage(String message) throws Throwable {

        assertThat(signInPage.errorMessage(), containsString(message));

    }

    @Then("^User should be signed in successfully$")
    public void signInSuccessfully() {

        assertThat(signInPage.signedIn(), is(true));
    }


}
