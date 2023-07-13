package com.krafttech.tests.day13_pom_1;

import com.krafttech.pages.BasePage;
import com.krafttech.pages.DashboardPage;
import com.krafttech.pages.LoginPage;
import com.krafttech.tests.TestBase;
import com.krafttech.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_2_NavigateTabAndModuleTest extends TestBase {

    @Test
    public void navigateTest(){
        LoginPage loginPage = new LoginPage();

        loginPage.login();

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToTabsAndModules("Developers","");

        String expectedUrl = "https://www.krafttechexlab.com/developers";
        String actualUrl= Driver.get().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        dashboardPage.navigateToTabsAndModules("Dashboard","");

        dashboardPage.navigateToTabsAndModules("JavaScript","Draggable");

        String expectedUrl2="https://www.krafttechexlab.com/javascript/draggable";
        String actualUrl2=Driver.get().getCurrentUrl();

        Assert.assertEquals(actualUrl2,expectedUrl2);
    }


}
