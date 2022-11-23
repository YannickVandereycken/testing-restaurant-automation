package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class OrderFoodPage extends Page{

    @FindAll(@FindBy(className = "vrtkcartquantitysp"))
    private ArrayList<WebElement> content;

    @FindBy(className = "vrtkcartpricemodule")
    private WebElement totalPrice;

    @FindBy(className = "vrtkcartorderbutton")
    private WebElement orderNowButton;

    public void open() {
        getDriver().get(getPath() + "/order-food-online");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(orderNowButton));
    }

    public void selectFood(String food){
        String url;
        switch (food){
            case "Salmon Poke": url="?view=takeawayitem&takeaway_item=4";
            break;
            case "Tuna Poke": url="?view=takeawayitem&takeaway_item=5";
            break;
            case "Vegan Poke": url="?view=takeawayitem&takeaway_item=6";
            break;
            case "Chicken Poke": url="?view=takeawayitem&takeaway_item=7";
            break;
            case "Mango Poke": url="?view=takeawayitem&takeaway_item=8";
            break;
            case "Salmon Spicy Poke": url="?view=takeawayitem&takeaway_item=9";
            break;
            case "Chocolate": url="?view=takeawayitem&takeaway_item=10";
            break;
            case "Mango": url="?view=takeawayitem&takeaway_item=11";
            break;
            case "Coconut": url="?view=takeawayitem&takeaway_item=12";
            break;
            case "Still Water": url="?view=takeawayitem&takeaway_item=13";
            break;
            case "Sparkling Water": url="?view=takeawayitem&takeaway_item=14";
            break;
            case "Coca Cola": url="?view=takeawayitem&takeaway_item=15";
            break;
            case "Fanta": url="?view=takeawayitem&takeaway_item=16";
            break;
            case "Sprite": url="?view=takeawayitem&takeaway_item=17";
            default: url="";
            break;
        }
        getDriver().get(getPath()+"order-food-online/"+url);
    }
}
