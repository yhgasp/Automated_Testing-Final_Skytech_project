package org.qaautomation.pages;

import org.openqa.selenium.By;

public class RegisterPage {

    //Input element locators - Registering
    public static final By regScreenButton = By.className("link-register");
    public static final By regFirstNameField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[1]/div[2]/input");
    public static final By regLastNameField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[2]/div[2]/input");
    public static final By regPhoneField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[3]/div[2]/input");
    public static final By regEmailField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[4]/div[2]/input");
    public static final By regPasswordField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[5]/div[2]/input");
    public static final By regRepeatPasswordField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[6]/div[2]/input");
    public static final By regTermAcknowledgement = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[7]/div[1]/input");
    public static final By regGdprConsent = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[8]/div[1]/input");
    public static final By regMarketingConsent = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[9]/div/input");
    public static final By regInfoSubmit = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/table/tbody/tr/td[2]/div/div/input");

    //Input error element locators - Registering

    public static final By regErrName = By.xpath("//*[@id=\"checkout_login_register\"]/div[1]/div[2]/div");
    public static final By regErrLastName = By.xpath("//*[@id=\"checkout_login_register\"]/div[2]/div[2]/div");
    public static final By regErrPhone = By.xpath("//*[@id=\"checkout_login_register\"]/div[3]/div[2]/div");
    public static final By regErrEmail = By.xpath("//*[@id=\"checkout_login_register\"]/div[4]/div[2]/div");
    public static final By regErrPassword = By.xpath("//*[@id=\"checkout_login_register\"]/div[5]/div[2]/div");
    public static final By regErrRepeatPassword = By.xpath("//*[@id=\"checkout_login_register\"]/div[6]/div[2]/div");
    public static final By regErrTerms = By.xpath("//*[@id=\"checkout_login_register\"]/div[7]/div[2]");
    public static final By regErrGdpr = By.xpath("//*[@id=\"checkout_login_register\"]/div[8]/div[2]");
}