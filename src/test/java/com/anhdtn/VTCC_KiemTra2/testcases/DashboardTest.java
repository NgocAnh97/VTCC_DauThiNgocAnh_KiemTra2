package com.anhdtn.VTCC_KiemTra2.testcases;

import com.anhdtn.VTCC_KiemTra2.pages.DashboardPage;
import com.anhdtn.VTCC_KiemTra2.pages.LoginPage;
import com.anhdtn.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 1)
    public void testDashboardPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
    }
}
