package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderFoodPage extends Page {

    @FindAll(@FindBy(className = "vrtkcartquantitysp"))
    private List<WebElement> amount;

    @FindAll(@FindBy(className = "vrtkcartenamesp"))
    private List<WebElement> content;

    // 4-17 url "?view=takeawayitem&takeaway_item="
    @FindBy(id = "vrtk-item-addbutton")
    private WebElement addItemButton;

    @FindBy(className = "vrtkcartpricemodule")
    private WebElement totalPrice;

    @FindBy(className = "vrtkcartorderbutton")
    private WebElement orderNowButton;

    @FindBy(className = "vrtkcartemptybutton")
    private WebElement emptyCartButton;

    @FindBy(className = "toast-message-content")
    private WebElement errorMessage;

    @FindBy(id = "vrtk-price-box")
    private WebElement itemPrice;

    @FindBy(css = "textarea")
    private WebElement notesBox;

    @FindBy(name = "notes")
    private WebElement itemNotes;

    @FindBy(id="vrtk-aditem-form")
    private WebElement addForm;

    public void open() {
        getDriver().get(getPath() + "/order-food-online");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(orderNowButton));
    }

    public void selectFood(String food) {
        String url;
        switch (food) {
            case "Salmon Poke":
                url = "?view=takeawayitem&takeaway_item=4";
                break;
            case "Tuna Poke":
                url = "?view=takeawayitem&takeaway_item=5";
                break;
            case "Vegan Poke":
                url = "?view=takeawayitem&takeaway_item=6";
                break;
            case "Chicken Poke":
                url = "?view=takeawayitem&takeaway_item=7";
                break;
            case "Mango Poke":
                url = "?view=takeawayitem&takeaway_item=8";
                break;
            case "Salmon Spicy Poke":
                url = "?view=takeawayitem&takeaway_item=9";
                break;
            case "Chocolate":
                url = "?view=takeawayitem&takeaway_item=10";
                break;
            case "Mango":
                url = "?view=takeawayitem&takeaway_item=11";
                break;
            case "Coconut":
                url = "?view=takeawayitem&takeaway_item=12";
                break;
            case "Still Water":
                url = "?view=takeawayitem&takeaway_item=13";
                break;
            case "Sparkling Water":
                url = "?view=takeawayitem&takeaway_item=14";
                break;
            case "Coca Cola":
                url = "?view=takeawayitem&takeaway_item=15";
                break;
            case "Fanta":
                url = "?view=takeawayitem&takeaway_item=16";
                break;
            case "Sprite":
                url = "?view=takeawayitem&takeaway_item=17";
            default:
                url = "";
                break;
        }
        getDriver().get(getPath() + "order-food-online/" + url);
    }

    public void addItem(int amount) {
        for (int i = 0; i < amount; i++) {
            addItemButton.click();

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addItemButton));
        }
    }

    public List<WebElement> getAmount() {
        return amount;
    }

    public boolean contains(String item) {
        for (WebElement w : content) {
            if (w.getText().equals(item))
                return true;
        }
        return false;
    }

    public void emptyCart() {
        emptyCartButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    public boolean hasError() {
        return errorMessage.isDisplayed();
    }

    public boolean amount(String a) {
        for (WebElement w : amount) {
            if (w.getText().equals(a))
                return true;
        }
        return false;
    }

    public double calculateItemPrice(){
        String priceString = itemPrice.getText();
        String[] newString = priceString.split(" ");
        String[] doubleString = newString[1].split(",");
        double result= Double.parseDouble(String.join(".", doubleString));
        return result;
    }

    public double calculateTotalPrice(){
        String totalString = totalPrice.getText();
        String[] newString = totalString.split(" ");
        String[] doubleString = newString[1].split(",");
        double result = Double.parseDouble(String.join(".", doubleString));
        return result;
    }

    public void addNote(String s){
        notesBox.click();
        notesBox.sendKeys(s);
    }

    public boolean containsNote(String s){
        for(WebElement w : content){
            w.click();
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOf(addForm));
            if(itemNotes.getText().equals(s))
                return true;
            else
                this.open();
        }
        return false;
    }

    public boolean noNote(){
        return itemNotes.getText().isEmpty();
    }

    public void confirmOrder(){
        orderNowButton.click();
    }
}
