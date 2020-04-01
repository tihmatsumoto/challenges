package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.sendEmailPage;
import org.junit.Assert;

public class sendEmailSteps {

    private sendEmailPage sendEmail = new sendEmailPage();

    @Given("^A User sends an \"hello\" message$")
    sendEmail.sendEmail();

    @When("^The message is converted by the Adapter$")
    sendEmail.sendEmailToServer();

    @Then("^The Message server should contain the \"hello\" message in the queue$")
    Assert.assertEquals(expectedEmail, sendEmail.getEmailInServer());

}

