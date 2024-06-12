package com.anhdtn.VTCC_KiemTra2.pages;

import org.openqa.selenium.By;
import com.anhdtn.keywords.WebUI;

public class DashboardPage {
    public DashboardPage() {
    }

    public void openPage(String menuName) {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(By.xpath("//span[normalize-space()='" + menuName + "']"));
    }

    public ProductPage openProductPage() {
        WebUI.clickElement(By.xpath("//span[normalize-space()='Products']"));
        return new ProductPage();
    }


}
