package com.atlassian.test.BPT_Auto.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * Created by Marcus_Chang on 2016/Jan/07.
 */
public class TestUtilFunctions {

    /**
     * ->waitForTime
     */
    public void waitForTime(long milliSecs) {
        try {
            Thread.sleep(milliSecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * ->isElementPresent
     */
    public boolean isElementPresent(WebDriver driver, By by) {

        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    /**
     * ->waitForElement
     */
    public void waitForElement(WebDriver driver ,By locator, long timeout) {
        System.out.println("--waitForElement: locator-->" + locator);
        System.out.println("--waitForElement: timeout-->" + timeout);

        if (waitUntil(driver, locator, timeout)) {
        } else {
            System.out.println("wait time out.");
        }
    }


    /**
     * ->waitUntil
     */
    public boolean waitUntil(WebDriver driver, By locator, long timeout) {
        long loopStartTime = new Date().getTime();
        long loopEndTime, loopDifTime = 0;
        boolean elementExists = false;
        while (!elementExists) {
            elementExists = isElementPresent(driver, locator);
            if (elementExists == true) {
                elementExists = true;
                break;
            } else {
                elementExists = false;
            }
            waitForTime(1000);
            loopEndTime = new Date().getTime();
            loopDifTime = loopEndTime - loopStartTime;
            if (loopDifTime >= timeout) {
                System.out.println("waitForElement time out.");
                break;
            }
        }
        return elementExists;
    }


    /**
     * ->clearInputs
     */
    public void clearInputs(WebDriver driver, WebElement element){
        Actions sim_action = new Actions(driver);
        sim_action.click(element).perform();
        sim_action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.LEFT_SHIFT).sendKeys(Keys.END).sendKeys(Keys.NULL).perform();
        sim_action.sendKeys(Keys.DELETE).sendKeys(Keys.NULL).perform();
        sim_action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.LEFT_SHIFT).sendKeys(Keys.HOME).sendKeys(Keys.NULL).perform();
        sim_action.sendKeys(Keys.DELETE).sendKeys(Keys.NULL).perform();
        sim_action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.LEFT_SHIFT).sendKeys(Keys.HOME).sendKeys(Keys.NULL).perform();
        sim_action.sendKeys(Keys.DELETE).sendKeys(Keys.NULL).perform();
        sim_action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.LEFT_SHIFT).sendKeys(Keys.END).sendKeys(Keys.NULL).perform();
        sim_action.sendKeys(Keys.DELETE).sendKeys(Keys.NULL).perform();
        sim_action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.LEFT_SHIFT).sendKeys(Keys.HOME).sendKeys(Keys.NULL).perform();
        sim_action.sendKeys(Keys.DELETE).sendKeys(Keys.NULL).perform();
    }


    /**
     * ->set IE driver properties
     */
    public DesiredCapabilities setIEdriverProperties(String IEdriverLocalPath){
        System.setProperty("webdriver.ie.driver", IEdriverLocalPath);
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        return ieCapabilities;
    }

    public static String getDateTime() {
        Date date = Calendar.getInstance().getTime();

        // Display a date in day, month, year format
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
        String today = formatter.format(date);
        return today;
    }

}
