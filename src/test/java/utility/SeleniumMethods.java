package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DriverManager;
import pages.HomePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class SeleniumMethods {
    WebDriver driver = DriverManager.getDriver();

public void explicitWaits(WebElement element){
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    wait.until(d -> element.isDisplayed());

}

}
