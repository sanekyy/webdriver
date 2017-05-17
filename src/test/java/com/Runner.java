package com;

/**
 * Created by ihb on 18.04.17.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ("src/test/java/resources/data/features"),
        glue = ("com.stepdefs")
)
public class Runner {

}
