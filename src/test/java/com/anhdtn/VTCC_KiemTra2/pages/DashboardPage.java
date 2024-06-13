package com.anhdtn.VTCC_KiemTra2.pages;

import com.anhdtn.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardPage {
    public DashboardPage() {
    }

    public ProductPage openProductPage() {
        WebUI.clickElement(By.xpath("//span[normalize-space()='Products']"));
        return new ProductPage();
    }

    public void verifyDashboardPage() {
        Assert.assertEquals(WebUI.getCurrentUrl(), "https://cms.anhtester.com/admin");
    }
}
