package com.app.tests;

import com.app.pages.HomePage;
import com.app.pages.TestPage;
import com.app.steps.ApplicationSteps;
import com.app.steps.SearchSteps;
import com.google.inject.Inject;

import cucumber.api.java.en.When;


/**
 * Created by Yuvarej on 28/05/2016.
 */
public class TestStepDef {

    @Inject
    HomePage searchSteps;

    @Inject
    TestPage testpage;

    @When("^I launch the google application$")
    public void i_launch_the_google_application() throws Throwable {

        searchSteps.goToHomePage();
    }

    @When("^I click on the Gmail link$")
    public void i_click_on_the_Gmail_link() throws Throwable {

        testpage.ClickGmailLink();
    }


}
