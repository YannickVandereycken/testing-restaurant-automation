package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import ui.pages.BookTablePage;
import ui.pages.OrderFoodPage;
import ui.pages.Page;

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
        throw new io.cucumber.java.PendingException();
    }
    @When("Jef adds {int} “Salmon Poke” to his cart")
    public void jef_adds_salmon_poke_to_his_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("{int} “Salmon Poke” should be added to his cart")
    public void salmon_poke_should_be_added_to_his_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
