package com.krafttech.tests.day03_webelement_intro;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test_02_GetAttributeMethod {
    public static void main(String[] args) throws InterruptedException {

        /**
         * set up a chrome browser and navigate to https://www.krafttechexlab.com/login
         * send "Karalama" text to email box
         * get the written text by using getAttribute() method
         * get the id value by using getAttribute() method
         * verify both
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("Karalama");
        Thread.sleep(2000);

        String actualValue = email.getAttribute("value");
        String expectedValue = "Karalama";

        String actualId = email.getAttribute("id");
        String expectedId = "email";

        if (actualValue.equals(expectedValue)&&actualId.equals(expectedId)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }

driver.quit();
    }
}
