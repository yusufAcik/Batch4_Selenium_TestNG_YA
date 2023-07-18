package com.krafttech.tests.day15_extentReport_cont;

import com.krafttech.pages.LoginPage;
import com.krafttech.tests.TestBase;
import com.krafttech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_02_LoginTestWithExtentLogger extends TestBase {

    @Test
    public void positiveLoginTest_1(){

        extentLogger=report.createTest("TC001 Login Test");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Navigate to "+ConfigurationReader.get("url"));
        extentLogger.info("Login with valid credentials");

        loginPage.userEmailBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn.click();

        extentLogger.info("verify success login with url");

        String expectedUrl = "https://www.krafttechexlab.com/index";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
    }
}
