package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.PageFactory;
import ui.pages.BookTablePage;
import ui.pages.Page;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import static org.junit.Assert.assertTrue;

public class ChooseDateAndTimeUISteps {
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


    @Given("it is now {int}\\/{int}\\/{int} {int}:{int}")
    public void it_is_now(Integer dag, Integer maand, Integer jaar, Integer uur, Integer minuut) {
    }

    @When("Jef makes a reservation for {}\\/{}\\/{} {int}:{int}")
    public void jef_makes_a_reservation_for(Integer dag, Integer maand, Integer jaar, Integer uur, Integer minuut) {
        LocalDate date2 = LocalDate.of(jaar,maand,dag);
        long days = DAYS.between(date2, LocalDate.now());
        //adds the number of days to the examinationDate parameter, the ‘future date’
        LocalDate date = date2.plusDays(days);
        bookTablePage.open();
        bookTablePage.fillInDate(String.valueOf(date.getYear()), String.valueOf(date.getMonthValue()), String.valueOf(date.getDayOfMonth()));
        bookTablePage.fillInHour(String.valueOf(uur), String.valueOf(minuut));
        bookTablePage.findTable();
        bookTablePage.selectRoom("Grote zaal");
        bookTablePage.fillInDetails("Jef", "Jefferson");
        bookTablePage.confirmReservation();
    }

    @Then("Jef should be able to book a reservation")
    public void jef_should_be_able_to_book_a_reservation() {
        assertTrue(bookTablePage.isReservationConfirmed());
        bookTablePage.cancelReservation();
    }

    @Given("the restaurant is open on Tuesday {int}:{int}")
    public void the_restaurant_is_open_on_tuesday(Integer uur, Integer minuut) {
    }

    @When("Jef makes a reservation for Tuesday {int}:{int}")
    public void jef_makes_a_reservation_for_tuesday(Integer uur, Integer minuut) {
        LocalDate date2 = LocalDate.now();
        LocalDate tuesday = date2.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        bookTablePage.open();
        bookTablePage.fillInDate(String.valueOf(tuesday.getYear()), String.valueOf(tuesday.getMonthValue()), String.valueOf(tuesday.getDayOfMonth()));
        bookTablePage.fillInHour(String.valueOf(uur), String.valueOf(minuut));
        bookTablePage.findTable();
        bookTablePage.selectRoom("Grote zaal");
        bookTablePage.fillInDetails("Jef", "Jefferson");
        bookTablePage.confirmReservation();
    }

    @When("Jef makes a reservation for {} persons")
    public void jef_makes_a_reservation_for_persons(Integer numberOfPersons) {
        bookTablePage.open();
        bookTablePage.addPersons(numberOfPersons);
        bookTablePage.findTable();
        bookTablePage.selectRoom("Grote zaal");
        bookTablePage.fillInDetails("Jef", "Jefferson");
        bookTablePage.confirmReservation();
    }
}