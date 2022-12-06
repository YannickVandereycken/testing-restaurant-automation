package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import ui.pages.ChooseRoomePage;
import ui.pages.Page;

import static org.junit.Assert.assertTrue;

public class ChooseRoomUISteps {
    private ChooseRoomePage chooseRoomePage;

    @Before
    public void setUp() {
        Page.initDriver();
        chooseRoomePage = PageFactory.initElements(Page.getDriver(), ChooseRoomePage.class);
    }

    @After
    public void clean() {
        Page.quitDriver();
    }

    @Given("Jef has chosen to make a reservation for {int}")
    public void jef_has_chosen_to_make_a_reservation_for(Integer int1) {
        chooseRoomePage.open();
        chooseRoomePage.fillInDate("2023", "01", "23");
        chooseRoomePage.fillInAantal(int1);
        chooseRoomePage.findTable();
    }

    @When("Jef reserves a table for the “Kleine zaal”")
    public void jef_reserves_a_table_for_the_kleine_zaal() {
        jef_has_chosen_to_make_a_reservation_for(2);
    }

    @When("Jef tries to reserve a table in the “Kleine zaal”")
    public void jef_tries_to_reserve_a_table_in_the_kleine_zaal() {
        jef_has_chosen_to_make_a_reservation_for(4);
    }

    @Then("Jef should only be able to make a reservation in “Middelgrote zaal”, “Lege kamer” or “Grote zaal”")
    public void jef_should_only_be_able_to_make_a_reservation_in_middelgrote_zaal_lege_kamer_or_grote_zaal() {
        assertTrue(chooseRoomePage.selectRoomDropdownContainsOption("Grote zaal") && chooseRoomePage.selectRoomDropdownContainsOption("Lege kamer") && chooseRoomePage.selectRoomDropdownContainsOption("Middelgrote zaal"));
    }

    @When("Jef reserves a table in the “middle-sized room”")
    public void jef_reserves_a_table_in_the_middle_sized_room() {
        jef_has_chosen_to_make_a_reservation_for(4);
        chooseRoomePage.selectRoom("Middelgrote zaal");
    }

    @Then("Jef should be able to make a reservation in the middle-sized room")
    public void jef_should_be_able_to_make_a_reservation_in_the_middle_sized_room() {
        assertTrue(chooseRoomePage.selectRoomDropdownContainsOption("Middelgrote zaal"));
    }

    @When("Jef tries to reserve a table in the “middle-sized room”")
    public void jef_tries_to_reserve_a_table_in_the_middle_sized_room() {

    }

    @Then("Jef should only be able to make a reservation in the “Lege kamer” or “Grote zaal”")
    public void jef_should_only_be_able_to_make_a_reservation_in_the_lege_kamer_or_grote_zaal() {
        assertTrue(chooseRoomePage.selectRoomDropdownContainsOption("Grote zaal") && chooseRoomePage.selectRoomDropdownContainsOption("Lege kamer") && !chooseRoomePage.selectRoomDropdownContainsOption("Middelgrote zaal"));
    }

    @When("Jef reserves a table in the “big room”")
    public void jef_reserves_a_table_in_the_big_room() {
        jef_has_chosen_to_make_a_reservation_for(7);
        chooseRoomePage.selectRoom("Grote zaal");
    }

    @Then("Jef should be able to make a reservation in the “big room”")
    public void jef_should_be_able_to_make_a_reservation_in_the_big_room() {
        assertTrue(chooseRoomePage.selectRoomDropdownContainsOption("Grote zaal"));
    }

    @When("Jef chooses the “small room”")
    public void jef_chooses_the_small_room() {
        jef_has_chosen_to_make_a_reservation_for(2);
        chooseRoomePage.selectRoom("Kleine zaal");
    }

    @Then("Jef should be able to book a reservation for the “small room”")
    public void jef_should_be_able_to_book_a_reservation_for_the_small_room() {
        assertTrue(chooseRoomePage.selectRoomDropdownContainsOption("Kleine zaal"));
    }
}
