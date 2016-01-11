package com.atlassian.test.BPT_Auto.PageFactory;

import com.atlassian.test.BPT_Auto.Utils.TestUtilFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Marcus_Chang on 2016/1/12.
 */
public class Confluence_Page_LoggedOutPage extends CommonPageModel {

    public WebElement Pop_AlreadyLoggedOut;

    public void getConfluencePageLoggedOutPageElements(WebDriver driver) {

        Pop_AlreadyLoggedOut = getPageElementById(driver, By.id("logged-out"));

    }
}
