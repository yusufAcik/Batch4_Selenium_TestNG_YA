package com.krafttech.tests.day08_Alerts_MultipleWindows;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_01_Alerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void htmlPopUp(){

        /**
         * navigate to https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html
         * click show alert box
         * verify that ok button can be seen on the popup
         * then click ok at the popup
         * verify that ok button cannot be seen
         */
    }
}


