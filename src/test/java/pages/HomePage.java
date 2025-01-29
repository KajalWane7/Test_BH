package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.SeleniumMethods;

public class HomePage {
    WebDriver driver = DriverManager.getDriver();

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    SeleniumMethods seleniumMethods=new SeleniumMethods();

    @FindBy(xpath = "//body/nav//a[@role='button']/span[@class='icon-search bhc-icon-search-rounded']")
    WebElement searchBar;

    @FindBy(xpath = "//body/nav//input[@id='search-field']")
    WebElement searchfield;

    @FindBy(xpath = "//h3[@class='title']")
    WebElement firstSearchResult;

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptCookies;

    public void navigateToBHHomePage() {
        driver.get("https://www.brighthorizons.com/");
        acceptCookies.click();
    }

    public void clickOnSearchIcon() {
       searchBar.click();
    }

    public void verifyIfSearchFieldIsVisibleOnThePage() {
        seleniumMethods.explicitWaits(searchfield);
        Assert.assertTrue(searchfield.isDisplayed());
    }

    public void searchFor(String text) {
       searchfield.sendKeys(text);
        searchfield.sendKeys(Keys.RETURN);
    }

    public void verifyIfTheFirstSearchResultIsExactMatchToWhatYouTypedIntoSearch(String text) {
       //System.out.println(firstSearchResult.getText());
        Assert.assertTrue(firstSearchResult.getText().contains(text));
    }

}
