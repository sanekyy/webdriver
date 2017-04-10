package com.spbstu.webdriver.mantisbt;

import com.spbstu.MantisbtSite;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by ihb on 10.04.17.
 */
public class MantisbtTest extends MantisbtBaseTest {

    private String testTime;

    @Test
    public void bugReportTest(){
        testTime = String.valueOf(System.currentTimeMillis());
        MantisbtSite.open();
        MantisbtSite.loginPage.login("administrator", "aQmissyy");
        // не очевидно, что страница сменится на другую, т.е. на myViewPage
        MantisbtSite.myViewPage.openBugReport();
        MantisbtSite.bugReportPage.fillBugReport(testTime);
        MantisbtSite.bugReportPage.submitIssue();
        Assert.assertTrue(MantisbtSite.viewAllBugPage.deleteIssue(testTime));
        MantisbtSite.bugActionGroupPage.confirmRemove();
    }
}
