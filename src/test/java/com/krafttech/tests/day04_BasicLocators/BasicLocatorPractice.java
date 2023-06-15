package com.krafttech.tests.day04_BasicLocators;

import com.github.javafaker.Faker;
import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicLocatorPractice {
    public static void main(String[] args) throws InterruptedException {
        /**
         * task
         * open a chrome browser
         * navigate to https://www.krafttechexlab.com/login
         * locate email box with id and send a full name by using java faker to the box
         * locate email box with name and clear current name and send a new full name by using java faker to the box
         * locate login button with tag name and click the button
         * locate Remember me element with class name and get the text of element and print it
         * locate Create an account link with link text and click it
         * locate Log in link with partial link text with "Log" text and click it
         */
        Faker faker = new Faker();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.navigate().to("https://www.krafttechexlab.com/login");
        Thread.sleep(1000);
        WebElement emailBox = driver.findElement(By.id("email"));
        Thread.sleep(1000);
        emailBox.sendKeys(faker.name().fullName());
        Thread.sleep(1000);
        WebElement emailBox2 = driver.findElement(By.name("email"));
        Thread.sleep(1000);
        emailBox2.clear();
        Thread.sleep(1000);
        emailBox2.sendKeys(faker.name().nameWithMiddle());
        Thread.sleep(1000);
        WebElement button = driver.findElement(By.tagName("button"));
        Thread.sleep(1000);
        button.click();
        Thread.sleep(1000);
        WebElement rememberMe = driver.findElement(By.className("form-check-label"));
        Thread.sleep(1000);
        System.out.println("rememberMe.getText() = " + rememberMe.getText());

        WebElement createAnAccount = driver.findElement(By.linkText("Create an account"));
        createAnAccount.click();

        WebElement logInLink = driver.findElement(By.partialLinkText("Log"));
        logInLink.click();

        driver.quit();

    }
}
