package org.qaautomation.login;
import org.openqa.selenium.By;

class LoginPage {
    //Input Element locators - login
    protected static final By loginButton = By.className("link-login");
    protected static final By usernameField = By.name("email_address");
    protected static final By passwordField = By.name("password");

    protected static final By submitButton = By.xpath("//*[@id=\"submit-login\"]/div/input");

    //Input error element locators - login
    protected static final By errorGeneral = By.className("error-message");
    protected static final By errorCredentials = By.className("login-error");

    //Logged in - element locators

    protected static final String successMsgExpected = "Mano paskyra";
    protected static final By accountManageButton = By.xpath(
            "//*[@id=\"body\"]/div[6]/div[1]/div[2]/ul/li[7]/a");
    protected static final By accountManageLogout = By.xpath(
            "//*[@id=\"body\"]/div[6]/div[1]/div[2]/ul/li[7]/ul/li[9]/a");

    //Logged in - password change locators
    protected static final By passwordFieldCurrent = By.xpath(
            "(//input[@name='data[password_current]'])[1]");
    protected static final By passwordFieldNew = By.xpath(
            "(//input[@name='data[password_new]'])[1]");
    protected static final By passwordFieldNewRepeat = By.xpath(
            "(//input[@name='data[password_confirmation]'])[1]");
}
