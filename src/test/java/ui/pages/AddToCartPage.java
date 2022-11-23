package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends Page{


    // 4-17 url "?view=takeawayitem&takeaway_item="
    @FindBy(id = "vrtk-item-addbutton")
    private WebElement addItemButton;
}
