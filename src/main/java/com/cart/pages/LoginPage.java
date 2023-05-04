package com.cart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // public page constants
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    // private locators
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");

    // public page actions

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public String getLoginPageUrl(){
        return  driver.getCurrentUrl();
    }

    /**
     *
     * @param un
     * @param pwd
     */
    public void doLogin(String un , String pwd){
        driver.findElement(username).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginBtn).click();
    }
}
