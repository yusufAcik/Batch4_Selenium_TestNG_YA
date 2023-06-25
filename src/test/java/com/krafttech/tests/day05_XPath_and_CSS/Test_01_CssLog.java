package com.krafttech.tests.day05_XPath_and_CSS;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test_01_CssLog {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input#email")).sendKeys("mgezer@gmail.com"); // lazy way okunurluğu zorlaştırır
        WebElement password = driver.findElement(By.cssSelector("[type='password']"));
        password.sendKeys("Mg12345678"+ Keys.TAB+Keys.TAB+Keys.ENTER);
        Thread.sleep(2000);

       // WebElement loginBttn = driver.findElement(By.cssSelector("button"));
       // loginBttn.click(); // .submit de butona basar

        Thread.sleep(2000);

        driver.quit();
    }

}
