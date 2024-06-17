package com.anhdtn.VTCC_KiemTra2.pages;

import com.anhdtn.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {
    public LoginPage() {
    }

    public DashboardPage loginCRM(String email, String password) {
        WebUI.openURL("https://cms.anhtester.com/login");

        WebUI.setText(emailInput, "admin@example.com");
        WebUI.setText(passwordInput, "123456");
        WebUI.clickElement(loginBtn);

        return new DashboardPage();
    }

    public void verifyLoginSuccess() {
        Assert.assertFalse(WebUI.getCurrentUrl().contains("authentication"), "FAIL. Not login success");
    }

    By emailInput = By.xpath("//input[@id='email']");
    By passwordInput = By.xpath("//input[@id='password']");
    By loginBtn = By.xpath("//button[normalize-space()='Login']");
}
