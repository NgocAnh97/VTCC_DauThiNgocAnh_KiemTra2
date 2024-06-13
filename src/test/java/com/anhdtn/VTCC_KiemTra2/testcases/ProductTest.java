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
    String username = "admin@example.com";
    String password = "123456";

    @Test(priority = 1)
    public void testAddViewEditProductSuccess() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(username, password);

        productPage = dashboardPage.openProductPage();
        productPage.addProduct();

        productPage.verifyAddProductUrl();

        productPage.searchProduct();
        productPage.verifySearchProductUrl();

        productPage.viewProductDetail();
        productPage.verifyViewProductDetail();

        productPage.editProductDetail();
        productPage.verifyEditProductScreen();
    }
}
