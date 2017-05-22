package com.spbstu.pageObjects.mantisbt;

import com.spbstu.MantisbtSite;
import com.spbstu.pageObjects.User;
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


    public void login(User user) {
        this.username.sendKeys(user.getLogin());
        this.password.sendKeys(user.getPassword() + Keys.ENTER);

        MantisbtSite.currUser = user;
        MantisbtSite.currPage = MantisbtSite.myViewPage;
    }
}
