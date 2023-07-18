package com.krafttech.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    // normalde default kullanılır ancak protected yaparsak
    // extend eden klaslar kullanabilir
    protected Actions actions;

    protected WebDriverWait wait;

    protected ExtentReports report;

   protected ExtentHtmlReporter htmlReporter;

    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        report=new ExtentReports();

        // raporun kayıt edileceği yeri berirleyelim
        String projectPath = System.getProperty("user.dir");
        String reportPath = projectPath+"/test-output/report.html";

        // HTML raporumuzu path ile oluşturalım
        htmlReporter=new ExtentHtmlReporter(reportPath);

        // HTML raporumuzu report nesnesi ile ilişkilendirelim
        report.attachReporter(htmlReporter);

        // raporun başlığını düzenleyelim
        htmlReporter.config().setReportName("Smoke Test");

        // raporun metadatasını düzenleyelim
        report.setSystemInfo("Enviroment","UAT");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Yusuf");
        report.setSystemInfo("PO","ABC");

    }

    @AfterTest
    public void tearDownTest(){
    report.flush();
    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.get("url"));
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,10);

    }

    // ITestResult interface TestNG den gelir ve test sonuçlarının tutulduğu bir yapısı vardır

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE){
            // başarısız testin adını alalım
            extentLogger.fail(result.getName());
            // screen shot ı alalım ve ss in kayıt edileceği yeri belirleyelim
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            //ekran görüntüsünü rapora ekleyelim
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            // exception logunu ekleyelim
            extentLogger.fail(result.getThrowable());
        }
        Driver.closeDriver();
    }
}
