package com.spbstu.pageObjects.mantisbt;

import com.spbstu.MantisbtSite;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ihb on 14.04.17.
 */
public class BasePage {

    @FindBy(css = "li.hidden-sm.hidden-xs > div > a:nth-child(1)")
    private WebElement reportIssueButton;

    @FindBy(css = "#sidebar > ul > li:nth-child(2) > a")
    private WebElement viewIssueButton;

    public void openBugReportPage(){
        reportIssueButton.click();
        MantisbtSite.currPage = this;
    }

    public void openViewAllBugPage(){
        viewIssueButton.click();
        MantisbtSite.currPage = this;
    }
}
