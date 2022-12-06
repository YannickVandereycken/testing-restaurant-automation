package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ui.pages.BookTablePage;
import ui.pages.OrderFoodPage;
import ui.pages.Page;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddToCartUISteps {
    private OrderFoodPage orderFoodPage;

    @Before
    public void setUp() {
        Page.initDriver();
        orderFoodPage = PageFactory.initElements(Page.getDriver(), OrderFoodPage.class);
    }

    @After
    public void clean() {
        //Page.quitDriver();
    }

    @Given("Jef has {int} “Fanta” in his cart")
    public void jef_has_fanta_in_his_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        orderFoodPage.selectFood("Fanta");
        orderFoodPage.addItem(int1);
    }

    @When("Jef adds {int} “Salmon Poke” to his cart")
    public void jef_adds_salmon_poke_to_his_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        orderFoodPage.selectFood("Salmon Poke");
        orderFoodPage.addItem(int1);
    }

    @Then("{int} “Salmon Poke” should be added to his cart")
    public void salmon_poke_should_be_added_to_his_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        assertTrue(orderFoodPage.contains("Salmon Poke"));
        orderFoodPage.emptyCart();
    }

    @Then("a message should be given that the cart can’t contain more than {int} products")
    public void a_message_should_be_given_that_the_cart_can_t_contain_more_than_products(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(orderFoodPage.hasError());
    }

    @Given("there are {int} “Fanta” available")
    public void there_are_fanta_available(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("Jef adds {int} “Fanta” to his cart")
    public void jef_adds_fanta_to_his_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        orderFoodPage.selectFood("Fanta");
        orderFoodPage.addItem(int1);
    }

    @Then("{int} “Fanta” should be added to his cart")
    public void fanta_should_be_added_to_his_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(orderFoodPage.amount("x" + int1));
        orderFoodPage.emptyCart();
    }

    @Given("the price of {int} “Fanta” is €{double}")
    public void the_price_of_fanta_is_€(Integer int1, Double double1) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        orderFoodPage.selectFood("Fanta");
        assertEquals(orderFoodPage.calculateItemPrice(), double1/10, 0.00);
    }
    @When("Jef chooses to add {int} “Fanta” to his cart")
    public void jef_chooses_to_add_fanta_to_his_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        orderFoodPage.selectFood("Fanta");
        orderFoodPage.addItem(int1);
    }
    @Then("the total price of €{double} should be given")
    public void the_total_price_of_€_should_be_given(Double double1) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        assertEquals(orderFoodPage.calculateTotalPrice(), double1/10, 0.00);
    }

    @Given("Jef has chosen a “Tuna Poke”")
    public void jef_has_chosen_a_tuna_poke() {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        orderFoodPage.selectFood("Tuna Poke");
    }
    @When("Jef adds the note “without cucumber”")
    public void jef_adds_the_note_without_cucumber() {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.addNote("without cucumber");
    }
    @When("Jef adds {int} “Tuna Poke” to his cart")
    public void jef_adds_tuna_poke_to_his_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.addItem(int1);
    }
    @Then("{int} “Tuna Poke” should be added to his cart")
    public void tuna_poke_should_be_added_to_his_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(orderFoodPage.amount("x"+int1));
    }
    @Then("it should include the note “without cucumber”")
    public void it_should_include_the_note_without_cucumber() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(orderFoodPage.containsNote("without cucumber"));
    }

    @When("Jef adds “Tuna Poke” to his cart")
    public void jef_adds_tuna_poke_to_his_cart() {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.addItem(1);
    }
    @When("he did not add a note")
    public void he_did_not_add_a_note() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("it should not include a note")
    public void it_should_not_include_a_note() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(orderFoodPage.noNote());
    }
}