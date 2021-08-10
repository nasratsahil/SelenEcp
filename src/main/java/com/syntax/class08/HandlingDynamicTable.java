package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingDynamicTable {

    public static String url = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'ctl00_MainContent_orderGrid']/tbody/tr"));
        for(int i = 1; i < rows.size(); i++) {
            String rowText = rows.get(i).getText();
            System.out.println(rowText);
            if(rowText.contains("Bob Feather")) {
                List<WebElement> checkboxes = driver.findElements(By.xpath("//table[@id = 'ctl00_MainContent_orderGrid']/tbody/tr/td[1]"));
                checkboxes.get(i-1).click();
                break;
            }
        }
    }

}
