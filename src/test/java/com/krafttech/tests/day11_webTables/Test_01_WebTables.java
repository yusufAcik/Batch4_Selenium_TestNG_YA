package com.krafttech.tests.day11_webTables;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test_01_WebTables {

    //https://the-internet.herokuapp.com/tables
    // table içeriği + başlığını alırken
    // //table[@id='table1']/tbody/tr/td[3] | //table[@id='table1']//tr/th[3]

    // dinamik table larda locatorda element sabitleme isim kullanarak
    // //table[@id='table1']//td[text()='Frank']/../td[3]

    //https://demoqa.com/webtables
    // //div[text()='Vega']/../div[1]

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

    @Test
    public void webTablesTest(){

        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the data of specific cell by using row and column numbers
         */
        driver.get("https://the-internet.herokuapp.com/tables");

        int numberOfColumns=getNumberOfColumns();
        int numberOfRows=getNumberOfRows();
        
        String dataOfCell=dataOfCell(2,3);
      //  System.out.println("dataOfCell = " + dataOfCell);

        for (int i = 1; i <=numberOfRows ; i++) {
            for (int j = 1; j <numberOfColumns ; j++) {
                System.out.print(dataOfCell(i,j)+" ");
            }
            System.out.println();
        }

    }

    private String dataOfCell(int row,int column) {
        String xPath = "//table[@id='table1']//tbody/tr["+row+"]/td["+column+"]";
        WebElement cell = driver.findElement(By.xpath(xPath));
        return cell.getText();
    }

    private int getNumberOfRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        return rows.size();
    }

    private int getNumberOfColumns() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return columns.size();
    }
}
