package org.qaautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage {

    //all elements related to the main website search function
        public static final By searchBar = By.className("search-field");

        public static final By productResultName = By.className("name");
        public static final By resultErrorMessage = By.className("productListing-info");

}
