package org.qaautomation.cartWidget;

import org.openqa.selenium.By;

public class CartWidgetPage {


    //subcategory product elements for cart testing
    static final By productTitle = By.className("name");
    static final By productPrice = By.xpath("//strong[contains(text(),'€')]");
    static final By productCartBtn = By.className("product-list-button");


    //cart widget elements - title
    static final String widgetEmptyMsg = "Krepšelis yra tuščias";
    static final By widgetBtn = By.xpath("//span[@class='text']");
    static final By widgetDynamicQty = By.xpath(
            "//*[@id=\"kcenter\"]");
    static final By widgetDynamicTotal = By.xpath(
            "//*[@id=\"ktotal-top\"]");


    //cart widget elements - buttons
    static final By widgetIncreaseQty = By.className("arrow-up");
    static final By widgetReduceQty = By.className("arrow-down");
    static final By widgetDelete = By.className("remove-icon");
    static final By cartWidgetCheckout = By.xpath(
            "//*[@id=\"krepselis-popup-bottom\"]/div/table/tbody/tr[2]/td/div/div/div[2]/input");


    //cart widget elements - info
    static final By widgetProdName = By.xpath(
            "//body[1]/div[6]/div[1]/div[3]/div[3]/form[1]/div[1]/div[1]/div/table[2]/tbody[1]/tr[2]/td[2]");
    static final By widgetProdQty = By.xpath(
            "(//td[@class='kiekis'])");
    static final By widgetProdPrice = By.xpath(
            "(//td[@class='kaina'])");
    static final By widgetTotal = By.xpath(
            "//*[@id=\"ktotal-bottom\"]");

}
