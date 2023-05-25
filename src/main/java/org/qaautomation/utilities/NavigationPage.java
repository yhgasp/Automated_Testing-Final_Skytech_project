package org.qaautomation.utilities;

import org.openqa.selenium.By;

public class NavigationPage {

    //all elements related to the main website search function
    public static final By searchBar = By.className("search-field");
    public static final By productResultName = By.className("name");
    public static final By resultErrorMessage = By.className("productListing-info");


    //element locators for top navigation menu
    public static final By mainNavigation = By.className("main-nav");
    public static final By l2Navigation = By.className("level2w");
    public static final By l3Navigation = By.className("level3");


    //search result navigation - view toggling
    public static final By simpleListViewToggle = By.xpath(
            "//div[@id='listing-filter-panel-vaizdavimas-sarasas']");
    public static final By imageListViewToggle = By.xpath(
            "//div[@id='listing-filter-panel-vaizdavimas-sarasasfoto']");
    public static final By gridViewToggle = By.xpath(
            "//div[@id='listing-filter-panel-vaizdavimas-kvadratais']");


    //search result navigation - elements used to check which view is toggled


        //simple list has a unique "Modelis" column header
    public static final By simpleViewIndicator = By.xpath(
            "(//td)[@class='model ']");


        //image view has a unique image header class
    public static final By imageViewIndicator = By.xpath(
            "(//td[contains(text(),'Paveikslėlis')])[1]");

        //grid view has a unique grid class
    public static final By gridViewIndicator = By.className("product-listing-grid-item");
}
