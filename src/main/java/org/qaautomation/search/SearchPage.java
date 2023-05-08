package org.qaautomation.search;

import org.openqa.selenium.By;

class SearchPage {

    //all elements related to the main website search function
    protected static final By searchBar = By.className("search-field");
    protected static final By productResultName = By.className("name");
    protected static final By resultErrorMessage = By.className("productListing-info");

}
