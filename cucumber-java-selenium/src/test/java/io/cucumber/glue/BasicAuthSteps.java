package io.cucumber.glue;

import io.cucumber.core.*;
import io.cucumber.java.en.*;
import io.cucumber.pages.BasicAuth;
import org.openqa.selenium.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicAuthSteps extends Context {

    public BasicAuthSteps(Manager manager) {
        super(manager);
    }

    @When("^the 'Basic Auth' example is opened")
    public void the_example_is_opened() {
        BasicAuth basicAuthPage = new BasicAuth(getDriver());
        basicAuthPage.visitURL("https://the-internet.herokuapp.com/basic_auth");
    }
    @And("valid credentials are supplied")
    public void valid_credentials_are_supplied() {
        HasAuthentication authentication = (HasAuthentication) getDriver();
        authentication.register(UsernameAndPassword.of("admin", "admin"));

        getDriver().get("https://the-internet.herokuapp.com/basic_auth");
    }
    @Then("Congratulations should be displayed")
    public void congratulations_should_be_displayed() {
        BasicAuth basicAuthPage = new BasicAuth(getDriver());
        String successMessage = basicAuthPage.displaySuccessfulMessage();

        assertEquals("Congratulations! You must have the proper credentials.", successMessage, "ERROR: Scenario 2");
    }
}
