package com.anhdtn.VTCC_KiemTra2.pages;

import com.anhdtn.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class LoginPage {
    public LoginPage() {}

    public DashboardPage loginCRM(String email, String password) {
        WebUI.openURL("https://cms.anhtester.com/login");

        WebUI.setText(By.xpath("//input[@id='email']"),"admin@example.com");
        WebUI.setText(By.xpath("//input[@id='password']"),"123456");
        WebUI.clickElement(By.xpath("//button[normalize-space()='Login']"));

        return new DashboardPage();
    }

    public void verifyLoginSuccess() {
        Assert.assertFalse(WebUI.getCurrentUrl().contains("authentication"), "FAIL. Not login success");
    }
}
