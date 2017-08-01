package com.app.pages;

import java.util.List;
import com.app.annotations.Page;


import com.google.inject.Inject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by Raju on 24/07/2017.
 */
@Page
public class SearchCruisesPage {

    @Inject
    BasePage base;

     @FindBy(id = "destination-0")
     public WebElement destination;
     @FindBy(id = "embarkport-0")
     public WebElement departurePort;
     @FindBy(id = "duration-0")
     public WebElement lengthOfCruise;
     @FindBy(id = "view")
     public WebElement viewResults;
    @FindBy(css = "button[title='Close (Esc)']")
    public WebElement close;
     @FindBy(xpath = "//h2[text()='Find your perfect cruise vacation...']")
     public WebElement CruisesHeader;
     @FindBy(css = "span[class='button-checkbox filter-date-checkbox']>input")
     public List<WebElement> CruiseDates;
    @FindBy(css = "span[class='button-checkbox filter-date-checkbox']>label")
    public List<WebElement> CruiseDatesLabel;
     @FindBy(css = "div[class='result-content']")
     public List<WebElement> CruiseSearchResults;
     
     @FindBy(xpath = "//table[@class='pricing-table']/tbody/tr/td")
     public List<WebElement> CruiseAvailbleDates;
   
     
        /**
     * select destination based on the value passed
     * @param value item to be selected
     */
    public void selectDestination(String value){
    	try
        {
            Select select=new Select(destination);
            select.selectByVisibleText(value);
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
    
    /**
     * select departure based on the value passed
     * @param value item to be selected
     */
    public void selectDeparturePort(String value){
    	try
        {
            Select select=new Select(departurePort);
            select.selectByVisibleText(value);
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
    
    /**
     * select length of cruise based on the value passed
     * @param value item to be selected
     */
    public void selectDuration(String value){
    	try
        {
            Select select=new Select(lengthOfCruise);
            select.selectByVisibleText(value);
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
    
    /**
     *click on the View Results link
     */
    public void clickOnViewResults() throws InterruptedException {
    	try
        {
            viewResults.click();
            Thread.sleep(15000);
            if(close.isDisplayed())
            {
                close.click();
            }
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
    
    /**
     *Verify the cruise header
     */
    public void VerifyCruiseHeader(){
        base.waitForElement(destination);
    	Assert.assertTrue(CruisesHeader.isDisplayed());
    }
    
    /**
     *Click on the Month
     */
    public void clickOnTheMonth(){
        try
       {
           for (int i=0;i<=CruiseDates.size();i++){
               if(CruiseDates.get(i).isEnabled())
               {
                   CruiseDatesLabel.get(i).click();
                   break;
               }
           }
       }
       catch (Exception exception)
       {
           System.out.println(exception);
       }
    }
    /**
     *Verify the CruiseSearchResults
     */
    public void verifyCruiseResult(){
    	//List<WebElement> month=CruiseDates;
    	try
        {
            for (WebElement element: CruiseSearchResults) {
                if(CruiseSearchResults.size()!=0)
                {
                    Assert.assertTrue(element.isDisplayed());
                    break;
                }
            }
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
    /**
     *Verify the CruiseAvailbleDates
     */
    public void verifyCruiseAvailbleDates(){
    	//List<WebElement> month=CruiseDates;
    	try
        {
            for (WebElement element: CruiseAvailbleDates) {
                if (CruiseAvailbleDates.size() != 0) {
                    Assert.assertTrue(element.isDisplayed());
                    System.out.println("Suite status " + CruiseAvailbleDates.get(5).getText());
                    System.out.println("");
                    break;
                }
            }
        }
        catch (Exception exception)
            {
                System.out.println(exception);
            }

    }
}
