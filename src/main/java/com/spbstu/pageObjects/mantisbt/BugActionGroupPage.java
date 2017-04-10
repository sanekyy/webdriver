package com.spbstu.pageObjects.mantisbt;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ihb on 10.04.17.
 */
public class BugActionGroupPage {

    @FindBy(xpath = "//*[@id=\"action-group-div\"]/form/div/div[2]/div[2]/input")
    WebElement deleteIssuesButton;

    public void confirmRemove(){
        deleteIssuesButton.click();
    }
}
