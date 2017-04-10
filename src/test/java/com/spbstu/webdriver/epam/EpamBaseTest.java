package com.spbstu.webdriver.epam;

import com.spbstu.EpamSite;
import com.spbstu.webdriver.BaseTest;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

/**
 * Created by ihb on 10.04.17.
 */
public class EpamBaseTest extends BaseTest{

    @BeforeMethod
    @Override
    public void beforeMethod(Method method) {
        super.beforeMethod(method);

        EpamSite.init(driver);
    }
}
