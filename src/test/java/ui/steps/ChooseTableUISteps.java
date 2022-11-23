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
        bookTablePage.fillInDate("2023", "11", "23");
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


}