package com.spbstu.webdriver.mantisbt;

import com.spbstu.MantisbtSite;
import com.spbstu.pageObjects.BugReport;
import com.spbstu.pageObjects.User;
import com.spbstu.webdriver.helper.ResourceLoaderSTU;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;


/**
 * Created by ihb on 10.04.17.
 */
public class MantisbtBugReportTest extends MantisbtBaseTest {

    BugReport bugReport;

    @Test
    public void bugReportTest(){
        MantisbtSite.open();

        bugReport = ResourceLoaderSTU.getBugReport();
        User reporter = ResourceLoaderSTU.getMantisbtUser(bugReport.getReporter());

        MantisbtSite.loginPage.login(reporter);
        // не очевидно, что страница сменится на другую, т.е. на myViewPage
        MantisbtSite.myViewPage.openBugReportPage();
        MantisbtSite.bugReportPage.fillBugReport(bugReport);
        MantisbtSite.bugReportPage.submitIssue();
        Assert.assertTrue(MantisbtSite.viewAllBugPage.isBugReportPresented(bugReport));
        List<Integer> ids = MantisbtSite.viewAllBugPage.getBugReportsId(bugReport);

        // вынести в отдельный метод? как назвать и где его разместить?
        boolean isBugReportPresented = false;
        for(Integer id : ids){
            MantisbtSite.openBugById(id);
            isBugReportPresented = MantisbtSite.view.isBugReportPresented(bugReport);
            if(isBugReportPresented) {
                bugReport.setId(id);
                break;
            }
        }
        Assert.assertTrue(isBugReportPresented);
    }

    @AfterMethod
    public void deleteIssue(){
        reopenDriver();

        MantisbtSite.open();

        User admin = ResourceLoaderSTU.getMantisbtUser("administrator");
        MantisbtSite.loginPage.login(admin);

        MantisbtSite.myViewPage.openViewAllBugPage();
        MantisbtSite.viewAllBugPage.deleteBugReportById(bugReport.getId());
        MantisbtSite.bugActionGroupPage.confirmRemove();
    }

    @Test
    public void bugReportFromReporterToDeveloperTest(){
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
        Assert.assertTrue(MantisbtSite.viewAllBugPage.isBugReportPresented(bugReport));
        List<Integer> ids = MantisbtSite.viewAllBugPage.getBugReportsId(bugReport);
        boolean isBugReportPresented = false;
        for(Integer id : ids){
            MantisbtSite.openBugById(id);
            isBugReportPresented = MantisbtSite.view.isBugReportPresented(bugReport);
            if(isBugReportPresented) {
                bugReport.setId(id);
                break;
            }
        }
        Assert.assertTrue(isBugReportPresented);
    }
}
