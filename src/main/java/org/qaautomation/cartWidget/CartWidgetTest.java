package org.qaautomation.cartWidget;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.qaautomation.utilities.BasePage;
import org.qaautomation.utilities.NavigationPage;
import org.qaautomation.utilities.QuickActions;

import java.util.List;

import static org.qaautomation.utilities.ExceptionHandling.AssertContains.AssertContains;
import static org.qaautomation.utilities.ExceptionHandling.AssertEquals.AssertEquals;

public class CartWidgetTest extends BasePage {
    public CartWidgetTest(WebDriver driver) {
        super(driver);
    }

    public static void main(String[] args) {
        //
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        enterHomePage(driver);
        driver.manage().window().maximize();
        //

        runCartWidgetTests();
    }
    public static void runCartWidgetTests() {
        //go to the first subcategory in the main menu
        QuickActions.hoverClick(NavigationPage.mainNavigation, NavigationPage.l3Navigation);

        //add any product from the displayed list to cart
        cartWidgetTest("First product in the list to widget cart", 1);

        cartWidgetChangeQty("Cart Widget Quantity change 1", 20);
        cartWidgetChangeQty("Cart Widget Quantity change 2", -10);

        cartWidgetDeleteProduct("Cart Widget - remove product");

        cartWidgetTest("Tenth product in the list to widget cart", 20);

        cartWidgetChangeQty("Cart Widget Quantity change 3", -10);

        cartWidgetDeleteProduct("Cart Widget - remove product");
    }

    protected static void cartWidgetTest(String testCaseName, int productIndex){
        //get lists
        List<WebElement> productNames = driver.findElements(CartWidgetPage.productTitle);
        List<WebElement> productPrices = driver.findElements(CartWidgetPage.productPrice);
        List<WebElement> productToCartBtns = driver.findElements(CartWidgetPage.productCartBtn);

        //grab the necessary info according to index
        String productName = productNames.get(productIndex).getText();
        float productPrice = Float
                .parseFloat(productPrices.get(productIndex).getText()
                .replace("€",""));

        //add the product to cart
        productToCartBtns.get(productIndex).click();
        //bring the page view back to top in case element selection scrolled the view down
        QuickActions.hover(CartWidgetPage.widgetBtn);

        //check that product name and price displayed in the widget match what we intended to add
        AssertContains(testCaseName,
                "product name",
                getCartWidgetProdName(),
                productName);

        AssertEquals(testCaseName,
                "product price",
                getCartWidgetProdPrice(),
                productPrice);
    }

    //product name displayed within the widget with the last three "..." characters removed
    protected static String getCartWidgetProdName(){
        QuickActions.hover(CartWidgetPage.widgetBtn);
        String rawName = driver.findElement(CartWidgetPage.widgetProdName).getText();

        return rawName.substring(0, rawName.length() - 3);
    }


    //product price displayed within the widget with an unnecessary space and € removed
    protected static float getCartWidgetProdPrice(){
        QuickActions.hover(CartWidgetPage.widgetBtn);
        String rawPrice = driver.findElement(CartWidgetPage.widgetProdPrice).getText();
        String price = rawPrice
            .replace(" ","")
            .replace("€","");

        return Float.parseFloat(price);
    }


    //product quantity displayed within the widget
    protected static int getCartWidgetProdQty(){
        QuickActions.hover(CartWidgetPage.widgetBtn);
        String rawQuantity = driver.findElement(CartWidgetPage.widgetProdQty).getText();
        String quantity = rawQuantity
            .replace("x","");

        return Integer.parseInt(quantity);
    }


    //price sum of all cart items displayed within the widget, returned with an unnecessary space removed
    protected static float getCartWidgetTotal(){
        QuickActions.hover(CartWidgetPage.widgetBtn);
        String rawTotal = driver.findElement(CartWidgetPage.widgetTotal).getText();
        String total = rawTotal
            .replace(" ","")
            .replace("€","");

        return Float.parseFloat(total);
    }


    //cart total displayed as part of the widget title, returned with an unnecessary space removed
    protected static float getCartWidgetTitleTotal(){
        String rawTotal = driver.findElement(CartWidgetPage.widgetDynamicTotal).getText();
        String total = rawTotal
            .replace(" ","")
            .replace("€","");

        return Float.parseFloat(total);
    }


    //quantity of items in the cart displayed as part of the widget title
    protected static int getCartWidgetTitleQty(){
        String quantity = driver.findElement(CartWidgetPage.widgetDynamicQty).getText();

        return Integer.parseInt(quantity);

    }

    protected static void cartWidgetChangeQty(String testCaseName, int changeBy){
        int startingQuantity = getCartWidgetProdQty();
        int expectedCartQuantity;

        //if product quantity is out of designated limits, default to valid quantity
        if (startingQuantity + changeBy < 1){
            expectedCartQuantity = 1;
        } else expectedCartQuantity = Math.min(startingQuantity + changeBy, 200);

        //define expected total cart price
        float expectedCartTotal = expectedCartQuantity * getCartWidgetProdPrice();


        //depending on whether a number is positive or negative, click the appropriate button
        if (changeBy == 0){
            System.out.println("Redundant method call to change widget product quantity!");
        } else if (changeBy > 0){
            for (int i = 0; i < changeBy; i++) {
                QuickActions.hoverClick(CartWidgetPage.widgetIncreaseQty);
            }
        } else {
            for (int i = 0; i > changeBy; i--) {
                QuickActions.hoverClick(CartWidgetPage.widgetReduceQty);
            }
        }

        //checking that all quantities and totals match the expected values
        AssertEquals(testCaseName,"cart widget product quantity",expectedCartQuantity, getCartWidgetProdQty());
        AssertEquals(testCaseName,"widget title product quantity", expectedCartQuantity, getCartWidgetTitleQty());
        AssertEquals(testCaseName, "cart widget total", expectedCartTotal, getCartWidgetTotal());
        AssertEquals(testCaseName, "widget title total", expectedCartTotal, getCartWidgetTitleTotal());
    }

    protected static void cartWidgetDeleteProduct(String testCaseName){
        //click the delete button on the first list product
        QuickActions.hoverClick(CartWidgetPage.widgetDelete);

        try {
            //wait for message to update
            Thread.sleep(1000);


            //get widget title text
            String actualWidgetMsg = QuickActions.waitForVis(CartWidgetPage.widgetBtn).getText();


            //check if it matches expected text (saying cart is empty)
            AssertEquals(testCaseName,"cart widget title", CartWidgetPage.widgetEmptyMsg, actualWidgetMsg);
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
