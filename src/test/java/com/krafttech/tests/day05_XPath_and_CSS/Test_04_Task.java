package com.krafttech.tests.day05_XPath_and_CSS;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test_04_Task {

   static WebDriver driver = WebDriverFactory.getDriver("chrome");


    public static void main(String[] args) throws InterruptedException {
        /**
         * navigate to https://demowebshop.tricentis.com/desktops
         * click on Simple Computer Add to cart button by using item name in the locator
         * close driver
         */
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/desktops");

        navigateTabMenu("Jewelry");

        addToCart("Create Your Own Jewelry");
         Thread.sleep(2000);
        driver.quit();


    }

    public static void addToCart(String productName) throws InterruptedException {

        WebElement product = driver.findElement(By.xpath("//a[text()='" +productName+ "']/ancestor::div[@class=\"details\"]//input"));
        product.click();
        Thread.sleep(2000);

    }
    public static void navigateTabMenu(String tabName){
        driver.findElement(By.partialLinkText(tabName)).click();

    }

}
