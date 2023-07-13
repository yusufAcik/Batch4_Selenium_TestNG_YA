package com.krafttech.pages;

import com.krafttech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    // abstract void assertPageTitle(); tüm sayfalar için zorunlu metod

    public void navigateToTabsAndModules(String tabName,String moduleName){
        String tabXpath ="//span[text()='"+tabName+"']";
        WebElement tab = Driver.get().findElement(By.xpath(tabXpath));
        tab.click();

        if(!moduleName.isEmpty()) {
            String moduleXpath = "//span[text()='" + moduleName + "']";
            WebElement module = Driver.get().findElement(By.xpath(moduleXpath));
            module.click();
        }

    }
}
