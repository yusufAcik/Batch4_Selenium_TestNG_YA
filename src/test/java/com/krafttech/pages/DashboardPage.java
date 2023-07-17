package com.krafttech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//li[@class='breadcrumb-item'][2]")
    public WebElement dashboardPageTitle;

    @FindBy(tagName = "h2")
    public WebElement userName;

    public String getElementText(WebElement element){
        return element.getText();
    }

    public void clickElement(WebElement element){
        element.click();
    }
}
