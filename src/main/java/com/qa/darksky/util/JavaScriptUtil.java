package com.qa.darksky.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
    public WebDriver driver;

    public JavaScriptUtil(WebDriver driver) {
        this.driver = driver;
    }

    public static void flash(WebElement element, WebDriver driver) {
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 20; i++) {
            changeColor("rgb(0,200,0)", element, driver);
            changeColor(bgcolor, element, driver);
        }
    }

    public static  void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
    }

    public void drawBorder(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public void generateAlert(String message) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" + message + "')");
    }

    public void clickElementByJS(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);

    }

    public void refreshBrowserByJS() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }

    public String getTitleByJS() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    public String getPageInnerText() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String pageText = js.executeScript("return document.documentElement.innerText;").toString();
        return pageText;
    }

    public void scrollPageDown() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void specificScrollPageDown() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("scroll(0, 1000);");
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getBrowserInfo(){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String uAgent = js.executeScript("return navigator.userAgent;").toString();
        return uAgent;
    }

    public void sendKeysUsingJSWithID(String id, String value){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        //js.executeScript("document.getElementById('" + id + "').value='"+value+"'");
        js.executeScript("document.getElementById('" + id + "')[0].value='"+value+"'");
    }

    public void sendKeysUsingJSWithClassName(String className, String value){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementsByClassName('" + className + "').value='"+value+"'");
    }

    public void sendKeysUsingJSWithName(String name, String value){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementsByName('" + name + "')[0].value='"+value+"'");
    }

    public void scrollDownBy() {
        for(int second = 0;; second++){
            if(second >=20){
                break;
            }
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
