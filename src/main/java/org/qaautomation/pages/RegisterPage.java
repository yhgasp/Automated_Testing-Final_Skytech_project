package org.qaautomation.pages;

import org.openqa.selenium.By;

public class RegisterPage {

    //Input element locators - Registering
    public static final By regScreenButton = By.className("link-register");
    public static final By regFormElements = By.className("form-line");
    public static final By regFirstNameField = By.name("vardas");
    public static final By regLastNameField = By.name("pavarde");
    public static final By regPhoneField = By.name("phone");
    public static final By regEmailField = By.name("mail");
    public static final By regPasswordField = By.name("pass");
    public static final By regRepeatPasswordField = By.name("pass2");
    public static final By regTermAcknowledgement = By.name("rules");
    public static final By regGdprConsent = By.name("consent");
    public static final By regMarketingConsent = By.name("newsletter");
    public static final By regInfoSubmit = By.xpath("/html/body/div[6]/div[1]/div[6]/div[2]/form/div/table/tbody/tr/td[2]/div/div/input");


    //Registration success locators
    public static final By regSuccessMessage = By.xpath("//*[@id=\"centerpanel\"]/table/tbody/tr/td[2]/span");


    //Input error element locators - Registering
    public static final By regErrClass = By.className("error-message");
}