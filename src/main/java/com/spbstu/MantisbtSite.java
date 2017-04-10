package com.spbstu;

import com.spbstu.pageObjects.mantisbt.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ihb on 10.04.17.
 */
public class MantisbtSite {
    public static LoginPage loginPage;
    public static MyViewPage myViewPage;
    public static BugReportPage bugReportPage;
    public static ViewAllBugPage viewAllBugPage;
    public static BugActionGroupPage bugActionGroupPage;

    private static WebDriver driver;

    public static void init(WebDriver driver){
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        myViewPage = PageFactory.initElements(driver, MyViewPage.class);
        bugReportPage = PageFactory.initElements(driver, BugReportPage.class);
        viewAllBugPage = PageFactory.initElements(driver, ViewAllBugPage.class);
        bugActionGroupPage = PageFactory.initElements(driver, BugActionGroupPage.class);

        MantisbtSite.driver = driver;
    }

    public static void open() {
        driver.navigate().to("http://localhost/mantisbt/login_page.php");
    }
}
