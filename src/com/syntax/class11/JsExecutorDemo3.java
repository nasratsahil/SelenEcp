package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsExecutorDemo3 {

    public static String url = "http://google.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.open();");
        driver.get(url);
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("adfahdfkajlfakfadjfa");
    }
}
