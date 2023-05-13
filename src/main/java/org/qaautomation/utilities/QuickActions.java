package org.qaautomation.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qaautomation.search.SearchPage;

import java.time.Duration;

public class QuickActions extends BasePage {

    public QuickActions(WebDriver driver) {
        super(driver);
    }

    //method to be reused when we need to wait for an element, then click it
    public static void findAndClick(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }


    //method to be reused when we need to wait for an input element, then send keys to it
    public static void sendKeys(By locator, String key){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(key);
    }

    //method to be reused any time a search needs to be completed
    public static void searchFor(String searchTerm){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(SearchPage.searchBar));
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(searchTerm);
        searchBar.submit();
    }

    //method to be reused any time we need to wait for one element before we do something with it
    public static WebElement waitForVis(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //method to be used any time we need to hover over one element and click another e.g. submenu navigation
    public static void hoverClick(By hoverLocator, By clickLocator){
        //create an action object
        Actions action = new Actions(driver);

        //hover over the indicated element
        action.moveToElement(waitForVis(hoverLocator)).perform();

        //click the indicated element
        findAndClick(clickLocator);
    }

    //method to be used any time we need to hover over an element and click it
    public static void hoverClick(By locator){
        //create an action object
        Actions action = new Actions(driver);

        //hover over the indicated element
        action.moveToElement(waitForVis(locator)).perform();

        //click the indicated element
        findAndClick(locator);
    }

    public static void hover(By locator){
        //create an action object
        Actions action = new Actions(driver);

        //hover over the indicated element
        action.moveToElement(waitForVis(locator)).perform();
    }
}
