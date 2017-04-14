package com.spbstu.pageObjects.mantisbt;

import com.spbstu.pageObjects.BugReport;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

/**
 * Created by ihb on 10.04.17.
 */
public class BugReportPage extends BasePage {


    // null если тип будет Select
    @FindBy(id = "category_id")
    private WebElement categoryId;

    @FindBy(id = "reproducibility")
    private WebElement reproducibility;

    @FindBy(id = "severity")
    private WebElement severity;

    @FindBy(id = "priority")
    private WebElement priority;

    @FindBy(id = "profile_closed_link")
    private WebElement profileClosedLink;

    @FindBy(id = "platform")
    private WebElement platform;

    @FindBy(id = "os")
    private WebElement os;

    @FindBy(id = "os_build")
    private WebElement osBuild;

    @FindBy(css = "#handler_id")
    private WebElement assignTo;

    @FindBy(id = "summary")
    private WebElement summary;

    @FindBy(id = "description")
    private WebElement description;

    @FindBy(id = "steps_to_reproduce")
    private WebElement stepsToReproduce;

    @FindBy(id = "additional_info")
    private WebElement additionalInfo;

    @FindBy(id = "tag_string")
    private WebElement tagString;

    @FindBy(css = ".clearfix > input")
    private WebElement submitIssueButton;

    public void fillBugReport(BugReport bugReport) {
        new Select(categoryId).selectByIndex(bugReport.getCategoryId());
        new Select(reproducibility).selectByIndex(bugReport.getReproducibility());
        new Select(severity).selectByIndex(bugReport.getSeverity());
        new Select(priority).selectByIndex(bugReport.getPriority());
        try{profileClosedLink.click();} catch (Exception ignored){}
        platform.sendKeys(bugReport.getPlatform());
        os.sendKeys(bugReport.getOs());
        osBuild.sendKeys(bugReport.getOsBuild());
        summary.sendKeys(bugReport.getSummary());
        description.sendKeys(bugReport.getDescription());
        stepsToReproduce.sendKeys(bugReport.getStepsToReproduce());
        additionalInfo.sendKeys(bugReport.getAdditionalInfo());
        tagString.sendKeys(bugReport.getTagString());

        new Select(assignTo).getOptions().stream()
                .filter(item -> bugReport.getAssignTo().equals(item.getText()))
                .findFirst()
                .get().click();
    }

    public void submitIssue() {
        submitIssueButton.click();
    }
}
