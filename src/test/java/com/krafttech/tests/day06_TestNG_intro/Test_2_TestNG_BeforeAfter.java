package com.krafttech.tests.day06_TestNG_intro;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Test_2_TestNG_BeforeAfter {

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

    public void getAttributeTest() {


        driver.get("https://www.krafttechexlab.com/login");
        WebElement form = driver.findElement(By.xpath("//form"));
        System.out.println("form.getAttribute(\"class\") = " + form.getAttribute("class"));
        System.out.println("form.getAttribute(\"novalidate\") = " + form.getAttribute("novalidate"));
        System.out.println("form.getAttribute(\"method\") = " + form.getAttribute("method"));
        System.out.println("form.getAttribute(\"enctype\") = " + form.getAttribute("enctype"));

        System.out.println("form.getTagName() = " + form.getTagName());
        System.out.println("form.getLocation() = " + form.getLocation());
        System.out.println("form.getCssValue(\"font\") = " + form.getCssValue("font"));
        System.out.println("form.getCssValue(\"font-size\") = " + form.getCssValue("font-size"));

        System.out.println("--------------------");

        System.out.println("form.getAttribute(\"innerHTML\") = " + form.getAttribute("innerHTML"));
        System.out.println("-------------------------");

        System.out.println("form.getAttribute(\"outerHTML\") = " + form.getAttribute("outerHTML"));


    }
    @Test
    public void findElements() throws InterruptedException {
/**
 * navigate to https://www.saucedemo.com/
 * locate following three elements with one locater : username box, password box and login button
 * send "standard_user" to username box
 * send "secret_sauce" to password box
 * click Login button
 * then take all product names to a web element list and print the text of elements
 */

    driver.get("https://www.saucedemo.com/");

        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        inputs.get(0).sendKeys("standard_user");
        inputs.get(1).sendKeys("secret_sauce");
        inputs.get(2).click();
        Thread.sleep(2000);

        List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item_name"));

        for (WebElement product : products){
            System.out.println(product.getText());
        }
        System.out.println("--------------------");

        products.forEach(product-> System.out.println(product.getText()));

        System.out.println("---------------------");

        products.forEach(product->{
            System.out.println(product.getText());
        });

    }
}
