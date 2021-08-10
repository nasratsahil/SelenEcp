package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HW {

    public static String url = "https://aa.com/homePage.do";
    public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get(url);
            //driver.manage().window().maximize();
            WebElement departBox = driver.findElement(By.id("aa-leavingOn"));
            departBox.click();
            WebElement dMonthDepart = driver.findElement(By.className("ui-datepicker-title"));
            String dMonthDepartText = dMonthDepart.getText();
            while (!dMonthDepartText.contains("August")){
                WebElement nextButton = driver.findElement(By.xpath("//a[@title = 'Next']"));
                nextButton.click();
                WebElement dMonth2 = driver.findElement(By.className("ui-datepicker-title"));
                dMonthDepartText=dMonth2.getText();
            }
            List<WebElement> departDates = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td"));
            for (WebElement departDate:departDates){
                if (departDate.getText().equals("13")){
                    departDate.click();
                    break;
                }
            }
            WebElement returnBox = driver.findElement(By.id("aa-returningFrom"));
            returnBox.click();
            WebElement monthReturn = driver.findElement(By.className("ui-datepicker-month"));
            String monthReturnText = monthReturn.getText();
            while (!monthReturnText.equals("September")){
                WebElement nextButton = driver.findElement(By.xpath("//a[@title = 'Next']"));
                nextButton.click();
                WebElement monthReturn2 = driver.findElement(By.className("ui-datepicker-month"));
                monthReturnText = monthReturn2.getText();
            }
            List<WebElement> returnDates = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td"));
            for (WebElement returnDate:returnDates){
                if (returnDate.getText().equals("12")){
                    returnDate.click();
                    break;
                }
            }
            WebElement toDestination = driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
            toDestination.sendKeys("LAX");
            WebElement searchButton = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
            searchButton.click();
            driver.quit();
        }
    }

