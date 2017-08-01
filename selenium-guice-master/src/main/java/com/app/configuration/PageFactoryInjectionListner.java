package com.app.configuration;


import com.app.utils.PropertyMap;
import com.google.inject.Provider;
import com.google.inject.spi.InjectionListener;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageFactoryInjectionListner implements InjectionListener{

   Provider<WebDriver> provider;

   PageFactoryInjectionListner(Provider<WebDriver> injector) {
       this.provider = injector;
   }

    @Override
    public void afterInjection(Object o) {
        WebDriver driver = this.provider.get();
        String browserV = PropertyMap.getInstance().getProperties().getProperty("test.browser.name");
        if(browserV.contains("android") || browserV.contains("ios") || browserV.contains("youi")) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), o);
        }
        else {
            PageFactory.initElements(driver, o);
        }
    }
}
