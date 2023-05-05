package org.qaautomation.pages;
import org.openqa.selenium.By;

public class LoginPage {
    //Input Element locators - login
    public static final By loginButton = By.className("link-login");
    public static final By loginUsernameField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[1]/div[1]/div[1]/div[2]/input");
    public static final By loginPasswordField = By.xpath("/html/body/div[6]/div[1]/div[4]/div[2]/form/div/div/table/tbody/tr[2]/td[1]/div[1]/div[2]/div[2]/input");

    //Input error element locators - login

    public static final By loginErrUsername = By.xpath("//*[@id=\"checkout_login_login\"]/div[1]/div[2]/div");
    public static final By loginErrPassword = By.xpath("//*[@id=\"checkout_login_login\"]/div[2]/div[2]/div");
}
