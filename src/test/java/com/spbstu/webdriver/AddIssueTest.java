package com.spbstu.webdriver;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by ihb on 25.03.17.
 */
public class AddIssueTest extends BaseTest {


    @Test
    public void test1() throws InterruptedException {




        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost/mantisbt/view_all_bug_page.php"));

    }
}
