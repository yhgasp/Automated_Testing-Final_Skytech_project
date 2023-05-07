package org.qaautomation.base;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.qaautomation.tests.LoginTest;
import org.qaautomation.tests.RegisterTest;
import org.qaautomation.utilities.BasePage;

import java.sql.SQLException;

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
    public void loginTesting(){
        LoginTest.runLoginTestCases();
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

}
