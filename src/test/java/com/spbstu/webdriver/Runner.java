package com.spbstu.webdriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/data/mantisbt/features",
        glue = "com.spbstu.webdriver.stepDefs",
        format = "json:target/reports/mainReport.json"
)
public class Runner extends BaseTest {

}