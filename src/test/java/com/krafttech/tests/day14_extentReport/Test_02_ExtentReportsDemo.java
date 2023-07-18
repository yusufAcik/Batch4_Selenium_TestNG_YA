package com.krafttech.tests.day14_extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_02_ExtentReportsDemo {
    // bu class rapor oluşturmak ve raporla ilgili metadatayı tanımlamak için kullanılır(rapora özel)

    ExtentReports report;
    // bu class raporumuzun formatını html olarak düzenler

    ExtentHtmlReporter htmlReporter;
    // her test ile ilgili log kayıtlarını tutmamızı sağlar(teste özel)

    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        // class ı başlatalım
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
    @Test
    public void testName(){
        // mevcut testimizin ismini girelim
        extentLogger=report.createTest("Demo Test");
        // test adımlarını girelim
        extentLogger.info("url git");
        // code here
        extentLogger.info("emaili gir");
        // code here
        extentLogger.info("şifreyi gir");
        // code here
        extentLogger.info("login ol");
        // code here

        // eğer test buraya kadar gelmişse o testi "GEÇTİ" olarak belirleyelim
        extentLogger.pass("PASSED");

    }
    @AfterMethod
    public void tearDown(){
        report.flush();
    }
}
