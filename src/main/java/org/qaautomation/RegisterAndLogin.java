package org.qaautomation;
import org.openqa.selenium.WebDriver;

public class RegisterAndLogin extends BasePage {


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

        driver.findElement(ElementLocators.regScreenButton).click();
        driver.findElement(ElementLocators.regFirstNameField).sendKeys(firstName);
        driver.findElement(ElementLocators.regLastNameField).sendKeys(lastName);
        driver.findElement(ElementLocators.regPhoneField).sendKeys(phone);
        driver.findElement(ElementLocators.regEmailField).sendKeys(email);
        driver.findElement(ElementLocators.regPasswordField).sendKeys(password);
        driver.findElement(ElementLocators.regRepeatPasswordField).sendKeys(repeatPassword);
        if (gdpr) {
            driver.findElement(ElementLocators.regTermAcknowledgement).click();
        }
        if (terms) {
            driver.findElement(ElementLocators.regGdprConsent).click();
        }
        if (marketing) {
            driver.findElement(ElementLocators.regMarketingConsent).click();
        }
        driver.findElement(ElementLocators.regInfoSubmit).click();
    }

    public static void runRegistrationTestCases() {

        //for each entry in registration test case array, the registration method is called with appropriate parameters
        for (int i = 0; i < TestProperties.regTestCases.length; i++) {

            //calling the method with all appropriate parameters
            RegistrationAttempt(
                    TestProperties.regTestCases[i][0], //first name
                    TestProperties.regTestCases[i][1], //last name
                    TestProperties.regTestCases[i][2], //phone
                    TestProperties.regTestCases[i][3], //email
                    TestProperties.regTestCases[i][4], //password
                    TestProperties.regTestCases[i][5], //repeat password

                    //if terms parameter == true, terms and conditios should be acknowledged
                    Boolean.parseBoolean(TestProperties.regTestCases[i][6]),

                    //if gdpr == true, gdpr checkbox should be ticked
                    Boolean.parseBoolean(TestProperties.regTestCases[i][7]),

                    //if marketing == true, consent to marketing emails
                    Boolean.parseBoolean(TestProperties.regTestCases[i][8]));
        }

    }
} //class
