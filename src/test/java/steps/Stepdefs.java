package steps;

import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.DriverManager;
import pages.FindCenterPage;
import pages.HomePage;

public class Stepdefs {
    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage();
    FindCenterPage findCenterPage=new FindCenterPage();
    Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
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
    public void verify_if_search_field_is_visible_on_the_page() {
        homePage.verifyIfSearchFieldIsVisibleOnThePage();
    }

    @Then("Search for {string}")
    public void search_for(String text) {homePage.searchFor(text);
    }

    @Then("Verify if the first search result is exact match to what you typed into search {string}")
    public void verifyIfTheFirstSearchResultIsExactMatchToWhatYouTypedIntoSearch(String text) {
        homePage.verifyIfTheFirstSearchResultIsExactMatchToWhatYouTypedIntoSearch(text);
    }

    @When("Click on Find a Center option")
    public void clickOnFindACenterOption() {
        findCenterPage.clickOnFindACenterOption();
        takeScreenshot();
    }

    @Then("Verify that {string} as a part of its URL")
    public void verifyThatAsAPartOfItsURL(String locator) {
        findCenterPage.verifylocatorAsAPartOfItsURL(locator);
    }

    @And("Search location as  {string}")
    public void searchLocationAs(String location) throws InterruptedException {
        findCenterPage.searchLocation(location);
    }

    @Then("verify if a number of found centers is the same as a number of centers displayed in the list")
    public void verifyIfANumberOfFoundCentersIsTheSameAsANumberOfCentersDisplayedInTheList() {
        findCenterPage.verifyNumber();
    }

    @Then("Click on the first center on the list")
    public void clickOnTheFirstCenterOnTheList() {
        findCenterPage.ClickFirstCenter();
    }

    @Then("Verify whether the center name and the address are the same in the list and in the popup")
    public void verifyWhetherTheCenterNameAndTheAddressAreTheSameInTheListAndInThePopup() {
        findCenterPage.verifyCenterNameAndAddress();
    }
    public void takeScreenshot() {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Screenshot");
    }

    @After
    public void tearDown() {
        if (scenario != null && scenario.isFailed()) {
            takeScreenshot();
        }
        DriverManager.quitDriver();
    }
}




