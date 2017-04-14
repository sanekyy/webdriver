package com.spbstu.webdriver.mantisbt;

import com.spbstu.MantisbtSite;
import com.spbstu.webdriver.BaseTest;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

/**
 * Created by ihb on 10.04.17.
 */
public class MantisbtBaseTest extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod(Method method) {
        super.beforeMethod(method);

        MantisbtSite.init(driver);
    }

    @Override
    public void reopenDriver() {
        super.reopenDriver();

        MantisbtSite.init(driver);
    }
}
