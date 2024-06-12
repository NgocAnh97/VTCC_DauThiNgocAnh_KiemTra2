package com.anhdtn.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import com.anhdtn.drivers.DriverManager;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;

    @BeforeMethod
    @Parameters({"browserName"})
    public void createDriver(@Optional("chrome") String browserName) {
        driver = new ChromeDriver();

        DriverManager.setDriver(driver); //Set to ThreadLocal

        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong("60")));
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
