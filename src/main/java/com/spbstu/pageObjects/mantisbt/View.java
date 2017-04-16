package com.spbstu.pageObjects.mantisbt;

import com.spbstu.pageObjects.BugReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ihb on 14.04.17.
 */
public class View extends BasePage {

    @FindBy(css = "td.bug-platform")
    WebElement platform;

    @FindBy(css = "td.bug-os")
    WebElement os;

    @FindBy(css = "td.bug-os-version")
    WebElement osBuild;

    @FindBy(css = "tr:nth-child(13) > td")
    WebElement description;

    @FindBy(css = "tr:nth-child(14) > td")
    WebElement stepsToReproduce;

    @FindBy(css = "tr:nth-child(15) > td")
    WebElement additionalInfo;

    @FindBy(css = "td.bug-reporter")
    WebElement reporter;

    @FindBy(css = "td.bug-assigned-to")
    WebElement assignTo;


    public boolean isBugReportPresented(BugReport bugReport) {
        return bugReport.getPlatform().equals(platform.getText())
                && bugReport.getOs().equals(os.getText())
                && bugReport.getOsBuild().equals(osBuild.getText())
                && bugReport.getDescription().equals(description.getText())
                && bugReport.getStepsToReproduce().equals(stepsToReproduce.getText())
                && bugReport.getAdditionalInfo().equals(additionalInfo.getText())
                && bugReport.getReporter().equals(reporter.getText())
                && bugReport.getAssignTo().equals(assignTo.getText());
    }
}
