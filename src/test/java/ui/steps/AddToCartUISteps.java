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
        Page.quitDriver();
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
}