package com.spbstu.pageObjects.mantisbt;

import com.spbstu.pageObjects.BugReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ihb on 10.04.17.
 */
public class BugReportPage extends BasePage {


    // null если тип будет Select
    @FindBy(id = "category_id")
    private WebElement category;

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
        new Select(category)
                .selectByVisibleText(bugReport.getCategorySelectorText());
        // TODO: 17.05.17 visible text
        new Select(reproducibility).selectByVisibleText(bugReport.getReproducibility());
        new Select(severity).selectByVisibleText(bugReport.getSeverity());
        new Select(priority).selectByVisibleText(bugReport.getPriority());
        try {
            profileClosedLink.click();
        } catch (Exception ignored) {
        }
        platform.sendKeys(bugReport.getPlatform());
        os.sendKeys(bugReport.getOs());
        osBuild.sendKeys(bugReport.getOsBuild());
        bugReport.setSummary(bugReport.getSummary());
        summary.sendKeys(bugReport.getSummary());
        description.sendKeys(bugReport.getDescription());
        stepsToReproduce.sendKeys(bugReport.getStepsToReproduce());
        additionalInfo.sendKeys(bugReport.getAdditionalInfo());
        tagString.sendKeys(bugReport.getTagString());
        new Select(assignTo).getOptions().stream()
                .filter(item -> bugReport.getAssignTo().equals(item.getText()))
                .findFirst()
                .get().click();

        bugReport.setStatus("open");
    }

    public void submitIssue() {
        submitIssueButton.click();
    }
}
