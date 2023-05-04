package org.qaautomation;
import org.openqa.selenium.By;

public class ElementLocators {

    //Element locators - Registering
    protected static final By regScreenButton = By.className("link-register");
    protected static final By regFirstNameField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[1]/div[2]/input");
    protected static final By regLastNameField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[2]/div[2]/input");
    protected static final By regPhoneField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[3]/div[2]/input");
    protected static final By regEmailField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[4]/div[2]/input");
    protected static final By regPasswordField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[5]/div[2]/input");
    protected static final By regRepeatPasswordField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[6]/div[2]/input");
    protected static final By regTermAcknowledgement = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[7]/div[1]/input");
    protected static final By regGdprConsent = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[8]/div[1]/input");
    protected static final By regMarketingConsent = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[2]/div/div[9]/div/input");
    protected static final By regInfoSubmit = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/table/tbody/tr/td[2]/div/div/input");


    //Element locators - login
    protected static final By loginButton = By.className("link-login");
    protected static final By loginUsernameField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[1]/div[1]/div[1]/div[2]/input");
    protected static final By loginPasswordField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[1]/div[1]/div[2]/div[2]/input");
}
