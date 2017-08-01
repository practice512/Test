package com.app.pages;

import com.app.annotations.Page;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yuvaraj on 19/07/2017.
 */
@Page
class BasePage {

  @Inject
  private WebDriver driver;

  @Inject
  @Named("test.element.wait.seconds")
  private int elementWait;

  public void waitForElement(WebElement element) {
      WebDriverWait wait = getElementWait();
      wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  /**
   * returns the webdriver wait object for the element wait
   * @return
   */
  private WebDriverWait getElementWait() {
      return new WebDriverWait(driver, elementWait);
  }
    public void sync()
  {
      /*long start = System.currentTimeMillis();
      ((JavascriptExecutor) driver).executeAsyncScript(
              "window.setTimeout(arguments[arguments.length - 1], 500);");
      //System.out.println("Elapsed time: " + System.currentTimeMillis() - start);*/
      Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
              //Wait for the condition
              .withTimeout(10, TimeUnit.MINUTES)
              // which to check for the condition with interval of 5 seconds.
              .pollingEvery(5, TimeUnit.SECONDS)
              //Which will ignore the NoSuchElementException
              .ignoring(NoSuchElementException.class);

  }

}

