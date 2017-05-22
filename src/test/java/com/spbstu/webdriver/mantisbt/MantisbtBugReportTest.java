package com.spbstu.webdriver.mantisbt;

import com.spbstu.MantisbtSite;
import com.spbstu.pageObjects.BugReport;
import com.spbstu.pageObjects.User;
import com.spbstu.webdriver.helper.ResourceLoaderSTU;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


/**
 * Created by ihb on 10.04.17.
 */
public class MantisbtBugReportTest extends MantisbtBaseTest {

    private BugReport bugReport;

    @AfterMethod
    public void deleteIssue() {
        reopenDriver();

        MantisbtSite.open();

        User admin = ResourceLoaderSTU.getMantisbtUser("administrator");
        MantisbtSite.loginPage.login(admin);

        MantisbtSite.myViewPage.openViewAllBugPage();
        MantisbtSite.viewAllBugPage.setFilterHideStatus("[none]");
        MantisbtSite.viewAllBugPage.deleteBugReportById(bugReport.getId());
        MantisbtSite.bugActionGroupPage.confirmRemove();
        bugReport.setId(0);
    }

    @Test
    public void bugReportTest() {
        MantisbtSite.open();

        bugReport = ResourceLoaderSTU.getBugReport();
        User reporter = ResourceLoaderSTU.getMantisbtUser(bugReport.getReporter());

        MantisbtSite.loginPage.login(reporter);
        MantisbtSite.myViewPage.openBugReportPage();
        MantisbtSite.bugReportPage.fillBugReport(bugReport);
        MantisbtSite.bugReportPage.submitIssue();
        MantisbtSite.currPage.openViewAllBugPage();
        Assert.assertTrue(findBugReport(bugReport));
    }

    @Test
    public void bugReportFromReporterToDeveloperTest() {
        MantisbtSite.open();

        bugReport = ResourceLoaderSTU.getBugReport();
        User reporter = ResourceLoaderSTU.getMantisbtUser(bugReport.getReporter());

        MantisbtSite.loginPage.login(reporter);
        // не очевидно, что страница сменится на другую, т.е. на myViewPage
        MantisbtSite.myViewPage.openBugReportPage();
        MantisbtSite.bugReportPage.fillBugReport(bugReport);
        MantisbtSite.bugReportPage.submitIssue();

        reopenDriver();

        MantisbtSite.open();

        User assingTo = ResourceLoaderSTU.getMantisbtUser(bugReport.getAssignTo());
        MantisbtSite.loginPage.login(assingTo);
        MantisbtSite.myViewPage.openViewAllBugPage();

        Assert.assertTrue(findBugReport(bugReport));
    }

    @Test
    public void mainTest() {
        MantisbtSite.open();

        bugReport = ResourceLoaderSTU.getBugReport();
        User reporter = ResourceLoaderSTU.getMantisbtUser(bugReport.getReporter());

        MantisbtSite.loginPage.login(reporter);
        // не очевидно, что страница сменится на другую, т.е. на myViewPage
        MantisbtSite.myViewPage.openBugReportPage();
        MantisbtSite.bugReportPage.fillBugReport(bugReport);
        MantisbtSite.bugReportPage.submitIssue();
        MantisbtSite.viewAllBugPage.openViewAllBugPage();
        Assert.assertTrue(MantisbtSite.viewAllBugPage.isBugReportPresented(bugReport));


        reopenDriver();
        MantisbtSite.open();

        User assignTo = ResourceLoaderSTU.getMantisbtUser(bugReport.getAssignTo());
        MantisbtSite.loginPage.login(assignTo);
        MantisbtSite.myViewPage.openViewAllBugPage();

        Assert.assertTrue(findBugReport(bugReport));

        MantisbtSite.openBugById(bugReport.getId());

        MantisbtSite.view.changeStatus("resolved");
        MantisbtSite.bugChangeStatusPage.confirm();
        bugReport.setStatus("resolved");

        reopenDriver();
        MantisbtSite.open();

        User lead1 = ResourceLoaderSTU.getMantisbtUser("lead1");
        MantisbtSite.loginPage.login(lead1);

        MantisbtSite.myViewPage.openViewAllBugPage();

        Assert.assertTrue(findBugReport(bugReport));

        MantisbtSite.openBugById(bugReport.getId());

        MantisbtSite.view.changeStatus("closed");
        MantisbtSite.bugChangeStatusPage.confirm();
        bugReport.setStatus("closed");
        bugReport.setAssignTo(lead1.getLogin());

        MantisbtSite.bugChangeStatusPage.openViewAllBugPage();
        MantisbtSite.viewAllBugPage.setFilterHideStatus("[none]");

        Assert.assertTrue(findBugReport(bugReport));

    }
}
