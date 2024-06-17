package com.anhdtn.VTCC_KiemTra2.pages;

import com.anhdtn.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Random;

public class ProductPage {
    public ProductPage() {
    }

    public void addProduct() {
        clickToAddProduct();
        inputProductName(productName);
        clickToCategoryId();
        inputUnit(unit);

        clickToSearchBox();
        inputMinQty(minQty);
        inputProductTag(productTag);

        inputUnitPrice(unitPrice);
        inputDiscount(discount);
        inputQuantity(quantity);
        clickToPublish();
    }

    private void inputMinQty(String minQty) {
        WebUI.setText(minQtyInput, minQty);
    }

    private void inputProductTag(String productTag) {
        WebUI.setText(productTagInput, productTag);
    }

    private void inputUnitPrice(String unitPrice) {
        WebUI.setText(unitPriceInput, unitPrice);
    }

    private void inputDiscount(String discount) {
        WebUI.setText(discountInput, discount);
    }

    private void inputQuantity(String quantity) {
        WebUI.setText(quantityInput, quantity);
    }

    private void clickToPublish() {
        WebUI.clickElement(publishBtn);
    }

    public void verifyAddProductUrl() {
        Assert.assertEquals(WebUI.getCurrentUrl(), "https://cms.anhtester.com/admin/products/admin");
    }

    public void searchProduct() {
        WebUI.openURL("https://cms.anhtester.com/admin/products/admin");
        WebUI.setText(searchProductInput, productName);
        WebUI.pressEnterKey(searchProductInput);
    }

    public void verifySearchProductUrl() {
        Assert.assertEquals(WebUI.getCurrentUrl(), "https://cms.anhtester.com/admin/products/admin?type=&search=" + productName);
    }

    public void viewProductDetail() {
        WebUI.clickElement(viewProductBtn);
    }

    public void verifyViewProductDetail() {
        WebUI.switchToWindowTab();
        Assert.assertEquals(WebUI.getCurrentUrl(), "https://cms.anhtester.com/product/" + productName);

        WebUI.clickElement(closePopupBtn);

        Assert.assertEquals(WebUI.getElementText(productNameTitle), productName);
    }

    public void editProductDetail() {
        WebUI.switchToMainWindow();
        WebUI.clickElement(editProductBtn);
        verifyEditProductScreen();
    }

    public void verifyEditProductScreen() {
        Assert.assertEquals(WebUI.getElementValue(productNameInput), productName);

        Assert.assertEquals(WebUI.getElementValue(unitInput), unit);
        Assert.assertEquals(WebUI.getElementValue(minQtyInput), minQty);
        Assert.assertEquals(WebUI.getElementValue(productTagEditInput), productTag);
        Assert.assertEquals(WebUI.getElementValue(unitPriceInput), unitPrice);
        Assert.assertEquals(WebUI.getElementValue(discountInput), discount);
        Assert.assertEquals(WebUI.getElementValue(quantityInput), quantity);
    }

    private void clickToAddProduct() {
        WebUI.clickElement(addProductBtn);
    }

    private void inputProductName(String productName) {
        WebUI.setText(productNameInput, productName);
    }

    private void clickToCategoryId() {
        WebUI.clickElement(categoryIdBtn);
    }

    private void inputUnit(String unit) {
        WebUI.setText(unitInput, unit);
    }

    private void clickToSearchBox() {
        WebUI.clickElement(searchBoxBtn);
    }

    Random random = new Random();
    String productName = "gpt" + random.nextInt();
    String unit = "kg";
    String minQty = "1";
    String productTag = "Product Tag";
    String unitPrice = "88888.88";
    String discount = "1000.00";
    String quantity = "1";

    By addProductBtn = By.xpath("//span[normalize-space()='Add Product']");
    By productNameInput = By.xpath("//input[@placeholder='Product Name']");
    By categoryIdBtn = By.xpath("//button[@data-id='category_id']");
    By unitInput = By.xpath("//input[@name='unit']");
    By searchBoxBtn = By.xpath("//div[@class='bs-searchbox']/following-sibling::div//li[3]");
    By minQtyInput = By.xpath("//input[@name='min_qty']");
    By productTagInput = By.xpath("//span[@class='tagify__input']");
    By unitPriceInput = By.xpath("//input[@placeholder='Unit price']");
    By discountInput = By.xpath("//input[@placeholder='Discount']");
    By quantityInput = By.xpath("//input[@placeholder='Quantity']");
    By publishBtn = By.xpath("//button[@value='publish']");

    By searchProductInput = By.id("search");
    By viewProductBtn = By.xpath("//a[@title='View']");
    By closePopupBtn = By.xpath("//button[@data-key='website-popup']");
    By productNameTitle = By.xpath("//h1[@class='mb-2 fs-20 fw-600']");
    By editProductBtn = By.xpath("//a[@title='Edit']");

    By productTagEditInput = By.xpath("//tag[@title='Product Tag']");
}
