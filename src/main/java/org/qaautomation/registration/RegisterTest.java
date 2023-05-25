package org.qaautomation.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qaautomation.utilities.BasePage;
import org.qaautomation.utilities.ExceptionHandling.AssertEquals;
import org.qaautomation.utilities.QuickActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.qaautomation.utilities.ExceptionHandling.AssertEquals.assertEquals;

public class RegisterTest extends BasePage {


    //class constructor that inherits driver properties from Base page
    private RegisterTest(WebDriver driver) {
        super(driver);
    }

    public static void runRegistrationTestCases() {

        //for each entry in registration test case array, the registration method is called with appropriate parameters
        for (int i = 0; i < RegisterCases.cases.length; i++) {

            //calling the registration method with all appropriate parameters
            RegistrationAttempt(
                    RegisterCases.cases[i][1][0], //first name
                    RegisterCases.cases[i][1][1], //last name
                    RegisterCases.cases[i][1][2], //phone
                    RegisterCases.cases[i][1][3], //email
                    RegisterCases.cases[i][1][4], //password
                    RegisterCases.cases[i][1][5], //repeat password
                    RegisterCases.cases[i][1][6], //terms
                    RegisterCases.cases[i][1][7], //gdpr
                    RegisterCases.cases[i][1][8]); //marketing


            //if expected errors is null, wait for success message to be visible
            if (RegisterCases.cases[i][1][0] == null) {
                String successMessageActual = QuickActions.waitForVis(RegisterPage.regSuccessMessage).getText();

                //assert actual success message received matches expectation defined in TestCases
                AssertEquals.assertEquals(
                        RegisterCases.cases[i][0][0],
                        "success message",
                        successMessageActual,
                        RegisterCases.successMsgExpected);

            } else {
                checkRegErrors(i);
            }


        }
    }

    //a method used to fill out all fields required for registration based on provided parameters
    private static void RegistrationAttempt(String firstName,
                                           String lastName,
                                           String phone,
                                           String email,
                                           String password,
                                           String repeatPassword,
                                           String terms,
                                           String gdpr,
                                           String marketing) {

        //click the registration button
        QuickActions.findAndClick(RegisterPage.regScreenButton);

        //enter form data
        QuickActions.sendKeys(RegisterPage.regFirstNameField, firstName);
        QuickActions.sendKeys(RegisterPage.regLastNameField, lastName);
        QuickActions.sendKeys(RegisterPage.regPhoneField, phone);
        QuickActions.sendKeys(RegisterPage.regEmailField, email);
        QuickActions.sendKeys(RegisterPage.regPasswordField, password);
        QuickActions.sendKeys(RegisterPage.regRepeatPasswordField,repeatPassword);

        //if terms parameter == true, terms and conditions should be acknowledged
        if (Boolean.parseBoolean(terms)) {
            QuickActions.findAndClick(RegisterPage.regTermAcknowledgement);
        }

        //if gdpr == true, gdpr checkbox should be ticked
        if (Boolean.parseBoolean(gdpr)) {
            QuickActions.findAndClick(RegisterPage.regGdprConsent);
        }

        //if marketing == true, consent to marketing emails
        if (Boolean.parseBoolean(marketing)) {
            QuickActions.findAndClick(RegisterPage.regMarketingConsent);
        }

        //submit form
        QuickActions.findAndClick(RegisterPage.regInfoSubmit);
    }

    private static void checkRegErrors(int testCaseIndex) {


        //collects all error elements into a list (due to website design it also grabs empty error fields)
        List<WebElement> errorList = driver.findElements(RegisterPage.regErrClass);

        //converting WebElement actual error list to string list
        List<String> actualErrors = new ArrayList<>( //declare new list
                errorList //WebElement list
                        .stream() //convert list to a stream
                        .map(WebElement::getText) //get text from each element of the stream
                        .filter(Predicate.not(String::isEmpty)) //filter out empty strings from the stream
                        .toList()); //record remaining elements to a list

        //convert expected errors from TestCases array to string list
        List<String> expectedErrors = new ArrayList<>(
                Arrays.stream( //turn the provided array to stream
                         RegisterCases.cases[testCaseIndex][2]) //array of expected errors
                        .toList()); //record stream to list


        assertEquals(
                RegisterCases.cases[testCaseIndex][0][0],
                "error list",
                expectedErrors,
                actualErrors);
    }
}
