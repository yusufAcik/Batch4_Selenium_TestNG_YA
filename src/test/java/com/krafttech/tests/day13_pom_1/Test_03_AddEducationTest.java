package com.krafttech.tests.day13_pom_1;

import com.krafttech.pages.AddEducationPage;
import com.krafttech.pages.DashboardPage;
import com.krafttech.pages.LoginPage;
import com.krafttech.pages.UserProfilePage;
import com.krafttech.tests.TestBase;
import com.krafttech.utilities.ConfigurationReader;
import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_03_AddEducationTest extends TestBase {

    @Test
    public void addEducationTest(){

        LoginPage loginPage;
        DashboardPage dashboardPage;
        UserProfilePage userProfilePage;
        AddEducationPage addEducationPage;
        /**
         1-open chrome browser
         2-navigate to https://www.krafttechexlab.com/login by using configuration.properties
         3-login with login method
         4-Assert successful login with user name
         5-Navigate to My Profile with related method (navigate tabs and modules method)
         6-Verify that User Profile page is displayed
         7-Navigate to Add Education tab with related method (navigate tabs method)
         8-Verify that add education page is displayed
         9-Fill the form with parameterized login method (using actions class is optional)
         10-Verify that added education information can be seen at overview page...
         11-Delete last added education

         important note: every student should use own credentials, otherwise the test case will fail....
         */

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        userProfilePage=new UserProfilePage();
        addEducationPage=new AddEducationPage();

        loginPage.login();

        String actualUserName = dashboardPage.getElementText(dashboardPage.userName);
        String expectedUserName = ConfigurationReader.get("userName");
        assertEquals(actualUserName,expectedUserName);

        dashboardPage.navigateToTabsAndModules(ConfigurationReader.get("userName"),"My Profile");

        Assert.assertTrue(new WebDriverWait(driver,5).
                until(ExpectedConditions.visibilityOf(userProfilePage.userProfilePageTitle)).isDisplayed());

        userProfilePage.navigateEditProfileTabs("Add Education");

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(addEducationPage.addEducationButton)).isDisplayed());

        //addEducationPage.checkBox.click();

        addEducationPage.fillingEducationForm();

        String actualEducationRecord = userProfilePage.addedEducation("Kraft");
        String expectedEducationRecord="Kraft";

        Assert.assertEquals(actualEducationRecord,expectedEducationRecord);

        userProfilePage.deleteEducationRecord("Kraft");
    }

}
