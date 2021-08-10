package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvancedWindowHandling {

    public static String url = "http://syntaxtechs.com/selenium-practice/window-popup-modal-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String mainPageWindowHandle = driver.getWindowHandle();
        WebElement instagramButton = driver.findElement(By.linkText("Follow On Instagram"));
        WebElement facebookButton = driver.findElement(By.linkText("Like us On Facebook"));
        WebElement instaAndFbButton = driver.findElement(By.linkText("Follow Instagram & Facebook"));

        instagramButton.click();
        facebookButton.click();
        instaAndFbButton.click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());
        Iterator<String> it = allWindowHandles.iterator();
        while(it.hasNext()) { // start iterating through handles
            String handle = it.next(); // get the next handle
            if(!handle.equals(mainPageWindowHandle)) { // set a condition
                driver.switchTo().window(handle); // switch to a window which is not equal to a parent handle
                System.out.println(driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(mainPageWindowHandle); // switch back to parent
        instagramButton.click();
    }

}
