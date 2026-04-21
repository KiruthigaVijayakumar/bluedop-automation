package tests;

import base.BaseTestFinal;
import pages.LoginPageFinal;
import com.aventstack.extentreports.*;
import utils.ExtentManagerFinal;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTestFinal extends BaseTestFinal {

    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void setupReport() {
        extent = ExtentManagerFinal.getReport();
    }

    @Test
    public void validLoginTest() {

        test = extent.createTest("OrangeHRM Login Test");

        try {
            LoginPageFinal login = new LoginPageFinal(page);

            login.openURL();
            test.info("Opened OrangeHRM login page");

            login.login("Admin", "admin123");
            test.info("Entered credentials");

            // 🔥 Assertion (VERY IMPORTANT)
            String currentUrl = page.url();
            Assert.assertTrue(currentUrl.contains("dashboard"));

            test.pass("Login successful");

        } catch (Exception e) {
            test.fail("Test Failed: " + e.getMessage());
            throw e;
        }
    }

    @AfterMethod
    public void tearDownReport() {
        extent.flush();
    }
}