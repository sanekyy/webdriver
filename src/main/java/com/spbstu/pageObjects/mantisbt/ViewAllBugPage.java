package com.spbstu.pageObjects.mantisbt;

import com.spbstu.pageObjects.BugReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ihb on 10.04.17.
 */
public class ViewAllBugPage extends BasePage {

    private static int DELETE_ACTION_INDEX = 4;

    @FindBy(css = ".pull-left > select")
    private WebElement action;

    @FindBy(css = ".clearfix > div.form-inline.pull-left > input")
    private WebElement okButton;

    @FindBy(xpath = "//*[@id=\"buglist\"]/tbody/tr")
    private List<WebElement> rows;

    @FindBy(css = "tr:nth-child(1) > td.column-category > div")
    private WebElement categoryText;

    @FindBy(id = "hide_status_filter")
    private WebElement hideStatusFilterText;

    @FindBy(css = "#hide_status_filter_target > select")
    private WebElement hideStatusFilter;

    @FindBy(css = "input.btn.btn-primary.btn-sm.btn-white.btn-round.no-float")
    private WebElement applyFilterButton;


    public boolean isBugReportPresented(BugReport bugReport) {
        return rows.stream()
                .anyMatch(row -> {
                    if (!row.findElement(By.cssSelector("td.column-category > div")).getText().contains(bugReport.getCategoryText())
                            || !row.findElement(By.cssSelector("td.column-summary")).getText().equals(bugReport.getSummary()))
                        return false;

                    if (bugReport.getSeverity().equals("block") && !bugReport.getStatus().equals("closed")
                            && !row.findElement(By.cssSelector("td.column-severity > span")).getText().equals(bugReport.getSeverity()))
                        return false;
                    else if (!row.findElement(By.cssSelector("td.column-severity")).getText().equals(bugReport.getSeverity()))
                        return false;

                    if (bugReport.getStatus().equals("open")
                            && (!row.findElement(By.cssSelector("td.column-status > div > span")).getText().equals("assigned")
                            || !row.findElement(By.cssSelector("td.column-status > div > a")).getText().equals(bugReport.getAssignTo())))
                        return false;
                    else if (bugReport.getStatus().equals("resolved")
                            && (!row.findElement(By.cssSelector("td.column-status > div > span")).getText().equals("resolved")
                            || !row.findElement(By.cssSelector("td.column-status > div > a")).getText().equals(bugReport.getAssignTo())))
                        return false;

                    else if (bugReport.getStatus().equals("closed")
                            && (!row.findElement(By.cssSelector("td.column-status > div > span")).getText().equals("closed")
                            || !row.findElement(By.cssSelector("td.column-status > div > a")).getText().equals(bugReport.getAssignTo())))
                        return false;

                    return true;

                });
    }

    public List<Integer> getBugReportIds(BugReport bugReport) {
        return rows.stream()
                .filter(row -> row.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr[1]/td[9]/div/a"))
                        .getText().equals(bugReport.getAssignTo())
                        && row.findElement(By.cssSelector("td.column-category > div")).getText().equals(bugReport.getCategoryText())
                        && row.findElement(By.cssSelector("td.column-status > div > a")).getText().equals(bugReport.getAssignTo())
                        && row.findElement(By.cssSelector("td.column-summary")).getText().equals(bugReport.getSummary()))
                .filter(row -> {
                    if (bugReport.getSeverity().equals("block") && !bugReport.getStatus().equals("closed"))
                        return row.findElement(By.cssSelector("td.column-severity > span")).getText().equals(bugReport.getSeverity());
                    else
                        return row.findElement(By.cssSelector("td.column-severity")).getText().equals(bugReport.getSeverity());
                })
                .map(row -> Integer.valueOf(row.findElement(By.cssSelector("td.column-id > a")).getText()))
                .collect(Collectors.toList());
    }


    public void deleteBugReportById(int id) {
        rows.stream()
                .filter(row -> id == Integer.valueOf(row.findElement(By.cssSelector("td.column-id > a")).getText()))
                .findFirst()
                .map(row -> row.findElement(By.cssSelector("td.column-selection > div > label > span")))
                .get()
                .click();
        new Select(action).selectByIndex(DELETE_ACTION_INDEX);
        okButton.click();
    }

    public void setFilterHideStatus(String newStatus) {
        hideStatusFilterText.click();
        new Select(hideStatusFilter).selectByVisibleText(newStatus);
        applyFilterButton.click();
    }
}
