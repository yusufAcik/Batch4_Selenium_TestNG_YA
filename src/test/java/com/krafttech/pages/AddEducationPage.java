package com.krafttech.pages;

import com.krafttech.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class AddEducationPage extends BasePage{
    @FindBy(xpath = "//button[text()='Add Education'][./parent::div]")
    public WebElement addEducationButton;

    @FindBy(css = "#school")
    public WebElement schoolOrBootcamp;

    @FindBy(xpath = "//*[@id='currentedu']")
    public WebElement checkBox;

    public void fillingEducationForm(){
        Actions actions=new Actions(Driver.get());

        actions.click(schoolOrBootcamp)
                .sendKeys("Kraft"+ Keys.TAB)
                .sendKeys("First Degree"+Keys.TAB)
                .sendKeys("IT Engineering"+Keys.TAB)
                .sendKeys("11122020"+Keys.TAB+Keys.TAB)
                .sendKeys("12122022"+Keys.TAB)
                .sendKeys("Nice Course"+Keys.TAB+Keys.ENTER).perform();
    }
}
