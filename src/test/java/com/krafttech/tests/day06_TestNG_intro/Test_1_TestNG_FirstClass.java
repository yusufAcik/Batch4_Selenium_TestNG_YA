package com.krafttech.tests.day06_TestNG_intro;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test_1_TestNG_FirstClass {

    /**
     1- Navigate to url:http://zero.webappsecurity.com/index.html
     2- click Signin
     2- Username=username, Password=password
     3- click submit
     4- navigate back
     5- click "Checking Account Activity"
     6- click "Transfer Funds"
     7- Get the value of required attribute of amount box and print it.
     8- click continue button
     9- try to get the message of warning which appers on the amount box...("Lütfen bu alanı doldurun") if u can, print it too...
     */

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/index.html");
        driver.findElement(By.cssSelector("#signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        Thread.sleep(2000);
        driver.findElement(By.id("user_password")).sendKeys("password");
        Thread.sleep(2000);
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.findElement(By.id("account_activity_link")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Transfer Funds")).click();
        Thread.sleep(2000);

        WebElement amountBox = driver.findElement(By.id("tf_amount"));
        System.out.println("amountBox.getAttribute(\"required\") = " + amountBox.getAttribute("required"));

        // boolean bl = Boolean.parseBoolean("true");  true yu boolean a çevirme

        driver.findElement(By.cssSelector("#btn_submit")).click();
        Thread.sleep(2000);

        System.out.println("amountBox.getAttribute(\"validationMessage\") = " + amountBox.getAttribute("validationMessage"));

        driver.close();


    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/index.html");
        driver.findElement(By.cssSelector("#signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        Thread.sleep(2000);
        driver.findElement(By.id("user_password")).sendKeys("password");
        Thread.sleep(2000);
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.findElement(By.id("account_activity_link")).click();
        Thread.sleep(2000);


        String [] tabs = { "Account Summary","Account Activity","Transfer Funds","Pay Bills","My Money Map","Online Statements"};

        for (int i = 0; i < tabs.length; i++) {
            driver.findElement(By.linkText(tabs[i])).click();
            Thread.sleep(2000);
        }

        driver.close();


    }

}
