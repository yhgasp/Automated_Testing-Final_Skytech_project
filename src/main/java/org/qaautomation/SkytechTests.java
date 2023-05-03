package org.qaautomation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SkytechTests extends BasePage {

    public SkytechTests(){super(driver);}

    @BeforeClass
    public static void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        BasePage.driver = new ChromeDriver(options);
    }

    @Test
    public void whatever(){
        enterHomePage(BasePage.driver);
        RegisterAndLoginV2.runRegistrationTestCases();
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

}
