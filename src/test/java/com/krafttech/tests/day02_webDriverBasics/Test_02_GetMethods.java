package com.krafttech.tests.day02_webDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_02_GetMethods {
    public static void main(String[] args) {

        /**
         * set up a chrome driver
         * navigate to https://www.hepsiburada.com/
         * get title and get url
         * verify that title, url and Page source codes  contain "hepsiburada"
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hepsiburada.com/");
        String title=driver.getTitle();
        System.out.println("title = " + title);
        String url=driver.getCurrentUrl();
        System.out.println("url = " + url);
        String source=driver.getPageSource();
        //System.out.println("source = " + source);
        // tarayıcıda ctrl+u bütün kodları gösterir

        if (title.toLowerCase().contains("hepsiburada")&&url.toLowerCase().contains("hepsiburada")&&source.toLowerCase().contains("hepsiburada")){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
        driver.quit();



    }
}
