package com.spbstu.pageObjects.mantisbt;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ihb on 16.05.17.
 */
public class BugChangeStatusPage extends BasePage {

    @FindBy(css = "div.widget-toolbox.padding-8.clearfix > input")
    WebElement changeIssueStatusButton;

    @FindBy(css = "tr:nth-child(3) > td > select")
    WebElement assignedTo;

    public void resolveIssue(){
        changeIssueStatusButton.click();
    }

    public void closeIssue() {
        new Select(assignedTo).selectByVisibleText("lead1");
        changeIssueStatusButton.click();
    }
}
