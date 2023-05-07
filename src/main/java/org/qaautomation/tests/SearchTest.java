package org.qaautomation.tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qaautomation.base.SearchCases;
import org.qaautomation.pages.RegisterPage;
import org.qaautomation.pages.SearchPage;
import org.qaautomation.utilities.BasePage;
import java.time.Duration;
import java.util.List;

public class SearchTest extends BasePage {

    public SearchTest(WebDriver driver) {
        super(driver);
    }

    public static void runBasicSearchTestCases(){

        //for each entry in the Search Case array, look up the search term and run the nested loop
        for (int i = 0; i < SearchCases.basicSearch.length; i++) {

            //search for the term
            searchFor(SearchCases.basicSearch[i][0]);


            //if no errors expected for the case, check result names to make sure they contain search key
            if(SearchCases.basicSearch[i][1] == null){


                //wait for all product names to load
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(SearchPage.productResultName));


                //record all product name WebElements from the first page
                List<WebElement> searchResults = driver.findElements(SearchPage.productResultName);


                //for each product in the list, make sure product name contains search key
                for (WebElement productName : searchResults) {


                    String actualName = productName.getText().toLowerCase();
                    //System.out.println(actualName);
                    String expectedSubstring = SearchCases.basicSearch[i][0].toLowerCase();
                    Assert.assertTrue(actualName.contains(expectedSubstring));
                }
            } else {
              //if errors are expected, check if the actual error matches
                Assert.assertEquals(SearchCases.basicSearch[i][1],readResultError());
                System.out.println(readResultError());
            }

        } //test case array loop
    } //basicSearchTermCheck()

    //method to be reused any time a search needs to be completed
    public static void searchFor(String searchTerm){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(SearchPage.searchBar));
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(searchTerm);
        searchBar.submit();
    }

    public static String readResultError(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement resultError = wait.until(ExpectedConditions.visibilityOfElementLocated(SearchPage.resultErrorMessage));

        return resultError.getText();

    }
}

