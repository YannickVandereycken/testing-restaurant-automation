package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmTablePage extends Page {

    //    https://davidvandenbroeck.com/book-a-table/?view=confirmres

    @FindBy(className = "vrsearchsubmit")
    private WebElement findATableButton;

    @FindBy(className = "vrresultbookbuttonfind")
    private WebElement selectRoomButton;

    @FindBy(className = "vrresultbookbuttoncontinue")
    private WebElement continueButton;

    @FindBy(id = "vrcalendar")
    public WebElement dateField;

    @FindBy(id = "vrcfinput1")
    private WebElement firstNameField;

    @FindBy(id = "vrcfinput2")
    private WebElement lastNameField;

    @FindBy(id = "vrcfinput3")
    private WebElement emailField;

    @FindBy(id = "vrcfinput4")
    private WebElement telephoneField;

    @FindBy(id = "vrcfinput13")
    private WebElement acceptTermsCheckbox;

    @FindBy(id = "vrconfcontinuebutton")
    private WebElement confirmButton;

    @FindBy(className = "vrreservationstatusconfirmed")
    private WebElement confirmationText;

    @FindBy(className = "vrordercancbutton")
    private WebElement cancelReservationButton;

    @FindBy(id = "vrroomselect")
    private WebElement selectRoomDropdown;

    @FindBy(xpath = "//*[@id=\"vik-confirm-dialog\"]/div[2]/a[1]")
    private WebElement okLink;


    @FindBy(id = "vrordererrordiv")
    private WebElement orderError;

    public void open() {
        getDriver().get(getPath() + "book-a-table/");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        findTable();
        continueButton.click();
        wait.until(ExpectedConditions.visibilityOf(confirmButton));
    }

    public void findTable() {
        findATableButton.click();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(selectRoomButton));
        selectRoomButton.click();

        wait.until(ExpectedConditions.visibilityOf(continueButton));
    }

    public void fillInDetails(String firstName, String lastName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        acceptTermsCheckbox.click();
    }

    public void fillInFirstAndLastName(String firstName, String lastName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void acceptTerms() {
        acceptTermsCheckbox.click();
    }

    public void confirmReservation() {
        confirmButton.click();
    }

    public boolean isReservationConfirmed() {
        return confirmationText.isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return orderError.isDisplayed();
    }

    public void cancelReservation() {
        cancelReservationButton.click();
        okLink.click();
    }

    public boolean selectRoomDropdownContainsOption(String option) {
        return !selectRoomDropdown.findElements(By.xpath(String.format("//option[contains(text(),\"%s\")]", option))).isEmpty();
    }
}