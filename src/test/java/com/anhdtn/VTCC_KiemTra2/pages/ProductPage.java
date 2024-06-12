package com.anhdtn.VTCC_KiemTra2.pages;

import com.anhdtn.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductPage {
    public ProductPage() {
    }

    String productName = "Flower";
    String unit = "kg";
    String minQty = "2";
    String productTag = "Product Tag";
    String unitPrice = "88000.88";
    String discount = "8000.88";
    String quantity = "8";

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

        WebUI.clickElement(By.xpath("//button[@value='unpublish']"));
    }

    public void verifyAddProductUrl() {
        Assert.assertEquals(WebUI.getCurrentUrl(), "https://cms.anhtester.com/admin/products/admin");
    }

    public void searchProduct() {
        WebUI.openURL("https://cms.anhtester.com/admin/products/admin");
        WebUI.setText(By.id("search"), productName);
        WebUI.pressEnterKey(By.id("search"));
    }

    public void viewProductDetail() {
        WebUI.clickElement(By.xpath("//a[@title='Edit']"));
        verifyProductDetail();
    }

    public void verifyProductDetail() {
        Assert.assertEquals(WebUI.getElementText(By.xpath("//input[@placeholder='Product Name']")), productName);

        Assert.assertEquals(WebUI.getElementText(By.xpath("//input[@name='unit']")), unit);
        Assert.assertEquals(WebUI.getElementText(By.xpath("//input[@name='min_qty']")), minQty);
        Assert.assertEquals(WebUI.getElementText(By.xpath("//tag[@title='Product Tag']")), productTag);
        Assert.assertEquals(WebUI.getElementText(By.xpath("//input[@placeholder='Unit price']")), unitPrice);
        Assert.assertEquals(WebUI.getElementText(By.xpath("//input[@placeholder='Discount']")), discount);
        Assert.assertEquals(WebUI.getElementText(By.xpath("//input[@placeholder='Quantity']")), quantity);
    }
}
