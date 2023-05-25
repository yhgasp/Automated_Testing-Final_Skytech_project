package org.qaautomation.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qaautomation.utilities.BasePage;
import org.qaautomation.utilities.QuickActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.qaautomation.utilities.ExceptionHandling.AssertEquals.assertEquals;

public class LoginMethods extends BasePage {

    protected LoginMethods(WebDriver driver) {
        super(driver);
    }

    public static void runLoginTestCases() {

        //for each entry in login test case array, calls loginAttempt()
        for (int i = 0; i < LoginCases.cases.length; i++) {

            //calling the login method with all appropriate parameters
            loginAttempt(
                    LoginCases.cases[i][0][0],
                    LoginCases.cases[i][1][0],
                    LoginCases.cases[i][1][1]);

            //check login results, test case name and expected error list as parameters
            loginResultCheck(
                    LoginCases.cases[i][0][0],
                    getExpectedErrorList(i)
            );

            logout();
        }
    }

    public static void loginAttempt(String testCaseName, String email, String password) {
            //wait for login button to be visible, then click
            QuickActions.findAndClick(LoginPage.loginButton);

            //enter form data and submit
            QuickActions.sendKeys(LoginPage.usernameField, email);
            QuickActions.sendKeys(LoginPage.passwordField, password);
            QuickActions.findAndClick(LoginPage.submitButton);
    }

    protected static void loginResultCheck(String testCaseName, List<String> expectedErrors){
        //get expected and actual error lists
        List<String> actualErrors = getLoginErrorList();

        //check if expected and actual error lists match
        assertEquals(
                testCaseName,
                "list of errors",
                expectedErrors,
                actualErrors
        );

        //if no errors are expected, and none are found, check login success
        if (expectedErrors.size() == 0 && actualErrors.size() == 0){
            //if expected errors is null, wait for success message to be visible
            String successMessageActual = QuickActions.waitForVis(LoginPage.accountManageButton).getText();

            //assert actual success message received matches expectation defined in TestCases
            assertEquals(testCaseName,
                    "login success message",
                    LoginPage.successMsgExpected,
                    successMessageActual);
        }
    }

    protected static void logout(){
        QuickActions.hoverClick(
                LoginPage.accountManageButton,
                LoginPage.accountManageLogout
        );
    }


    protected static List<String> getLoginErrorList(){
        //collect all errors from both types of error elements
        List<WebElement> credentialError = driver.findElements(LoginPage.errorCredentials);
        List<WebElement> otherErrors = driver.findElements(LoginPage.errorGeneral);

        //concatenate the lists defined above
        credentialError.addAll(otherErrors);

        //return a list of WebElements converted to strings
        return new ArrayList<>( //declare new list
                credentialError //WebElement list
                        .stream() //convert list to a stream
                        .map(WebElement::getText) //get text from each element of the stream
                        .filter(Predicate.not(String::isEmpty)) //filter out empty elements of the stream
                        .toList()); //record remaining elements to a list

    }

    protected static List<String> getExpectedErrorList(int testCaseIndex){
        //convert expected errors from TestCases array to string list
        return new ArrayList<>(
                Arrays.stream( //turn the provided array to stream
                        LoginCases.cases[testCaseIndex][2]) //array of expected errors
                        .toList()); //record stream to list
    }

} //class