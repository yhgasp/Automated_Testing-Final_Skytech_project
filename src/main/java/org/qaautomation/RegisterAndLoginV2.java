package org.qaautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAndLoginV2 extends BasePage {

    //Element locators - Registering
    private static final By registerButton = By.className("link-register");
    private static final By regFirstNameField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[1]/div[2]/input");
    private static final By regLastNameField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[2]/div[2]/input");
    private static final By regPhoneField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[3]/div[2]/input");
    private static final By regEmailField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[4]/div[2]/input");
    private static final By regPasswordField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[5]/div[2]/input");
    private static final By regRepeatPasswordField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[6]/div[2]/input");
    private static final By regTermAcknowledgement = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[7]/div[1]/input");
    private static final By regGdprConsent = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[8]/div[1]/input");
    private static final By regMarketingConsent = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[9]/div/input");
    private static final By submitRegistration = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/table/tbody/tr/td[2]/div/div/input");

    //Element locators - login
    private static final By loginButton = By.className("link-login");
    private static final By loginUsernameField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[1]/div[1]/div[1]/div[2]/input");
    private static final By loginPasswordField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[1]/div[1]/div[2]/div[2]/input");

    //Registration test case array
    private static final String[][] regTestCases = {
            //valid credentials
            {"Vardenis", "Pavardenis", "+37060000000", "email@mail.com", "Test123!", "Test123!", "true", "true", "false"},
            //repeat password mismatch
            {"Vardenis", "Pavardenis", "+37060000000", "email@mail.com", "Test123!", "Test123", "true", "true", "false"},
            //password does not meet security requirements
            {"Vardenis", "Pavardenis", "+37060000000", "email@mail.com", "Test123!", "Test", "true", "true", "false"},
    };

    //class constructor that inherits driver properties from Base page
    public RegisterAndLoginV2(WebDriver driver) {
        super(driver);
    }


    public static void RegistrationAttempt(String firstName,
                                           String lastName,
                                           String phone,
                                           String email,
                                           String password,
                                           String repeatPassword,
                                           boolean terms,
                                           boolean gdpr,
                                           boolean marketing) {

        //fill out all fields required for registration based on parameters provided
        driver.findElement(registerButton).click();
        driver.findElement(regFirstNameField).sendKeys(firstName);

        driver.findElement(regPhoneField).sendKeys(phone);

        driver.findElement(regPasswordField).sendKeys(password);
        driver.findElement(regRepeatPasswordField).sendKeys(repeatPassword);
        if (gdpr) {
            driver.findElement(regTermAcknowledgement).click();
        }
        if (terms) {
            driver.findElement(regGdprConsent).click();
        }
        if (marketing) {
            driver.findElement(regMarketingConsent).click();
        }
        driver.findElement(submitRegistration).click();
    }

    public static void runRegistrationTestCases() {

        //for each entry in registration test case array, the registration method is called with appropriate parameters
        for (int i = 0; i < regTestCases.length; i++) {


            driver.findElement(registerButton).click(); //start or reset registration attempt


            //enter basic registration info
            driver.findElement(regFirstNameField).sendKeys(regTestCases[i][0]); //send first name
            driver.findElement(regLastNameField).sendKeys(regTestCases[i][1]); //last name
            driver.findElement(regPhoneField).sendKeys(regTestCases[i][2]); //phone
            driver.findElement(regEmailField).sendKeys(regTestCases[i][3]); //email
            driver.findElement(regPasswordField).sendKeys(regTestCases[i][4]); //password
            driver.findElement(regRepeatPasswordField).sendKeys(regTestCases[i][5]); //repeat password

            //if terms parameter == true, acknowlege terms and conditions
            if (Boolean.parseBoolean(regTestCases[i][6])) {
                driver.findElement(regTermAcknowledgement).click();
            }


            //if gdpr == true, consent to personal data use
            if (Boolean.parseBoolean(regTestCases[i][7])) {
                driver.findElement(regGdprConsent).click();
            }


            //if marketing == true, consent to marketing emails
            if (Boolean.parseBoolean(regTestCases[i][8])) {
                driver.findElement(regMarketingConsent).click();
            }

            //submit all info
            driver.findElement(submitRegistration).click();
        }

    }
} //class
