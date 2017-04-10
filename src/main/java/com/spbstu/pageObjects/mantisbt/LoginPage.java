package com.spbstu.pageObjects.mantisbt;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ihb on 10.04.17.
 */
public class LoginPage {
    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;


    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password + Keys.ENTER);
    }
}
