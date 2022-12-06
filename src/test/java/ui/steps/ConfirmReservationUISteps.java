package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import ui.pages.BookTablePage;
import ui.pages.ConfirmTablePage;
import ui.pages.Page;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConfirmReservationUISteps {
    private ConfirmTablePage confirmTablePage;

    @Before
    public void setUp() {
        Page.initDriver();
        confirmTablePage = PageFactory.initElements(Page.getDriver(), ConfirmTablePage.class);
    }

    @After
    public void clean() {
        Page.quitDriver();
    }

    @Given("Jef has accepted the terms and conditions")
    public void jef_has_accepted_the_terms_and_conditions() {
        confirmTablePage.open();
        confirmTablePage.fillInFirstAndLastName("Jef", "Jefferson");
        confirmTablePage.acceptTerms();
    }

    @When("Jef makes a reservation")
    public void jef_makes_a_reservation() {
        confirmTablePage.confirmReservation();
    }

    @Then("the reservation should be made")
    public void the_reservation_should_be_made() {
        assertTrue(confirmTablePage.isReservationConfirmed());
        confirmTablePage.cancelReservation();
    }

    @Given("Jef has not accepted the terms and conditions")
    public void jef_has_not_accepted_the_terms_and_conditions() {
        confirmTablePage.open();
        confirmTablePage.fillInFirstAndLastName("Jef", "Jefferson");
    }

    @Then("a message should be given that the terms and condition need to be accepted before making a reservation")
    public void a_message_should_be_given_that_the_terms_and_condition_need_to_be_accepted_before_making_a_reservation() {
        assertTrue(confirmTablePage.isErrorDisplayed());
    }

    @Given("Jef has provided “Jef” as his first name")
    public void jef_has_provided_jef_as_his_first_name() {
        confirmTablePage.open();
        confirmTablePage.fillInFirstAndLastName("Jef", "Jefferson");
        confirmTablePage.acceptTerms();
    }

    @Given("Jef has not provided a first name")
    public void jef_has_not_provided_a_first_name() {
        confirmTablePage.open();
        confirmTablePage.fillInFirstAndLastName("", "Jefferson");
        confirmTablePage.acceptTerms();
    }

    @Then("a message should be given that the first name needs to be provided before making a reservation")
    public void a_message_should_be_given_that_the_first_name_needs_to_be_provided_before_making_a_reservation() {
        assertTrue(confirmTablePage.isErrorDisplayed());
    }

    @Given("Jef has provided “Peeters” as his last name")
    public void jef_has_provided_peeters_as_his_last_name() {
        confirmTablePage.open();
        confirmTablePage.fillInFirstAndLastName("Jef", "Peeters");
        confirmTablePage.acceptTerms();
    }

    @Given("Jef has not provided a last name")
    public void jef_has_not_provided_a_last_name() {
        confirmTablePage.open();
        confirmTablePage.fillInFirstAndLastName("Jef", "");
        confirmTablePage.acceptTerms();
    }

    @Then("a message should be given that the last name needs to be provided before making a reservation")
    public void a_message_should_be_given_that_the_last_name_needs_to_be_provided_before_making_a_reservation() {
        assertTrue(confirmTablePage.isErrorDisplayed());
    }
}