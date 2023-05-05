package org.qaautomation.base;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.qaautomation.utilities.BasePage;
import org.qaautomation.utilities.DatabaseMethods;

import java.sql.SQLException;

public class SkytechTests extends BasePage {

    public SkytechTests(){super(driver);}

    @BeforeClass
    public static void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        BasePage.driver = new ChromeDriver(options);
        DatabaseMethods.createTable();
    }

    @Test
    public void whatever() throws SQLException {
        DatabaseMethods.writeDb();
        //enterHomePage(BasePage.driver);
        //RegisterAndLoginV2.runRegistrationTestCases();
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

}
