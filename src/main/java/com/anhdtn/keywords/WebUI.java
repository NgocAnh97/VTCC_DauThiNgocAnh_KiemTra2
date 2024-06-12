package com.anhdtn.keywords;

import com.anhdtn.drivers.DriverManager;
import com.anhdtn.utils.LogUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WebUI {
    private static int TIMEOUT = 10;

    public static void openURL(String url) {
        DriverManager.getDriver().get(url);
        LogUtils.info("Open Url: " + url);
    }

    public static void logConsole(Object message) {
        LogUtils.info(message);
    }

    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
            LogUtils.info("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void setText(By by, String value) {
        waitForElementVisible(by);
        DriverManager.getDriver().findElement(by).clear();
        DriverManager.getDriver().findElement(by).sendKeys(value);
        LogUtils.info("Set text: " + value + " on element " + by);
    }

    public static void clickElement(By by) {
        waitForElementVisible(by);
        DriverManager.getDriver().findElement(by).click();
        LogUtils.info("Click element: " + by);
    }

    public static String getElementText(By by) {
        waitForElementVisible(by);
        String text = DriverManager.getDriver().findElement(by).getAttribute("value");
        LogUtils.info("Get text of element " + by);
        LogUtils.info("==> Text: " + getWebElement(by).getAttribute("value"));
        return text;
    }

    public static String getCurrentUrl() {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        LogUtils.info("Get Current URL: " + currentUrl);
        return currentUrl;
    }

    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            LogUtils.info("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }

    public static void pressEnterKey(By by) {
        DriverManager.getDriver().findElement(by).sendKeys(Keys.ENTER);
    }
}
