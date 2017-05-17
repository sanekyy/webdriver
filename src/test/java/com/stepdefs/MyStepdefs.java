package com.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

/**
 * Created by ihb on 18.04.17.
 */
public class MyStepdefs implements En {
    public MyStepdefs() {
        Given("^Login as \"([^\"]*)\"$", (String arg0) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        And("^Open Contact Form page$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        When("^Fill form by with \"([^\"]*)\"$", (String arg0) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        And("^Submit Contact Form$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        Then("^Result contains \"([^\"]*)\"$", (String arg0) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
