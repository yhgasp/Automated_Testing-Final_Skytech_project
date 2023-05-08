package org.qaautomation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.qaautomation.login.LoginMethods;
import org.qaautomation.registration.RegisterTest;
import org.qaautomation.search.SearchTest;
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
    public void searchInputTesting(){
        SearchTest.runSearchInputCases();
    }

    @Test
    public void searchResultTesting(){
        SearchTest.runSearchResultTestCases();
    }
    @Test
    public void registrationTesting(){
        RegisterTest.runRegistrationTestCases();
    }

    @Test
    public void loginTesting(){
        LoginMethods.runLoginTestCases();
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

}
