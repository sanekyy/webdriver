package com.spbstu.webdriver.mantisbt;

import com.spbstu.MantisbtSite;
import com.spbstu.pageObjects.BugReport;
import com.spbstu.webdriver.BaseTest;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ihb on 10.04.17.
 */
public class MantisbtBaseTest extends BaseTest {

    @BeforeMethod
    @Override
    public void before() {
        super.before();

        MantisbtSite.init(driver);
    }

    @Override
    public void reopenDriver() {
        super.reopenDriver();

        MantisbtSite.init(driver);
    }

    protected boolean findBugReport(BugReport bugReport) {
        if (!MantisbtSite.viewAllBugPage.isBugReportPresented(bugReport))
            return false;

        List<Integer> ids;
        if (bugReport.getId() == 0) {
            ids = MantisbtSite.viewAllBugPage.getBugReportIds(bugReport);
        } else {
            ids = new ArrayList<>();
            ids.add(bugReport.getId());
        }
        boolean isPresented = false;
        for (Integer id : ids) {
            MantisbtSite.openBugById(id);
            isPresented = MantisbtSite.view.isBugReportPresented(bugReport);
            if (isPresented) {
                bugReport.setId(id);
                break;
            }
        }
        return isPresented;
    }
}
