package tests;

import base.BaseTestFinal;
import pages.LoginPageFinal;
import com.aventstack.extentreports.*;
import utils.ExtentManagerFinal;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTestFinal extends BaseTestFinal{
	
	ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void setupReport() {
        extent = ExtentManagerFinal.getReport();
    }

    @Test
    public void validLoginTest() {

        test = extent.createTest("Bluedop Login Test");

        try {
            LoginPageFinal login = new LoginPageFinal(page);

            login.openURL();
            test.info("Opened Bluedop login page");

            login.login("BlueDopAdmin", "BDAdmin@4321");
            test.info("Entered username and password");

            test.pass("Login test executed");

        } catch (Exception e) {
            test.fail("Test Failed: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDownReport() {
        extent.flush();   // 🔥 THIS CREATES HTML FILE
    }
}