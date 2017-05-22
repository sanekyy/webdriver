package com.spbstu.webdriver.stepDefs;

import com.spbstu.MantisbtSite;
import com.spbstu.pageObjects.BugReport;
import com.spbstu.pageObjects.User;
import com.spbstu.webdriver.helper.ResourceLoaderSTU;
import com.spbstu.webdriver.mantisbt.MantisbtBaseTest;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

/**
 * Created by ihb on 18.04.17.
 */
public class MyStepdefs extends MantisbtBaseTest{

    BugReport bugReport = ResourceLoaderSTU.getBugReport();

    @Before
    public void before(Scenario scenario) {
        super.before();
    }

    @After
    public void after(Scenario scenario) throws InterruptedException {
        driver.quit();
    }

    @Given("^Login as \"([^\"]*)\"$")
    public void logInAs(String username) throws Throwable {
        MantisbtSite.open();
        MantisbtSite.loginPage.login(ResourceLoaderSTU.getMantisbtUser(username));
    }

    @And("^Open \"([^\"]*)\"$")
    public void open(String pageName) throws Throwable {
        switch (pageName) {
            case "mantis site":
                MantisbtSite.open();
                break;
            case "bug report page":
                MantisbtSite.currPage.openBugReportPage();
                break;
            case "view all bug page":
                MantisbtSite.currPage.openViewAllBugPage();
                break;
            default:
                throw new PendingException("Open what?");
        }
    }

    @And("^Fill bug report$")
    public void fillBugReport() throws Throwable {
        MantisbtSite.bugReportPage.fillBugReport(bugReport);
    }

    @And("^Submit issue$")
    public void submitIssue() throws Throwable {
        MantisbtSite.bugReportPage.submitIssue();
    }

    @Then("^Should see bug report$")
    public void shouldSeeBugReport() throws Throwable {
        Assert.assertTrue(
                MantisbtSite.viewAllBugPage.isBugReportPresented(bugReport)
        );
    }

    @Given("^Reopen browser$")
    public void reopenBrowser() throws Throwable {
        reopenDriver();
    }

    @And("^Find bug report$")
    public void findBugReport() throws Throwable {
        Assert.assertTrue(findBugReport(bugReport));
    }

    @Then("^Open bug$")
    public void openBug() throws Throwable {
        MantisbtSite.openBugById(bugReport.getId());
    }

    @And("^Change bug status to \"([^\"]*)\"$")
    public void changeBugStatusTo(String newStatus) throws Throwable {
        MantisbtSite.view.changeStatus(newStatus);
        MantisbtSite.bugChangeStatusPage.confirm();
        ResourceLoaderSTU.getBugReport().setStatus(newStatus);
        bugReport.setAssignTo(MantisbtSite.currUser.getLogin());
    }

    @And("^Set filter hide status to \"([^\"]*)\"$")
    public void setFilterHideStatusTo(String newFilter) throws Throwable {
        MantisbtSite.viewAllBugPage.setFilterHideStatus(newFilter);
    }
}
