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

import static org.junit.Assert.*;

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
    public void jef_has_fanta_in_his_cart(Integer amount) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        orderFoodPage.selectFood("Fanta");
        orderFoodPage.addItem(amount);
    }

    @When("Jef adds {int} “Salmon Poke” to his cart")
    public void jef_adds_salmon_poke_to_his_cart(Integer amount) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        orderFoodPage.selectFood("Salmon Poke");
        orderFoodPage.addItem(amount);
    }

    @Then("{int} “Salmon Poke” should be added to his cart")
    public void salmon_poke_should_be_added_to_his_cart(Integer amount) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        assertTrue(orderFoodPage.contains("Salmon Poke"));
        orderFoodPage.emptyCart();
    }

    @Then("a message should be given that the cart can’t contain more than {int} products")
    public void a_message_should_be_given_that_the_cart_can_t_contain_more_than_products(Integer amount) {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(orderFoodPage.hasError());
    }

    @Given("there are {int} “Fanta” available")
    public void there_are_fanta_available(Integer amount) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("Jef adds {int} “Fanta” to his cart")
    public void jef_adds_fanta_to_his_cart(Integer amount) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        orderFoodPage.selectFood("Fanta");
        orderFoodPage.addItem(amount);
    }

    @Then("{int} “Fanta” should be added to his cart")
    public void fanta_should_be_added_to_his_cart(Integer amount) {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(orderFoodPage.amount("x" + amount));
        orderFoodPage.emptyCart();
    }

    @Given("the price of {int} “Fanta” is €{double}")
    public void the_price_of_fanta_is_€(Integer amount, Double price) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        orderFoodPage.selectFood("Fanta");
        assertEquals(orderFoodPage.calculateItemPrice(), price/10, 0.00);
    }
    @When("Jef chooses to add {int} “Fanta” to his cart")
    public void jef_chooses_to_add_fanta_to_his_cart(Integer amount) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        orderFoodPage.selectFood("Fanta");
        orderFoodPage.addItem(amount);
    }
    @Then("the total price of €{double} should be given")
    public void the_total_price_of_€_should_be_given(Double price) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.open();
        assertEquals(orderFoodPage.calculateTotalPrice(), price/10, 0.00);
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
    public void jef_adds_tuna_poke_to_his_cart(Integer amount) {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.addItem(amount);
    }
    @Then("{int} “Tuna Poke” should be added to his cart")
    public void tuna_poke_should_be_added_to_his_cart(Integer amount) {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(orderFoodPage.amount("x"+amount));
    }
    @Then("it should include the note “without cucumber”")
    public void it_should_include_the_note_without_cucumber() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(orderFoodPage.getCucumberNote("without cucumber"),true);
    }

    @When("Jef adds “Tuna Poke” to his cart")
    public void jef_adds_tuna_poke_to_his_cart() {
        // Write code here that turns the phrase above into concrete actions
        orderFoodPage.addItem(1);
    }
    @When("he did not add a note")
    public void he_did_not_add_a_note() {
    }

    @Then("it should not include a note")
    public void it_should_not_include_a_note() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(orderFoodPage.noNote());
    }
}