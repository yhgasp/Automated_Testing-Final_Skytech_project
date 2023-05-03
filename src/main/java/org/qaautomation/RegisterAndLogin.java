package org.qaautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAndLogin extends BasePage {

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

    /*Registration test case array
    first name - last name, phone, email, password, repeat password, terms, gdpr, marketing
    terms, gdpr and marketing strings are converted to booleans in the method that uses array data */

    private static final String[][] regTestCases = {
            //valid credentials
            {"Vardenis", "Pavardenis", "+37060000000", "email@mail.com", "Test123!", "Test123!", "true", "true", "false"},
            //repeat password mismatch
            {"Vardenis", "Pavardenis", "+37060000000", "email@mail.com", "Test123!", "Test123", "true", "true", "false"},
            //password does not meet security requirements
            {"Vardenis", "Pavardenis", "+37060000000", "email@mail.com", "Test123!", "Test", "true", "true", "false"},
    };

    //class constructor that inherits driver properties from Base page
    public RegisterAndLogin(WebDriver driver) {
        super(driver);
    }


    //a method used to fill out all fields required for registration based on provided parameters
    public static void RegistrationAttempt(String firstName,
                                           String lastName,
                                           String phone,
                                           String email,
                                           String password,
                                           String repeatPassword,
                                           boolean terms,
                                           boolean gdpr,
                                           boolean marketing) {

        driver.findElement(registerButton).click();
        driver.findElement(regFirstNameField).sendKeys(firstName);
        driver.findElement(regLastNameField).sendKeys(lastName);
        driver.findElement(regPhoneField).sendKeys(phone);
        driver.findElement(regEmailField).sendKeys(email);
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
            RegistrationAttempt(
                    regTestCases[i][0], //first name
                    regTestCases[i][1], //last name
                    regTestCases[i][2], //phone
                    regTestCases[i][3], //email
                    regTestCases[i][4], //password
                    regTestCases[i][5], //repeat password

                    //if terms parameter == true, terms and conditios should be acknowledged
                    Boolean.parseBoolean(regTestCases[i][6]),

                    //if gdpr == true, gdpr checkbox should be ticked
                    Boolean.parseBoolean(regTestCases[i][7]),

                    //if marketing == true, consent to marketing emails
                    Boolean.parseBoolean(regTestCases[i][8]));
        }

    }
} //class
