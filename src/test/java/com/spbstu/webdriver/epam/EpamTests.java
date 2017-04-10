package com.spbstu.webdriver.epam;

import com.spbstu.EpamSite;
import com.spbstu.webdriver.BaseTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by ihb on 10.04.17.
 */
public class EpamTests extends EpamBaseTest {

    @Test
    public void contactFormTest(){
        EpamSite.open();
        EpamSite.homePage.login("epam", "1234");
        EpamSite.homePage.openContactForm();
        EpamSite.contactFormPage.fillContactForm("Aleksandr", "Yurkovskiy", "qa");
        EpamSite.contactFormPage.submitContactForm();
    }

}