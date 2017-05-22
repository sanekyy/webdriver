package com.spbstu.webdriver.epam;

import com.spbstu.EpamSite;
import com.spbstu.webdriver.BaseTest;
import org.junit.Before;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

/**
 * Created by ihb on 10.04.17.
 */
public class EpamBaseTest extends BaseTest{

    @Before
    @Override
    public void before() {
        super.before();

        EpamSite.init(driver);
    }
}
