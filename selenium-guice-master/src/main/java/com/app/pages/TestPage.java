package com.app.pages;

import com.app.annotations.Page;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yuvarej on 29/05/2016.
 */
@Page
public class TestPage extends HeaderPage{


    @FindBy(linkText = "Gmail")
    private WebElement FindCruises;      
    

    
    /**
     *click on the Cruises link
     */
    public void ClickGmailLink(){
    	try
        {
            FindCruises.click();
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }

    }

}
