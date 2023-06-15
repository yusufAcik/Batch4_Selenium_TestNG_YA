package com.krafttech.tests.day03_webelement_intro;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test_03_TakeTheMessage {
    public static void main(String[] args) throws InterruptedException {

        /**
         * set up a chrome driver and navigate to http://ourvirtualmarket.com/
         * then close pop up
         * click login link
         * send "fdsddss" to email box
         * then click login
         * then take the message that appears on email box and print the message
         * use lazy way with this task
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://ourvirtualmarket.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement closeBttn = driver.findElement(By.className("popup-close"));
        closeBttn.click();
        Thread.sleep(2000);

        WebElement loginBttn = driver.findElement(By.className("link-lg"));
        loginBttn.click();
        Thread.sleep(2000);

        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys("asfdsf");
        Thread.sleep(2000);

        WebElement loginBttn1 = driver.findElement(By.id("send2"));
        Thread.sleep(2000);
        loginBttn1.click();

        Thread.sleep(1000);
        String message = driver.switchTo().alert().getText();
        System.out.println(message);


    }
}
