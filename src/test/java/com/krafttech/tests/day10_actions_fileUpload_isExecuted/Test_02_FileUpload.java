package com.krafttech.tests.day10_actions_fileUpload_isExecuted;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Test_02_FileUpload {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    //https://demoqa.com/upload-download
    @Test
    public void fileUpload(){
        driver.get("https://demoqa.com/upload-download");
        WebElement uploadFile = driver.findElement(By.cssSelector("#uploadFile"));
        uploadFile.sendKeys("C:\\Users\\ASUS\\Desktop\\bbb.txt");

        String fileName = "bbb.txt";
        WebElement uploadedFileName = driver.findElement(By.id("uploadedFilePath"));

        Assert.assertTrue(uploadedFileName.getText().contains(fileName));

    }
@Test
    public void systemProperties(){
    Properties properties = System.getProperties();
    properties.list(System.out);

    System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
    System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
    System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
    //proje ismi üzerinde sağ tık open in explorer dersek projenin bulunduğu dosyayı açar
    //C:\Users\ASUS\IdeaProjects\Batch4_Selenium_TestNG_YA
    //C:\Users\ASUS\IdeaProjects\Batch4_Selenium_TestNG_YA

}
    @Test
    public void fileUpload2(){
        driver.get("https://demoqa.com/upload-download");

        WebElement uploadFile = driver.findElement(By.id("uploadFile"));

        String projectPath = System.getProperty("user.dir");
        String filePath="src/main/resources/ggg.txt";

        String fullPath=projectPath+"/"+filePath;

        uploadFile.sendKeys(fullPath);

        String fileName = "ggg.txt";
        WebElement uploadedFileName = driver.findElement(By.id("uploadedFilePath"));

        Assert.assertTrue(uploadedFileName.getText().contains(fileName));


    }


}
