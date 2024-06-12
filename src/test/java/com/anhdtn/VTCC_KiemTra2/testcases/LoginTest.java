package com.anhdtn.VTCC_KiemTra2.testcases;

import com.anhdtn.VTCC_KiemTra2.pages.LoginPage;
import com.anhdtn.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test(priority = 1)
    public void testLoginSuccess() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    //    @BeforeMethod
    public void preConditionVisitCreateCategoriesPage() {
        softAssert = new SoftAssert();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Login website https://cms.anhtester.com/login success
        driver.get("https://cms.anhtester.com/login");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456", Keys.ENTER);

        //Verify url, title when login success
        Assert.assertEquals(driver.getCurrentUrl(), "https://cms.anhtester.com/admin");
        Assert.assertEquals(driver.getTitle(), "Active eCommerce CMS | Anh Tester Demo");

        //Visit the categories tab
        driver.get("https://cms.anhtester.com/admin/categories");

        //Click button Add New category
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[normalize-space()='Category Information']")));

        //Verify screen Create category url
        Assert.assertEquals(driver.getCurrentUrl(), "https://cms.anhtester.com/admin/categories/create");
        Assert.assertTrue(driver.findElement(By.xpath("//h5[normalize-space()='Category Information']")).isDisplayed());
    }
}
