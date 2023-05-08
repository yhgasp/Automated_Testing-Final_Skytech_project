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

    //Login success element locators
    protected static final By accountManageButton = By.xpath("/html/body/div[6]/div[1]/div[4]/ul/li[7]/a");
}
