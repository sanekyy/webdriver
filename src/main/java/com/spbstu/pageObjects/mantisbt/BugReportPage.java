package com.spbstu.pageObjects.mantisbt;

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
public class BugReportPage {


    // null если тип будет Select
    @FindBy(id = "category_id")
    WebElement categoryId;

    @FindBy(id = "reproducibility")
    WebElement reproducibility;

    @FindBy(id = "severity")
    WebElement severity;

    @FindBy(id = "priority")
    WebElement priority;

    @FindBy(id = "profile_closed_link")
    WebElement profileClosedLink;

    @FindBy(id = "platform")
    WebElement platform;

    @FindBy(id = "os")
    WebElement os;

    @FindBy(id = "os_build")
    WebElement osBuild;

    @FindBy(id = "handler_id")
    WebElement handlerId;

    @FindBy(id = "summary")
    WebElement summary;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(id = "steps_to_reproduce")
    WebElement stepsToReproduce;

    @FindBy(id = "additional_info")
    WebElement additionalInfo;

    @FindBy(id = "tag_string")
    WebElement tagString;

    @FindBy(name = "view_state")
    List<WebElement>  radioButtonsList;

    @FindBy(xpath = "//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input")
    WebElement submitIssueButton;

    public void fillBugReport(String summaryValue){

        Random rand = new Random(System.currentTimeMillis());

        Select categoryIdS = new Select(categoryId);
        categoryIdS.selectByIndex(
                Math.abs(rand.nextInt())%categoryIdS.getOptions().size()
        );
        Select reproducibilityS = new Select(categoryId);
        reproducibilityS.selectByIndex(
                Math.abs(rand.nextInt())%reproducibilityS.getOptions().size()
        );
        Select severityS = new Select(categoryId);
        severityS.selectByIndex(
                Math.abs(rand.nextInt())%severityS.getOptions().size()
        );
        Select priorityS = new Select(categoryId);
        priorityS.selectByIndex(
                Math.abs(rand.nextInt())%priorityS.getOptions().size()
        );
        try {
            profileClosedLink.click();
        } catch (WebDriverException ignored){

        }
        platform.sendKeys("Intel");
        os.sendKeys("Ubuntu");
        osBuild.sendKeys("16.04 LTS");
        Select handlerIdS = new Select(categoryId);
        handlerIdS.selectByIndex(
                Math.abs(rand.nextInt())%handlerIdS.getOptions().size()
        );
        summary.sendKeys(summaryValue);
        description.sendKeys("description");
        stepsToReproduce.sendKeys("steps_to_reproduce");
        additionalInfo.sendKeys("additional_info");
        tagString.sendKeys("tag_string");
        radioButtonsList.get(Math.abs(rand.nextInt())%radioButtonsList.size())
                .sendKeys(Keys.SPACE);
    }

    public void submitIssue(){
        submitIssueButton.click();
    }
}
