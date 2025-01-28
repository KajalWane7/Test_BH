package pages;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.SeleniumMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {
    SeleniumMethods seleniumMethods=new SeleniumMethods();

    By searchBar=By.xpath("(//a[@role='button']/span[@class='icon-search bhc-icon-search-rounded'])[2]");
    By searchfield=By.xpath("(//input[@id='search-field'])[2]");
    By firstSearchResult=By.xpath("//h3[@class='title']");
    By acceptCookies=By.id("onetrust-accept-btn-handler");

    public WebDriver driver;

    public void openBrowser() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void navigateToBHHomePage() {
        driver.get("https://www.brighthorizons.com/");
        driver.findElement(acceptCookies).click();
    }

    public void clickOnSearchIcon() {
        driver.findElement(searchBar).click();
        //Actions action = new Actions(driver);
        //action.moveToElement( driver.findElement(searchBar)).click().perform();
    }

    public void verifyIfSearchFieldIsVisibleOnThePage() throws InterruptedException {
        Thread.sleep(50);
        Assert.assertTrue(driver.findElement(searchfield).isDisplayed());
    }

    public void searchFor(String text) throws InterruptedException {
        Thread.sleep(2);
        driver.findElement(searchfield).sendKeys(text);
        driver.findElement(searchfield).sendKeys(Keys.RETURN);
    }

    public void verifyIfTheFirstSearchResultIsExactMatchToWhatYouTypedIntoSearch(String text) {
       System.out.println(driver.findElement(firstSearchResult).getText());
        Assert.assertTrue(driver.findElement(firstSearchResult).getText().contains(text));
    }

    public void closeBrowser() {
        if(driver!=null)
        driver.quit();
    }

    public void takeScreenshot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Screenshot");
    }
}
