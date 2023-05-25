package org.qaautomation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.qaautomation.cart.CartWidgetTest;
import org.qaautomation.login.LoginMethods;
import org.qaautomation.registration.RegisterTest;
import org.qaautomation.search.SearchInputTest;
import org.qaautomation.search.SearchResultTest;
import org.qaautomation.search.SearchViewTest;
import org.qaautomation.utilities.BasePage;

public class SkytechTests extends BasePage {

    public SkytechTests(){super(driver);}

    @BeforeClass
    public static void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        BasePage.driver = new ChromeDriver(options);
        enterHomePage(driver);
        //DatabaseMethods.createTable();
    }

    @Test
    public void registrationTesting(){
        RegisterTest.runRegistrationTestCases();
    }

    @Test
    public void runSearchInputCases(){
        SearchInputTest.runSearchInputCases();
    }

    @Test
    public void searchResultTesting(){
        SearchResultTest.runSearchResultTestCases();
    }

    @Test
    public void loginTesting(){
        LoginMethods.runLoginTestCases();
    }

    @Test
    public void cartWidgetTesting(){
        CartWidgetTest.runCartWidgetTests();
    }

    @Test
    public void searchResultViewTesting(){
        SearchViewTest.runViewTests();
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

}
