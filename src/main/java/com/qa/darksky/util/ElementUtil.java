package com.qa.darksky.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class ElementUtil {
    WebDriver driver;
    WebDriverWait wait;
    JavaScriptUtil javaScriptUtil;
    Properties prop;

    public ElementUtil(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Constants.DEFAULT_TIME);
        javaScriptUtil = new JavaScriptUtil(driver);
    }

    public WebElement getElement(By locator){
        waitForElementPresent(locator);
        WebElement element = null;
        try{
            element = driver.findElement(locator);
//			if(flash) {
//				JavaScriptUtil.flash(element, driver);
//			}
        }
        catch (Exception e) {
            System.out.println("Some exception occured while creating webelement " +locator);
        }
        return element;
    }

    public boolean waitForElementPresent(By locator){
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return true;
    }

    public boolean waitForTitlePresent(String title){
        wait.until(ExpectedConditions.titleIs(title));
        return true;
    }

    public boolean waitForElementVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return true;
    }

    public void doClick(By locator){
        try{
            getElement(locator).click();
        }
        catch(Exception e){
            System.out.println("Some exception occured while click on  webelement " +locator);
        }
    }

    public void doSendKeys(By locator, String value){
        try{
            WebElement element  = getElement(locator);
            element.clear();
            element.sendKeys(value);
        }
        catch(Exception e){
            System.out.println("Some exception occured while sending to  webelement " + locator);
        }
    }

    public String doGetText(By locator){
        String text = null;
        try{
            text = getElement(locator).getText();
        }
        catch(Exception e){
            System.out.println("Some exception occured while getting text for element " + locator);
        }
        return text;
    }

    public String waitForGetPageTitle(String title){
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleContains(title));
        return driver.getTitle();
    }

    public boolean isElementDisplayed(By locator){
        try{
            return getElement(locator).isDisplayed();
        }catch(Exception e){
            System.out.println("Some exception occured while checking webelement displayed "+ locator);
        }
        return false;
    }

    public boolean isElementSelected(By locator){
        try{
            return getElement(locator).isSelected();
        }catch(Exception e){
            System.out.println("Some exception occured while checking webelement selected "+ locator);
        }
        return false;
    }

    public String doGetPageTitle() {
        return driver.getTitle();
    }

    public void verifyGetText(By locator, String verifyText ) {
        String text = driver.findElement(locator).getText();
        if (text.equals(verifyText)) {
            System.out.println("Text is correct.");
        } else {
            System.out.println("Text is not correct.");
        }
    }
    public void compareValues(By Verifiedlocator, By ActualLocator, String value) {
        String verified = driver.findElement(Verifiedlocator).getText();
        String actual = driver.findElement(ActualLocator).getText();

        if ((verified.compareTo(actual))==0) {
            System.out.println(value + " is verified : " + verified);
        } else {
            System.out.println(value + " is not verified. Actual " + value + " is: " + actual);
        }
    }
}
