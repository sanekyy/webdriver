package com.spbstu.pageObjects.mantisbt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ihb on 10.04.17.
 */
public class MyViewPage {

    @FindBy(xpath = "//*[@id=\"navbar-container\"]/div[2]/ul/li[1]/div/a[1]")
    private WebElement reportIssueButton;



    public void openBugReport(){
        reportIssueButton.click();
    }
}
