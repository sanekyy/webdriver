package com.spbstu.pageObjects.mantisbt;

import com.spbstu.pageObjects.BugReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ihb on 14.04.17.
 */
public class View extends BasePage {

    @FindBy(css = "td.bug-reporter")
    WebElement reporter;

    @FindBy(css = "td.bug-assigned-to")
    WebElement assignTo;

    @FindBy(css = "td.bug-reproducibility")
    WebElement reproducibility;

    @FindBy(css = "td.bug-severity")
    WebElement severity;

    @FindBy(css = "td.bug-priority")
    WebElement priority;

    @FindBy(css = "td.bug-platform")
    WebElement platform;

    @FindBy(css = "td.bug-os")
    WebElement os;

    @FindBy(css = "td.bug-os-version")
    WebElement osBuild;

    @FindBy(css = "td.bug-status")
    WebElement status;

    @FindBy(css = "tr:nth-child(12) > td")
    WebElement summary;

    @FindBy(css = "tr:nth-child(13) > td")
    WebElement description;

    @FindBy(css = "tr:nth-child(14) > td")
    WebElement stepsToReproduce;

    @FindBy(css = "tr:nth-child(15) > td")
    WebElement additionalInfo;

    @FindBy(css = "td.bug-resolution")
    WebElement resolution;

    @FindBy(css = "div:nth-child(3) > form > input.btn.btn-primary.btn-sm.btn-white.btn-round")
    WebElement changeStatusButton;

    @FindBy(css = "div:nth-child(3) > form > select")
    WebElement changeStatus;







    public boolean isBugReportPresented(BugReport bugReport) {
        try {
            if(bugReport.getReporter().equals(reporter.getText())
                    && assignTo.getText().equals(bugReport.getAssignTo())
                    && reproducibility.getText().equals(bugReport.getReproducibilityText())
                    && severity.getText().equals(bugReport.getSeverityText())
                    && priority.getText().equals(bugReport.getPriorityText())
                    && platform.getText().equals(bugReport.getPlatform())
                    && os.getText().equals(bugReport.getOs())
                    && osBuild.getText().equals(bugReport.getOsBuild())
                    && summary.getText().contains(bugReport.getSummary())
                    && description.getText().equals(bugReport.getDescription())
                    && stepsToReproduce.getText().equals(bugReport.getStepsToReproduce())
                    && additionalInfo.getText().equals(bugReport.getAdditionalInfo())
                    ) {
                if (bugReport.getStatus().equals("open")
                        && status.getText().equals("assigned")
                        && resolution.getText().equals("open"))
                    return true;
                else if (bugReport.getStatus().equals("resolved")
                        && status.getText().equals("resolved")
                        && resolution.getText().equals("fixed"))
                    return true;
                else if(bugReport.getStatus().equals("closed")
                        && status.getText().equals("closed")
                        && resolution.getText().equals("fixed"))
                    return true;
            }

            return false;
        } catch (Exception e){
            return false;
        }
    }

    public void changeStutusToResolved(){
        new Select(changeStatus).selectByIndex(4);
        changeStatusButton.click();
    }

    public void changeStutusToClosed(){
        new Select(changeStatus).selectByIndex(5);
        changeStatusButton.click();
    }
}
