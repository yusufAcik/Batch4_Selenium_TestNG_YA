package com.krafttech.tests.day12_singleton_properties;
import  com.krafttech.utilities.Driver;
import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



import static java.sql.Driver.*;

public class SingletonTest_2 {

    @Test
    public void test1(){
       /* WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver= Driver.get();
        driver.get("https://www.google.com.tr");
        */ // bu şekilde ayrı driverlar açar
        Driver.get().get("https://www.google.com.tr");
    }

    @Test
    public void test2(){
       /* WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com.tr");*/ // bu şekilde ayrı driverlar açar
        Driver.get().get("https://www.amazon.com.tr");
    }
}
