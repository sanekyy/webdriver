package com.spbstu.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by dmitry on 14.03.17.
 */
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void before() {
        init();
    }

    @AfterMethod
    public void after() throws InterruptedException {
        driver.quit();
    }

    @AfterTest
    public void afterTest() {
        if (driver != null)
            driver.quit();
    }

    protected void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=en-GB"); // for what?
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void reopenDriver() {
        driver.quit();

        init();
    }

}
