package com.krafttech.tests.day05_XPath_and_CSS;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test_03_Task {

    public static void main(String[] args) {
       // http://opencart.abstracta.us/index.php?route=common/home

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://opencart.abstracta.us/index.php?route=common/home\n");
        driver.findElement(By.xpath("//a[text()='iPhone']/ancestor::div[@class='product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[@data-original-title=\"Add to Wish List\"]"));
        //button[@*='Add to Wish List' and ./ancestor::*[@class="product-thumb transition"]//*[text()='iPhone']]
        // ürün adını içerecek bir locator la beğen butonunu iki yolla locate ettik

        // krafttech ten aynı şekilde örnek
        //input[@id='email' and ./parent::div]
    }
}
