package com.app.tests;
import com.app.pages.HomePage;
import com.app.pages.SearchCruisesPage;
import com.google.inject.Inject;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class FindCruiseStepDef {
	 @Inject
	 HomePage homePage;

	@Inject
	 SearchCruisesPage searchCruisesPage;
	 
	 
	@When("^I launch the Princess cruise application$")
	public void i_launch_the_Princess_cruise_application() throws Throwable {
		homePage.goToHomePage();
	}

	@Then("^Application shuold be launched successfully$")
	public void application_shuold_be_launched_successfully() throws Throwable {
	    homePage.VerifyHomePageTitle("Cruises – Cruise Vacations – Princess Cruises");
	}

	@When("^I move the mouse on the Plan A Cruises$")
	public void i_move_the_mouse_on_the_Plan_A_Cruises() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    homePage.mouseHourOnThePlanACruise();
	}

	@Then("^Plan and Book a cruise section should apper as result$")
	public void plan_and_Book_a_cruise_section_should_apper_as_result() throws Throwable {
	    homePage.VerifyFindCruisLink();
	}

	@When("^I click on the Find Cruises link$")
	public void i_click_on_the_Find_Cruises_link() throws Throwable {
	  homePage.ClickFindCruisLink();
	}

	@Then("^Search Cruises grid section should open as a result$")
	public void search_Cruises_grid_section_should_open_as_a_result() throws Throwable {
		searchCruisesPage.VerifyCruiseHeader();
	}

	@When("^I select the Destination as \"([^\"]*)\"$")
	public void i_select_the_Destination_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		searchCruisesPage.selectDestination(arg1);
	}

	@When("^select the Daparture as \"([^\"]*)\"$")
	public void select_the_Daparture_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		searchCruisesPage.selectDeparturePort(arg1);
	}

	@When("^select the Length of the cruise as \"([^\"]*)\"$")
	public void select_the_Length_of_the_cruise_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		searchCruisesPage.selectDuration(arg1);
	}
	
	
	@When("^Select a month from the calendar$")
	public void select_a_month_from_the_calendar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		searchCruisesPage.clickOnTheMonth();
	}

	@When("^click on the view result button$")
	public void click_on_the_view_result_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		searchCruisesPage.clickOnViewResults();
	}

	@Then("^Filters Cruiser details should display as result$")
	public void filters_Cruiser_details_should_display_as_result() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		searchCruisesPage.verifyCruiseResult();
	}

	@Then("^Available dates should be displayed on the table$")
	public void available_dates_should_be_displayed_on_the_table() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		searchCruisesPage.verifyCruiseAvailbleDates();
	}


}
