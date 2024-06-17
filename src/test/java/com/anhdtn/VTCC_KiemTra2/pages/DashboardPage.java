package com.anhdtn.VTCC_KiemTra2.pages;

import com.anhdtn.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardPage {
    public DashboardPage() {
    }

    public ProductPage openProductPage() {
        WebUI.clickElement(productTab);
        return new ProductPage();
    }

    public void verifyDashboardPage() {
        Assert.assertEquals(WebUI.getCurrentUrl(), "https://cms.anhtester.com/admin");
    }

    By productTab = By.xpath("//span[normalize-space()='Products']");
}
