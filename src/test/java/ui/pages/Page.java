package ui.pages;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Page {
    private static WebDriver driver;
    String path = "https://davidvandenbroeck.com/";

    public static void initDriver () {
        WebDriverManager.chromedriver().setup();
        if(driver == null) {
            driver = new ChromeDriver();
        }
    }

    public static void quitDriver() {
        driver.quit();
    }
    public static WebDriver getDriver() {
        return driver;
    }

    public String getPath() {
        return path;
    }
}