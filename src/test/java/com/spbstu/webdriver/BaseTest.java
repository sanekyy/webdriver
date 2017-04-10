package com.spbstu.webdriver;

import com.spbstu.EpamSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmitry on 14.03.17.
 */
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod(Method method) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=en-GB"); // for what?
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println(String.format("Test method %s has been finished successfully: %s", testResult.getName(), testResult.isSuccess()));
    }

}
