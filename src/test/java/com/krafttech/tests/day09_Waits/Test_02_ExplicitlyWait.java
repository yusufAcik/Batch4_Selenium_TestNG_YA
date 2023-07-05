package com.krafttech.tests.day09_Waits;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Test_02_ExplicitlyWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void explicitlyWait_1() {
        /**
         * navigate to https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html
         * click the Start button and wait until the One button will be activated
         * click the One button and wait until the Two button will be activated
         * click the Two button and wait until the Three button will be activated
         * verify that the "All Buttons Clicked" message is taken.
         */

        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement startBttn = driver.findElement(By.id("button00"));
        wait.until(ExpectedConditions.elementToBeClickable(startBttn)).click();
        //startBttn.click();
        WebElement oneBttn = driver.findElement(By.id("button01"));
        wait.until(ExpectedConditions.elementToBeClickable(oneBttn)).click();

        WebElement twoBttn = driver.findElement(By.id("button02"));
        wait.until(ExpectedConditions.elementToBeClickable(twoBttn)).click();

        WebElement threeBttn = driver.findElement(By.id("button03"));
       // wait.until(ExpectedConditions.elementToBeClickable(threeBttn)).click();
        new WebDriverWait(driver,12).until(ExpectedConditions.elementToBeClickable(threeBttn)).click();

        WebElement message = driver.findElement(By.id("buttonmessage"));

        String actualMessage = message.getText();
        String expectedMessage = "All Buttons Clicked";

        Assert.assertEquals(actualMessage,expectedMessage);
        
    }

    @Test
    public void explicitlyWait_2() {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");


        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//button"),4));

        List<WebElement> buttons = driver.findElements(By.xpath("//button"));
        System.out.println("buttons.size() = " + buttons.size());

        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(0))).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(1))).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(2))).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(3))).click();

        WebElement message = driver.findElement(By.id("buttonmessage"));

        String actualMessage = message.getText();
        String expectedMessage = "All Buttons Clicked";

        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void explicitlyWait_3(){
        /**
         * eğer element henüz dom'da yoksa locate edemeyiz. hata alırız. bu durumlarda
         * wait metodlarına web element yerine By.locator göndermek çözüm olabilir.
         *
         * navigate to https://the-internet.herokuapp.com/dynamic_loading
         * click second link
         * click start button
         * use explicitly wait for the hello element and get the text (do not use any other wait)
         * verify that the element has the text of "Hello World!"
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h4[text()='Hello World!']")));

        WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        System.out.println("hello.getText() = " + hello.getText());


    }

    @Test
    public void fluentWait(){
        /**
         * navigate to https://the-internet.herokuapp.com/dynamic_loading
         * click second link
         * click start button
         * use fluent wait for the hello element and get the text (do not use any other wait)
         * verify that the element has the text of "Hello World!"
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(driver -> driver.findElement(By.xpath("//h4[text()='Hello World!']")));
        System.out.println("element.getText() = " + element.getText());

    }

}
