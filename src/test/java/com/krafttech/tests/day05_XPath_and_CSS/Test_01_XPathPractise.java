package com.krafttech.tests.day05_XPath_and_CSS;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test_01_XPathPractise {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        WebElement form = driver.findElement(By.xpath("//form[@class='row g-3 needs-validation']"));
        //form un içindeki bütün textleri yazdırır
        System.out.println("form.getText() = " + form.getText());
        driver.quit();

    }
}
