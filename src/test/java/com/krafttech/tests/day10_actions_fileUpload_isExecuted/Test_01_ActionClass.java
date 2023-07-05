package com.krafttech.tests.day10_actions_fileUpload_isExecuted;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_01_ActionClass {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void hoverOver() {
        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        WebElement hoverPara = driver.findElement(By.id("hoverpara"));


        actions.moveToElement(hoverPara).perform();

        WebElement text = driver.findElement(By.id("hoverparaeffect"));
        System.out.println("text.getText() = " + text.getText());

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Actions/index.html");

        WebElement drag = driver.findElement(By.cssSelector("div#draggable"));
        WebElement drop = driver.findElement(By.cssSelector("div#droppable"));

        Thread.sleep(2000);
        actions.dragAndDrop(drag,drop).perform();
        //actions.moveToElement(drag).clickAndHold().moveToElement(drop).release().build().perform();

        Thread.sleep(2000);

        System.out.println("drop.getText() = " + drop.getText());

    }

    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("https://skill-test.net/mouse-double-click");
        WebElement clicker = driver.findElement(By.cssSelector("button#clicker"));
        actions.doubleClick(clicker).perform();

        actions.click(clicker);
        Thread.sleep(2000);
    }
}
