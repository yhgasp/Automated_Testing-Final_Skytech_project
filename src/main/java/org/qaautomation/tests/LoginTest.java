package org.qaautomation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qaautomation.base.LoginCases;
import org.qaautomation.base.RegistrationCases;
import org.qaautomation.pages.LoginPage;
import org.qaautomation.pages.RegisterPage;
import org.qaautomation.utilities.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BasePage {

    public LoginTest(WebDriver driver) {
        super(driver);
    }

    public static void LoginAttempt(String email, String password) {

        //wait for register button to be visible, then click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logButton = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));
        logButton.click();

        //wait for input fields to be visible, enter form data and submit
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.usernameField));
        emailField.sendKeys(email);

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.passwordField));
        passwordField.sendKeys(password);

        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.submitButton));
        submitButton.click();
    }

    public static void runLoginTestCases() {

        //for each entry in login test case array, we call loginAttempt()
        for (int i = 0; i < LoginCases.login.length; i++) {

            //calling the method with all appropriate parameters
            LoginAttempt(
                    LoginCases.login[i][0][0],  //first name
                    LoginCases.login[i][0][1]); //last name


//            //checking expected results vs actual
            if (LoginCases.login[i][1][0] == null) {

                //if expected errors is null, wait for success message to be visible
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.accountManageButton));

                String successMessageActual = successMessageElement.getText();

                //assert actual success message received matches expectation defined in TestCases
                assertEquals(successMessageActual, RegistrationCases.regSuccessExpected);

            } else {
                checkLoginErrors(i);
            }


        }
    }

    public static void checkLoginErrors(int testCaseIndex){
        //collect all errors from both types of error elements
        List<WebElement> credentialError = driver.findElements(LoginPage.credErrorClass);
        List<WebElement> otherErrors = driver.findElements(LoginPage.errorClass);

        //concatenate the lists
        credentialError.addAll(otherErrors);

        //converting WebElement actual error list to string list
        List<String> actualErrors = new ArrayList<>( //declare new list
                credentialError //WebElement list
                        .stream() //convert list to a stream
                        .map(WebElement::getText) //get text from each element of the stream
                        .filter(Predicate.not(String::isEmpty)) //filter out empty elements of the stream
                        .toList()); //record remaining elements to a list

        //convert expected errors from TestCases array to string list
        List<String> expectedErrors = new ArrayList<>(
                Arrays.stream( //turn the provided array to stream
                                LoginCases.login[testCaseIndex][1]) //array of expected errors
                        .toList()); //record stream to list


        assertEquals(expectedErrors,actualErrors);
    }

} //class