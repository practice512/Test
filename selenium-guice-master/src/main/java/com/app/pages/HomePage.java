package com.app.pages;
import com.app.annotations.Page;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yuvarej on 29/05/2016.
 */
@Page
public class HomePage extends HeaderPage{

    @Inject
    WebDriver driver;

    @Inject
    BasePage base;

    @Inject
    @Named("app.url")
    String applicationUrl;
    
    @FindBy(css = "a[data-us-text='Plan a Cruise']")
    private WebElement planACruise;   
    
    @FindBy(linkText = "Find Cruises")
    private WebElement FindCruises;      
    
    /**
     * goes to the application home page by launching the browser     * 
     */
    public void goToHomePage() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(applicationUrl);
        base.waitForElement(planACruise);
          }
    
    /**
     * move the mouse on the Plan A Cruise
     */
    public void mouseHourOnThePlanACruise(){
    	
    	try
        {
            Actions action = new Actions(driver);
            action.moveToElement(planACruise).build().perform();
            base.waitForElement(FindCruises);
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
        
    }
    
    /**
     * Verify the title of the page
     */
    public void VerifyHomePageTitle(String title){
        try
        {
            String CruisHomeTitle=driver.getTitle();
            Assert.assertEquals(title, CruisHomeTitle);
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
    
    /**
     *Verify the Find Cruises link
     */
    public void VerifyFindCruisLink(){
    	Assert.assertTrue(FindCruises.isDisplayed());
    }
    
    /**
     *click on the Cruises link
     */
    public void ClickFindCruisLink(){
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
