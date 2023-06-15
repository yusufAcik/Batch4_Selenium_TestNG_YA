package com.krafttech.tests.day01_automation_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_01_OpenBrowser {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //driver.get("https://www.google.com");
        driver.get("https://facebook.com");
        // https şart www olmazsa olur

        // sayfanın title ını alalım
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Giriş Yap veya Kaydol";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }

        driver.close();


    }
}
