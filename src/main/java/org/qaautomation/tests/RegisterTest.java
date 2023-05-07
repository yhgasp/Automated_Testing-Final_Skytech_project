package org.qaautomation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qaautomation.utilities.BasePage;
import org.qaautomation.base.RegistrationCases;
import org.qaautomation.pages.RegisterPage;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;


public class RegisterTest extends BasePage {


    //class constructor that inherits driver properties from Base page
    public RegisterTest(WebDriver driver) {
        super(driver);
    }


    //a method used to fill out all fields required for registration based on provided parameters
    public static void RegistrationAttempt(String firstName,
                                           String lastName,
                                           String phone,
                                           String email,
                                           String password,
                                           String repeatPassword,
                                           String terms,
                                           String gdpr,
                                           String marketing) {

        //wait for register button to be visible, then click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement regButton = wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterPage.regScreenButton));
        regButton.click();


        //wait until all forms elements can be located
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(RegisterPage.regFormElements));

        //enter form data
        driver.findElement(RegisterPage.regFirstNameField).sendKeys(firstName);
        driver.findElement(RegisterPage.regLastNameField).sendKeys(lastName);
        driver.findElement(RegisterPage.regPhoneField).sendKeys(phone);
        driver.findElement(RegisterPage.regEmailField).sendKeys(email);
        driver.findElement(RegisterPage.regPasswordField).sendKeys(password);
        driver.findElement(RegisterPage.regRepeatPasswordField).sendKeys(repeatPassword);

        //if terms parameter == true, terms and conditions should be acknowledged
        if (Boolean.parseBoolean(terms)) {
            driver.findElement(RegisterPage.regTermAcknowledgement).click();
        }

        //if gdpr == true, gdpr checkbox should be ticked
        if (Boolean.parseBoolean(gdpr)) {
            driver.findElement(RegisterPage.regGdprConsent).click();
        }

        //if marketing == true, consent to marketing emails
        if (Boolean.parseBoolean(marketing)) {
            driver.findElement(RegisterPage.regMarketingConsent).click();
        }

        //submit form
        driver.findElement(RegisterPage.regInfoSubmit).click();
    }

    public static void runRegistrationTestCases() {

        //for each entry in registration test case array, the registration method is called with appropriate parameters
        for (int i = 0; i < RegistrationCases.registration.length; i++) {

            //calling the method with all appropriate parameters
            RegistrationAttempt(
                    RegistrationCases.registration[i][0][0], //first name
                    RegistrationCases.registration[i][0][1], //last name
                    RegistrationCases.registration[i][0][2], //phone
                    RegistrationCases.registration[i][0][3], //email
                    RegistrationCases.registration[i][0][4], //password
                    RegistrationCases.registration[i][0][5], //repeat password
                    RegistrationCases.registration[i][0][6], //terms
                    RegistrationCases.registration[i][0][7], //gdpr
                    RegistrationCases.registration[i][0][8]); //marketing


            //checking expected results vs actual
            if (RegistrationCases.registration[i][1][0] == null) {

                //if expected errors is null, wait for success message to be visible
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterPage.regSuccessMessage));
                String successMessageActual = successMessageElement.getText();

                //assert actual success message received matches expectation defined in TestCases
                assertEquals(successMessageActual, RegistrationCases.regSuccessExpected);

            } else {
                checkRegErrors(i);
            }


        }
    }

    public static void checkRegErrors(int testCaseIndex) {


        //collects all error elements into a list (due to website design it also grabs empty error fields)
        List<WebElement> errorList = driver.findElements(RegisterPage.regErrClass);

        //converting WebElement actual error list to string list
        List<String> actualErrors = new ArrayList<>( //declare new list
                errorList //WebElement list
                        .stream() //convert list to a stream
                        .map(WebElement::getText) //get text from each element of the stream
                        .filter(Predicate.not(String::isEmpty)) //filter out empty elements of the stream
                        .toList()); //record remaining elements to a list

        //convert expected errors from TestCases array to string list
        List<String> expectedErrors = new ArrayList<>(
                Arrays.stream( //turn the provided array to stream
                                RegistrationCases.registration[testCaseIndex][1]) //array of expected errors
                        .toList()); //record stream to list


        assertEquals(expectedErrors,actualErrors);
    }
}
