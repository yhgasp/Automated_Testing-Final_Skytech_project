package org.qaautomation.search;

import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.WebDriver;
import org.qaautomation.utilities.BasePage;
import org.qaautomation.utilities.QuickActions;

public class SearchInputTest extends BasePage {

    public SearchInputTest(WebDriver driver) {
        super(driver);
    }

    public static void runSearchInputCases(){
        for (String searchTerm : SearchCases.casesInput){

            //search
            QuickActions.searchFor(searchTerm);

            //check the term that the page shows
            String displayedTerm = QuickActions.waitForVis(SearchPage.searchBar).getAttribute("value");

            try{
                Assert.assertEquals(searchTerm,displayedTerm);
            } catch (ComparisonFailure e){
                System.out.println("Search term displayed by the website does not match initial input.\n" +
                        "Full exception message: \n" + e);
            }
        }
    }

}
