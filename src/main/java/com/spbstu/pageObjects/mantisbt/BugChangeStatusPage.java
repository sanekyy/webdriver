package com.spbstu.pageObjects.mantisbt;

import com.spbstu.MantisbtSite;
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

    public void confirm(){
        new Select(assignedTo).selectByVisibleText(MantisbtSite.currUser.getLogin());
        changeIssueStatusButton.click();
    }
}
