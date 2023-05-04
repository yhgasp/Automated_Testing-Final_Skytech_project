package org.qaautomation;
import org.openqa.selenium.WebDriver;

public class RegisterAndLoginV2 extends BasePage {

    //class constructor that inherits driver properties from Base page
    public RegisterAndLoginV2(WebDriver driver) {
        super(driver);
    }


    public static void runRegistrationTestCases() {

        //for each entry in registration test case array, the registration method is called with appropriate parameters
        for (int i = 0; i < TestProperties.regTestCases.length; i++) {


            driver.findElement(ElementLocators.regScreenButton).click(); //start or reset registration attempt


            //enter basic registration info
            driver.findElement(ElementLocators.regFirstNameField).sendKeys(TestProperties.regTestCases[i][0]); // first name
            driver.findElement(ElementLocators.regLastNameField).sendKeys(TestProperties.regTestCases[i][1]); //last name
            driver.findElement(ElementLocators.regPhoneField).sendKeys(TestProperties.regTestCases[i][2]); //phone
            driver.findElement(ElementLocators.regEmailField).sendKeys(TestProperties.regTestCases[i][3]); //email
            driver.findElement(ElementLocators.regPasswordField).sendKeys(TestProperties.regTestCases[i][4]); //password
            driver.findElement(ElementLocators.regRepeatPasswordField).sendKeys(TestProperties.regTestCases[i][5]); //repeat password

            //if terms parameter == true, acknowledge terms and conditions
            if (Boolean.parseBoolean(TestProperties.regTestCases[i][6])) {
                driver.findElement(ElementLocators.regTermAcknowledgement).click();
            }


            //if gdpr == true, consent to personal data use
            if (Boolean.parseBoolean(TestProperties.regTestCases[i][7])) {
                driver.findElement(ElementLocators.regGdprConsent).click();
            }


            //if marketing == true, consent to marketing emails
            if (Boolean.parseBoolean(TestProperties.regTestCases[i][8])) {
                driver.findElement(ElementLocators.regMarketingConsent).click();
            }

            //submit all info
            driver.findElement(ElementLocators.regInfoSubmit).click();
        }

    }
} //class
