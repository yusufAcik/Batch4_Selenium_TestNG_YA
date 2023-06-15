package com.krafttech.tests.day02_webDriverBasics;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Test_03_CallWebDriverFactory {

    public static void main(String[] args) {
        /**
         * set up a chrome driver with WebDriverFactory
         * navigate to https://tr-tr.facebook.com/
         * verify that the url is correct
         */
      WebDriver driver = WebDriverFactory.getDriver("chrome");
      driver.manage().window().maximize();
      driver.get("https://tr-tr.facebook.com/");
      String actualURL = driver.getCurrentUrl();
      String expectedURL = "https://tr-tr.facebook.com/";

      if (actualURL.equals(expectedURL)){
          System.out.println("pass");
      }else {
          System.out.println("fail");
      }
    }
}
