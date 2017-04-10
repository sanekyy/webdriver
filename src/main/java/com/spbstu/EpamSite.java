package com.spbstu;

import com.spbstu.pageObjects.epam.ContactFormPage;
import com.spbstu.pageObjects.epam.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ihb on 10.04.17.
 */
public class EpamSite {

    public static ContactFormPage contactFormPage;
    public static HomePage homePage;
    private static WebDriver driver;

    public static void init(WebDriver driver){
        EpamSite.contactFormPage = PageFactory.initElements(driver, ContactFormPage.class);
        EpamSite.homePage = PageFactory.initElements(driver, HomePage.class);
        EpamSite.driver = driver;
    }

    public static void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }
}
