package com.krafttech.tests.day10_actions_fileUpload_isExecuted;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
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

        actions.moveToElement(clicker,5,5).click().perform();
        // elementin 5 pixel sağa 5 pixel aşağıya click yapar

        actions.click(clicker);
        Thread.sleep(2000);
    }

    @Test
    public void actionsFillForm() {
       // https://www.krafttechexlab.com/forms/elements

        // form doldururken her alanı locate etmeden kısa yoldan yapmamızı sağlar
        driver.get("https://www.krafttechexlab.com/forms/elements");
        WebElement firstElement = driver.findElement(By.cssSelector("[name='text']"));

        actions.click(firstElement)
                .sendKeys("Ali Ak"+ Keys.TAB)
                .sendKeys("aliak@aaa.com"+Keys.TAB)
                .sendKeys("1234")
                .sendKeys(Keys.TAB)
                .sendKeys("02123131"+Keys.TAB+Keys.TAB)
                .sendKeys("12122022"+Keys.TAB)
                .sendKeys("1212p"+Keys.TAB+Keys.TAB)
                .sendKeys("Batch 4 was here"+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB)
                .sendKeys("aaaaa@aaaa.com"+Keys.TAB)
                .sendKeys("123456"+Keys.TAB)
                .sendKeys("No Comment"+Keys.TAB+Keys.TAB+Keys.ENTER).perform();

        WebElement result = driver.findElement(By.tagName("pre"));
        System.out.println("result.getText() = " + result.getText());
    }

    @Test
    public void rightClickOpenNewTab() throws InterruptedException {

        // sol ctrl + click de yeni tab da açar

        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        Thread.sleep(2000);

        WebElement evilTesterPage = driver.findElement(By.linkText("EvilTester.com"));

        actions.keyDown(Keys.LEFT_CONTROL)
                .click(evilTesterPage)
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));

        System.out.println("driver.getTitle() = " + driver.getTitle());

    }
}
