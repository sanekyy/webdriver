package com.spbstu.webdriver.epam;

import com.spbstu.EpamSite;
import com.spbstu.pageObjects.User;
import com.spbstu.webdriver.helper.ResourceLoaderSTU;
import org.testng.annotations.Test;

/**
 * Created by ihb on 10.04.17.
 */
public class EpamTests extends EpamBaseTest {

    @Test
    public void contactFormTest(){
        User user = ResourceLoaderSTU.getEpamUser("admin");

        EpamSite.open();
        EpamSite.homePage.login(user);
        EpamSite.homePage.openContactForm();
        EpamSite.contactFormPage.fillContactForm("Aleksandr", "Yurkovskiy", "qa");
        EpamSite.contactFormPage.submitContactForm();
    }

}