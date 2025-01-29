package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.SeleniumMethods;

import java.util.Set;

public class FindCenterPage {
    WebDriver driver = DriverManager.getDriver();

    public FindCenterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/nav/div//li[@class='nav-item displayed-desktop']//a[contains(text(),'Find a Center')]")
    WebElement findCenter;

    @FindBy(xpath = "//input[@id='addressInput']")
    WebElement addressInput;

    @FindBy(xpath = "//span[@class='resultsNumber']")
    WebElement number;

    @FindBy(xpath = "//div[contains(@data-center-select-tracking,'Bright Horizons at 20 Pine')]//h3")
    WebElement numbetOnList;

    @FindBy(xpath = "//div[contains(@data-center-select-tracking,'Center Result')]")
    WebElement clickFirstCenter;

    @FindBy(xpath = "//div[contains(@data-center-select-tracking,'Center Result')]//h3")
    WebElement centerNameOnList;

    @FindBy(xpath = "//div[contains(@data-center-select-tracking,'Center Result')]//span[2]")
    WebElement addressOnList;

    @FindBy(xpath = "//span[@class='mapTooltip__headline']")
    WebElement  centerNameOnMap;

    @FindBy(xpath = "//div[@class='mapTooltip__address']")
    WebElement addressNameOnMap;

    SeleniumMethods seleniumMethods=new SeleniumMethods();

    public void clickOnFindACenterOption() {
        findCenter.click();
        String mainWindow=driver.getWindowHandle();
        Set<String> allWindows=driver.getWindowHandles();
        for(String handle:allWindows){
            if(!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
            }
        }
    }

    public void verifylocatorAsAPartOfItsURL(String locator) {
        driver.getTitle().contains(locator);
    }

    public void searchLocation(String location) throws InterruptedException {
        addressInput.click();
        addressInput.sendKeys(location);
        Thread.sleep(1000);
        addressInput.sendKeys(Keys.ENTER);
        addressInput.sendKeys(Keys.RETURN);
        addressInput.click();
    }

    public void verifyNumber() {
        seleniumMethods.explicitWaits(numbetOnList);
        Assert.assertEquals("Number",number.getText(),numbetOnList.getText().replaceAll("[^0-9]", ""));
    }

    public void ClickFirstCenter() {
        clickFirstCenter.click();
    }

    public void verifyCenterNameAndAddress() {
        seleniumMethods.explicitWaits(centerNameOnMap);
        Assert.assertEquals("name",centerNameOnList.getText(),centerNameOnMap.getText());
        Assert.assertEquals("Address",addressOnList.getText().replaceAll("[^a-zA-Z0-9 ]","").replaceAll(" ",""),addressNameOnMap.getText().replaceAll("[^a-zA-Z0-9 ]","").replaceAll(" ",""));
    }
}
