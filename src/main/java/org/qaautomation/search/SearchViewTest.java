package org.qaautomation.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qaautomation.utilities.BasePage;
import org.qaautomation.utilities.NavigationPage;
import org.qaautomation.utilities.QuickActions;

import java.util.List;

import static org.qaautomation.utilities.ExceptionHandling.AssertEquals.assertEquals;

public class SearchViewTest extends BasePage {
    public SearchViewTest(WebDriver driver) {
        super(driver);
    }

    public static void runViewTests(){
        //looks up an indicated keyword to open the search result page
        QuickActions.searchFor(SearchCases.genericValidKeyword);


        //switch to simple list view and check if it shows up as expected
        QuickActions.findAndClick(NavigationPage.simpleListViewToggle);
        checkViews(
                "Search Result View Test 001 - simple list",
                true,
                false,
                false);


        //switch to image list view and check if it shows up as expected
        QuickActions.findAndClick(NavigationPage.imageListViewToggle);
        checkViews(
                "Search Result View Test 002 - image list",
                false,
                true,
                false);


        //switch to grid view and check if it shows up as expected
        QuickActions.findAndClick(NavigationPage.gridViewToggle);
        checkViews("Search Result View Test 003 - grid list",
                false,
                false,
                true);


        //switches back to simple list view
        QuickActions.findAndClick(NavigationPage.simpleListViewToggle);
    }

    private static void checkViews(
            String testCaseName,
            boolean simpleViewExpected,
            boolean imageViewExpected,
            boolean gridViewExpected){

        //look for simple list view indicators
        List<WebElement> simpleViewElements = driver.findElements(NavigationPage.simpleViewIndicator);

        //check if page is in simple list view (unique indicator count > 0)
        assertEquals(
                testCaseName,
                "simple list view active state",
                simpleViewExpected,
                simpleViewElements.size() > 0
                );



        //look for image list view indicators
        List<WebElement> imageViewElements = driver.findElements(NavigationPage.imageViewIndicator);

        //check if page is in image list view (unique indicator count > 0)
        assertEquals(
                testCaseName,
                "image list view active state",
                imageViewExpected,
                imageViewElements.size() > 0
        );


        //look for grid view indicators
        List<WebElement> gridViewElements = driver.findElements(NavigationPage.gridViewIndicator);

        //check if page is in grid view (unique indicator count > 0)
        assertEquals(testCaseName,
                "grid list view active state",
                gridViewExpected,
                gridViewElements.size() > 0
        );

        }

    }
