package com.krafttech.tests.day05_XPath_and_CSS;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tasks {

    public static void main(String[] args) throws InterruptedException {

        /**
         * http://opencart.abstracta.us/index.php?route=common/home
         * sitesindeki iPhone telefonun add to cart butonuna basacağız
         * ama locator içinde ürünün adı da olacak...
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://opencart.abstracta.us/index.php?route=common/home");
       // //a[text()='iPhone']//ancestor::*[@class='product-thumb transition']//button[.//span]
        //  //a[text()='iPhone']//ancestor::*[@class='product-thumb transition']//button[./i[@class='fa fa-shopping-cart']]
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement addToCart = driver.findElement(By.xpath("//button[@type='button']/ancestor::div[@class='product-thumb transition']//*[text()='iPhone']/../../..//i[@class='fa fa-shopping-cart']"));
        addToCart.click();
        Thread.sleep(2000);
        driver.quit();

    }
}
