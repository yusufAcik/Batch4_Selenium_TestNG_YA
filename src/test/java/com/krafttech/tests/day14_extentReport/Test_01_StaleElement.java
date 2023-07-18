package com.krafttech.tests.day14_extentReport;

import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test_01_StaleElement {

    /**
     * go to kraft login page
     * enter your email and pass
     * refresh page
     * enter email and pass again
     * click login
     * enter the web page
     *
     * how to handle stale element problem
     */

    @Test
    public void test1(){

    WebDriver driver=Driver.get();
    driver.manage().window().maximize();
    driver.get(ConfigurationReader.get("url"));

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("yourPassword"));
        WebElement loginBtn=driver.findElement(By.xpath("//*[text()='Login']"));

        email.sendKeys(ConfigurationReader.get("userEmail"));
        password.sendKeys(ConfigurationReader.get("password"));

        driver.navigate().refresh();

        try {
            email.sendKeys(ConfigurationReader.get("userEmail"));
            password.sendKeys(ConfigurationReader.get("password"));
        } catch (Exception e) {
            email = driver.findElement(By.id("email"));
            password = driver.findElement(By.id("yourPassword"));
            loginBtn=driver.findElement(By.xpath("//*[text()='Login']"));

            email.sendKeys(ConfigurationReader.get("userEmail"));
            password.sendKeys(ConfigurationReader.get("password"));
            loginBtn.click();
            e.printStackTrace();
        }

        driver.quit();

    }
}
