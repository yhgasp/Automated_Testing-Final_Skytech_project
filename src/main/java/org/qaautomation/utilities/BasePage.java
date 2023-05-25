package org.qaautomation.utilities;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver;

    //when the driver opens a window, it will always maximize it
    public BasePage(WebDriver driver){
        System.setProperty("webdriver.chrome.driver","F:/Desktop/chromedriver/chromedriver.exe");
        driver.manage().window().maximize();
    }


    //method that enters the main home page of Skytech
    public static void enterHomePage(WebDriver driver){
        driver.get("https:www.skytech.lt");
    }
}

