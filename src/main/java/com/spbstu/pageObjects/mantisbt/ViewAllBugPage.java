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

    public boolean isBugReportPresented(BugReport bugReport) {
        return rows.stream()
                .anyMatch(row -> row.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr[1]/td[9]/div/a"))
                        .getText().equals(bugReport.getAssignTo())
                        && row.findElement(By.cssSelector("td.column-summary")).getText().equals(bugReport.getSummary())
                        && row.findElement(By.cssSelector("td.column-category")).getText().equals(bugReport.getCategoryText()));
    }

    public List<Integer> getBugReportsId(BugReport bugReport){
        return rows.stream()
                .filter(row -> row.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr[1]/td[9]/div/a"))
                        .getText().equals(bugReport.getAssignTo())
                        && row.findElement(By.cssSelector("td.column-summary")).getText().equals(bugReport.getSummary())
                        && row.findElement(By.cssSelector("td.column-category")).getText().equals(bugReport.getCategoryText()))
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
}
