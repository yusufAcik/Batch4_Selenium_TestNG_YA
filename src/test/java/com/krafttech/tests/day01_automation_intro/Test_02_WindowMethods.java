package com.krafttech.tests.day01_automation_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_02_WindowMethods {
    public static void main(String[] args) throws InterruptedException {

        // kod aktarmak için altgr+, tuşuna basıp üçer tırnak arasına
        // kodlarımızı yazarsak bozulma olmaz

       // ```url```

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.krafttechnologie.com/");
       // driver.manage().window().maximize();

        // ekran ölçülerini alalım
        Dimension size = driver.manage().window().getSize();
        System.out.println("size = " + size);

        // driver ın pointini alma -- açılan driver penceresinin
        // sol üst noktasının pixelini verir

        Point position = driver.manage().window().getPosition();
        System.out.println("position = " + position);

        // position ayarlama - vererek ekranlar arası yer değişikliği yapabiliriz
        driver.manage().window().setPosition(new Point(120,20));

        // driverın boyutunu ayarlama
        driver.manage().window().setSize(new Dimension(800,600));
        Thread.sleep(3000);
        driver.close();



    }
}
