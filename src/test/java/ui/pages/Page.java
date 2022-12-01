package ui.pages;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class Page {
    private static WebDriver driver;
    String path = "https://davidvandenbroeck.com/";

    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
        if (driver == null) {
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--lang=en-GB");
//            driver = new ChromeDriver(chromeOptions);
            driver = new ChromeDriver();
        }
    }

    public static void quitDriver() {
//        driver.quit();
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public String getPath() {
        return path;
    }

}