package org.qaautomation.search;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qaautomation.utilities.BasePage;
import org.qaautomation.utilities.NavigationPage;
import org.qaautomation.utilities.QuickActions;

import java.time.Duration;
import java.util.List;

public class SearchResultTest extends BasePage {

    public SearchResultTest(WebDriver driver) {
        super(driver);
    }


    public static void runSearchResultTestCases(){

        //for each entry in the Search Case array, look up the search term and run the nested loop
        for (int i = 0; i < SearchCases.casesResults.length; i++) {

            //search for the term
            QuickActions.searchFor(SearchCases.casesResults[i][0]);


            //if no errors expected for the case, check result names to make sure they contain search key
            if(SearchCases.casesResults[i][1] == null){

                //record all product name WebElements from the first page
                List<WebElement> searchResults = driver.findElements(NavigationPage.productResultName);


                //for each product in the list, make sure product name contains search key
                for (WebElement productName : searchResults) {


                    String actualName = productName.getText().toLowerCase();
                    //System.out.println(actualName);
                    String expectedSubstring = SearchCases.casesResults[i][0]
                            .trim()
                            .toLowerCase();

                    try {
                        Assert.assertTrue(actualName.contains(expectedSubstring));
                    } catch (Exception e){
                        System.out.println(
                                "Displayed product name does not contain the provided search term.\n" +
                                "Full exception message: \n" + e);
                    }
                }
            } else {
              //if errors are expected, check if the actual error matches
                try {
                    Assert.assertEquals(SearchCases.casesResults[i][1], readResultError());
                } catch (Exception e){
                    System.out.println(
                            "Actual errors do not match expected errors!\n" +
                            "Full exception message: \n" + e);
                }
            }

        } //test case array loop
    } //basicSearchTermCheck()


    public static String readResultError(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement resultError = wait.until(ExpectedConditions.visibilityOfElementLocated(NavigationPage.resultErrorMessage));

        return resultError.getText();

    }
}

