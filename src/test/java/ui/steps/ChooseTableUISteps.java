package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import ui.pages.BookTablePage;
import ui.pages.Page;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChooseTableUISteps {
    private BookTablePage bookTablePage;

    @Before
    public void setUp() {
        Page.initDriver();
        bookTablePage = PageFactory.initElements(Page.getDriver(), BookTablePage.class);
    }

    @After
    public void clean() {
        Page.quitDriver();
    }

    @Given("there are free tables in {} on thursday at 6pm")
    public void there_is_a_free_table_in(String room) {
    }

    @When("Jef reserves a table in {} on thursday at 6pm")
    public void jef_reserves_a_table_in(String room) {
        bookTablePage.open();
        // For dates, choose birthday of team member with role "developer" in 2023. Add 1 day if that is a Monday.
        bookTablePage.fillInDate("2023", "02", "23");
        bookTablePage.fillInHour("18", "00");
        bookTablePage.findTable();
        bookTablePage.selectRoom(room);
        bookTablePage.fillInDetails("Jef", "Jefferson");
        bookTablePage.confirmReservation();
    }

    @Then("Jef should be able to make a reservation")
    public void jef_should_be_able_to_reserve_that_table() {
        assertTrue(bookTablePage.isReservationConfirmed());
        // Clean-up testdata: immediately click on the cancel button that is now on the page.
        bookTablePage.cancelReservation();
    }

    @Given("there are no free tables in {} on thursday at 6pm")
    public void there_are_no_free_tables_in_room(String room) {
        //Only one table in room "Lege kamer".
        //We reserve the table first if is still available, so the room is fully booked.
        bookTablePage.open();
        // For dates, choose birthday of team member with role "developer" in 2023. Add 1 day if that is a Monday.
        bookTablePage.fillInDate("2023", "11", "23");
        bookTablePage.findTable();
        if (bookTablePage.selectRoomDropdownContainsOption(room)) {
            bookTablePage.selectRoom(room);
            bookTablePage.fillInDetails("Jef", "Jefferson");
            bookTablePage.confirmReservation();
        }
    }

    @When("Jef tries to reserve a table in {} on thursday at 6pm")
    public void jef_tries_to_reserve_a_table_on_thursday_6pm(String room) {
        bookTablePage.open();
        // For dates, choose birthday of team member with role "developer" in 2023. Add 1 day if that is a Monday.
        bookTablePage.fillInDate("2023", "11", "23");
        bookTablePage.findTable();
    }

    @Then("the room {} is not available anymore for reservation")
    public void the_room_is_not_available_anymore_for_reservation(String room) {
        assertFalse(bookTablePage.selectRoomDropdownContainsOption(room));
    }

    @Given("Jef has chosen to make a reservation for {int}")
    public void jef_has_chosen_to_make_a_reservation_for(Integer numberOfPersons) {
        bookTablePage.open();
        bookTablePage.addPersons(numberOfPersons);
        bookTablePage.findTable();
    }

    @When("Jef reserves a table for the “Kleine zaal”")
    public void jef_reserves_a_table_for_the_kleine_zaal() {
        bookTablePage.selectRoom("Kleine zaal");
        bookTablePage.fillInDetails("Jef", "Jefferson");
        bookTablePage.confirmReservation();
    }

    @When("Jef tries to reserve a table in the “Kleine zaal”")
    public void jef_tries_to_reserve_a_table_in_the_kleine_zaal() {
    }

    @Then("Jef should only be able to make a reservation in “Middelgrote zaal”, “Lege kamer” or “Grote zaal”")
    public void jef_should_only_be_able_to_make_a_reservation_in_middelgrote_zaal_lege_kamer_or_grote_zaal() {
        assertFalse(bookTablePage.selectRoomDropdownContainsOption("Kleine zaal") && !bookTablePage.selectRoomDropdownContainsOption("Middelgrote zaal") && !bookTablePage.selectRoomDropdownContainsOption("Lege kamer") && !bookTablePage.selectRoomDropdownContainsOption("Grote zaal"));
    }

    @When("Jef reserves a table in the “middle-sized room”")
    public void jef_reserves_a_table_in_the_middle_sized_room() {
        bookTablePage.selectRoom("Middelgrote zaal");
        bookTablePage.fillInDetails("Jef", "Jefferson");
        bookTablePage.confirmReservation();
    }

    @Then("Jef should be able to make a reservation in the middle-sized room")
    public void jef_should_be_able_to_make_a_reservation_in_the_middle_sized_room() {
        assertTrue(bookTablePage.isReservationConfirmed());
        bookTablePage.cancelReservation();
    }

    @When("Jef tries to reserve a table in the “middle-sized room”")
    public void jef_tries_to_reserve_a_table_in_the_middle_sized_room() {
    }

    @Then("Jef should only be able to make a reservation in the “Lege kamer” or “Grote zaal”")
    public void jef_should_only_be_able_to_make_a_reservation_in_the_lege_kamer_or_grote_zaal() {
        assertTrue(bookTablePage.selectRoomDropdownContainsOption("Grote zaal") && bookTablePage.selectRoomDropdownContainsOption("Lege kamer") && !bookTablePage.selectRoomDropdownContainsOption("Middelgrote zaal"));
    }

    @When("Jef reserves a table in the “big room”")
    public void jef_reserves_a_table_in_the_big_room() {
        bookTablePage.selectRoom("Grote zaal");
        bookTablePage.fillInDetails("Jef", "Jefferson");
        bookTablePage.confirmReservation();
    }

    @Then("Jef should be able to make a reservation in the “big room”")
    public void jef_should_be_able_to_make_a_reservation_in_the_big_room() {
        assertTrue(bookTablePage.isReservationConfirmed());
        bookTablePage.cancelReservation();
    }

    @When("Jef chooses the “small room”")
    public void jef_chooses_the_small_room() {
        bookTablePage.open();
        bookTablePage.addPersons(2);
        bookTablePage.findTable();
        bookTablePage.selectRoom("Kleine zaal");
        bookTablePage.fillInDetails("Jef", "Jefferson");
        bookTablePage.confirmReservation();
    }

    @Then("Jef should be able to book a reservation for the “small room”")
    public void jef_should_be_able_to_book_a_reservation_for_the_small_room() {
        assertTrue(bookTablePage.isReservationConfirmed());
        bookTablePage.cancelReservation();
    }
}