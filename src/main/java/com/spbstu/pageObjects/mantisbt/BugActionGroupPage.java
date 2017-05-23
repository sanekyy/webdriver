package com.spbstu.pageObjects.mantisbt;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ihb on 10.04.17.
 */
public class BugActionGroupPage extends BasePage {

    @FindBy(css = ".clearfix > input")
    WebElement deleteIssuesButton;


    public void confirmRemove() {
        deleteIssuesButton.click();
    }
}
