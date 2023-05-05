package org.qaautomation.tests;

import org.openqa.selenium.WebDriver;
import org.qaautomation.utilities.BasePage;
import org.qaautomation.base.TestCases;
import org.qaautomation.pages.RegisterPage;





public class RegisterTest extends BasePage {


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

            driver.findElement(RegisterPage.regScreenButton).click();
            driver.findElement(RegisterPage.regFirstNameField).sendKeys(firstName);
            driver.findElement(RegisterPage.regLastNameField).sendKeys(lastName);
            driver.findElement(RegisterPage.regPhoneField).sendKeys(phone);
            driver.findElement(RegisterPage.regEmailField).sendKeys(email);
            driver.findElement(RegisterPage.regPasswordField).sendKeys(password);
            driver.findElement(RegisterPage.regRepeatPasswordField).sendKeys(repeatPassword);
            if (gdpr) {
                driver.findElement(RegisterPage.regTermAcknowledgement).click();
            }
            if (terms) {
                driver.findElement(RegisterPage.regGdprConsent).click();
            }
            if (marketing) {
                driver.findElement(RegisterPage.regMarketingConsent).click();
            }
            driver.findElement(RegisterPage.regInfoSubmit).click();
        }

        public static void runRegistrationTestCases() {

            //for each entry in registration test case array, the registration method is called with appropriate parameters
            for (int i = 0; i < TestCases.registration.length; i++) {

                //calling the method with all appropriate parameters
                RegistrationAttempt(
                        TestCases.registration[i][0], //first name
                        TestCases.registration[i][1], //last name
                        TestCases.registration[i][2], //phone
                        TestCases.registration[i][3], //email
                        TestCases.registration[i][4], //password
                        TestCases.registration[i][5], //repeat password

                        //if terms parameter == true, terms and conditios should be acknowledged
                        Boolean.parseBoolean(TestCases.registration[i][6]),

                        //if gdpr == true, gdpr checkbox should be ticked
                        Boolean.parseBoolean(TestCases.registration[i][7]),

                        //if marketing == true, consent to marketing emails
                        Boolean.parseBoolean(TestCases.registration[i][8]));
            }

        }
