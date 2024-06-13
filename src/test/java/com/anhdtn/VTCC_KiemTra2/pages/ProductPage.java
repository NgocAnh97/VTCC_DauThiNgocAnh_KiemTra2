package com.anhdtn.VTCC_KiemTra2.pages;

import com.anhdtn.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Random;

public class ProductPage {
    public ProductPage() {
    }

    Random random = new Random();
    String productName = "gpt" + random.nextInt();
    String unit = "kg";
    String minQty = "1";
    String productTag = "Product Tag";
    String unitPrice = "88888.88";
    String discount = "1000.00";
    String quantity = "1";

    public void addProduct() {
        WebUI.clickElement(By.xpath("//span[normalize-space()='Add New Product']"));
        WebUI.setText(By.xpath("//input[@placeholder='Product Name']"), productName);
        WebUI.clickElement(By.xpath("//button[@data-id='category_id']"));
        WebUI.setText(By.xpath("//input[@name='unit']"), unit);

        WebUI.clickElement(By.xpath("//div[@class='bs-searchbox']/following-sibling::div//li[3]"));
        WebUI.setText(By.xpath("//input[@name='min_qty']"), minQty);
        WebUI.setText(By.xpath("//span[@class='tagify__input']"), productTag);

        WebUI.setText(By.xpath("//input[@placeholder='Unit price']"), unitPrice);
        WebUI.setText(By.xpath("//input[@placeholder='Discount']"), discount);
        WebUI.setText(By.xpath("//input[@placeholder='Quantity']"), quantity);

        WebUI.clickElement(By.xpath("//button[@value='publish']"));
    }

    public void verifyAddProductUrl() {
        Assert.assertEquals(WebUI.getCurrentUrl(), "https://cms.anhtester.com/admin/products/admin");
    }

    public void searchProduct() {
        WebUI.openURL("https://cms.anhtester.com/admin/products/admin");
        WebUI.setText(By.id("search"), productName);
        WebUI.pressEnterKey(By.id("search"));
    }

    public void verifySearchProductUrl() {
        Assert.assertEquals(WebUI.getCurrentUrl(), "https://cms.anhtester.com/admin/products/admin?type=&search=" + productName);
    }

    public void viewProductDetail() {
        WebUI.clickElement(By.xpath("//a[@title='View']"));
    }

    public void verifyViewProductDetail() {
        WebUI.switchToWindowTab();
        Assert.assertEquals(WebUI.getCurrentUrl(), "https://cms.anhtester.com/product/" + productName);

        WebUI.clickElement(By.xpath("//button[@data-key='website-popup']"));

        Assert.assertEquals(WebUI.getElementText(By.xpath("//h1[@class='mb-2 fs-20 fw-600']")), productName);
    }

    public void editProductDetail() {
        WebUI.switchToMainWindow();
        WebUI.clickElement(By.xpath("//a[@title='Edit']"));
        verifyEditProductScreen();
    }

    public void verifyEditProductScreen() {
        Assert.assertEquals(WebUI.getElementValue(By.xpath("//input[@placeholder='Product Name']")), productName);

        Assert.assertEquals(WebUI.getElementValue(By.xpath("//input[@name='unit']")), unit);
        Assert.assertEquals(WebUI.getElementValue(By.xpath("//input[@name='min_qty']")), minQty);
        Assert.assertEquals(WebUI.getElementValue(By.xpath("//tag[@title='Product Tag']")), productTag);
        Assert.assertEquals(WebUI.getElementValue(By.xpath("//input[@placeholder='Unit price']")), unitPrice);
        Assert.assertEquals(WebUI.getElementValue(By.xpath("//input[@placeholder='Discount']")), discount);
        Assert.assertEquals(WebUI.getElementValue(By.xpath("//input[@placeholder='Quantity']")), quantity);
    }
}
