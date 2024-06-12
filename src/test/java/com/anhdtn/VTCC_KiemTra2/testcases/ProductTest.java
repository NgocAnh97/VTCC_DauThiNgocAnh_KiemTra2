package com.anhdtn.VTCC_KiemTra2.testcases;

import com.anhdtn.VTCC_KiemTra2.pages.DashboardPage;
import com.anhdtn.VTCC_KiemTra2.pages.LoginPage;
import com.anhdtn.VTCC_KiemTra2.pages.ProductPage;
import com.anhdtn.common.BaseTest;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;

    @Test(priority = 1)
    public void testAddProductSuccess() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");

        productPage = dashboardPage.openProductPage();
        productPage.addProduct();

        productPage.verifyAddProductUrl();

        productPage.searchProduct();

        productPage.viewProductDetail();
        productPage.verifyProductDetail();
    }
}
