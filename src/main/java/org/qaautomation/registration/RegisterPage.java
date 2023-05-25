package org.qaautomation.registration;

import org.openqa.selenium.By;

class RegisterPage {

    //Input element locators - Registering
    protected static final By regScreenButton = By.className("link-register");
    protected static final By regFirstNameField = By.name("vardas");
    protected static final By regLastNameField = By.name("pavarde");
    protected static final By regPhoneField = By.name("phone");
    protected static final By regEmailField = By.name("mail");
    protected static final By regPasswordField = By.name("pass");
    protected static final By regRepeatPasswordField = By.name("pass2");
    protected static final By regTermAcknowledgement = By.name("rules");
    protected static final By regGdprConsent = By.name("consent");
    protected static final By regMarketingConsent = By.name("newsletter");
    protected static final By regInfoSubmit = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/table/tbody/tr/td[2]/div/div/input");


    //Registration success locators
    protected static final By regSuccessMessage = By.xpath("//*[@id=\"centerpanel\"]/table/tbody/tr/td[2]/span");


    //Input error element locators - Registering
    protected static final By regErrClass = By.className("error-message");
}