package com.spbstu.pageObjects.mantisbt;

import com.sun.istack.internal.NotNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Created by ihb on 10.04.17.
 */
public class ViewAllBugPage {


    @FindBy(xpath = "//*[@id=\"buglist\"]/tbody/tr[1]/td[11]")
    private WebElement summary;

    @FindBy(xpath = "//*[@id=\"buglist\"]/tbody/tr[1]/td[1]/div/label/span")
    private WebElement mark;

    @FindBy(xpath = "//*[@id=\"bug_action\"]/div/div[2]/div[2]/div[2]/div[1]/select")
    private WebElement action;

    @FindBy(xpath = "//*[@id=\"bug_action\"]/div/div[2]/div[2]/div[2]/div[1]/input")
    private WebElement okButton;

    public boolean deleteIssue(@NotNull String testTime){
        if(testTime.equals(summary.getText())){
            mark.click();
        } else {
            return false;
        }

        new Select(action).selectByIndex(4);

        okButton.click();

        return true;
    }
}
