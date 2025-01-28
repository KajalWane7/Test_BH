package steps;

import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;

public class Stepdefs {
    HomePage homePage = new HomePage();

    @Given("Open browser")
    public void open_browser() {
        homePage.openBrowser();
    }

    @Given("Navigate to BH home page")
    public void navigate_to_bh_home_page() {
        homePage.navigateToBHHomePage();
    }

    @When("Click on search icon")
    public void click_on_search_icon() {
        homePage.clickOnSearchIcon();
    }

    @Then("Verify if search field is visible on the page")
    public void verify_if_search_field_is_visible_on_the_page() throws InterruptedException {
        homePage.verifyIfSearchFieldIsVisibleOnThePage();
    }

    @Then("Search for {string}")
    public void search_for(String text) throws InterruptedException {homePage.searchFor(text);
    }

    @Then("Verify if the first search result is exact match to what you typed into search {string}")
    public void verifyIfTheFirstSearchResultIsExactMatchToWhatYouTypedIntoSearch(String text) {
        homePage.verifyIfTheFirstSearchResultIsExactMatchToWhatYouTypedIntoSearch(text);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            homePage.takeScreenshot(scenario);
        }
        homePage.closeBrowser();
    }



}




