package com.krafttech.tests.day02_webDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_01_NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        /**
         * set up a chrome driver
         * navigate to https://www.krafttechnologie.com/
         * then navigate to https://www.eurotechstudy.com/en
         * then navigate back
         * then navigate forward
         * then refresh page
         * then close driver
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.krafttechnologie.com/");
        Thread.sleep(2000);
        driver.navigate().to("https://www.eurotechstudy.com/en");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.quit();



    }
}
