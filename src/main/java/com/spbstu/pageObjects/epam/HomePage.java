package com.spbstu.pageObjects.epam;

import com.spbstu.pageObjects.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ihb on 10.04.17.
 */
public class HomePage {
    @FindBy(id = "Login")
    private WebElement login;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(css = "form button")
    private WebElement submit;

    @FindBy(css = "li[class*='uui-profile-menu']")
    private WebElement profileMenu;

    @FindBy(css = "[class='profile-photo'] span")
    private WebElement userName;

    @FindBy(xpath = "(//*[@class='sidebar-menu'] //a[@href='page1.htm'])[1]")
    private WebElement contactFormLink;

    public void login(User user){
        profileMenu.click();
        this.login.sendKeys(user.getLogin());
        this.password.sendKeys(user.getPassword());
        submit.click();
    }

    public String getUserName(){
        return userName.getText();
    }

    public void openContactForm(){
        contactFormLink.click();
    }
}
