package org.qaautomation.pages;
import org.openqa.selenium.By;

public class LoginPage {
    //Input Element locators - login
    public static final By loginButton = By.className("link-login");
    public static final By usernameField = By.name("email_address");
    public static final By passwordField = By.name("password");

    public static final By submitButton = By.xpath("//*[@id=\"submit-login\"]/div/input");

    //Input error element locators - login
    public static final By errorClass = By.className("error-message");
    public static final By credErrorClass = By.className("login-error");

    //Login success element locators
    public static final By accountManageButton = By.xpath("/html/body/div[6]/div[1]/div[4]/ul/li[7]/a");
}
