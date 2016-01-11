package com.atlassian.test.BPT_Auto.PageFactory;

import com.atlassian.test.BPT_Auto.Utils.TestUtilFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Marcus_Chang on 2016/1/11.
 */
public class Confluence_Page_ConfirmLogoutPage extends CommonPageModel {

    public WebElement Btn_ConfirmLogout;
    public WebElement Lnk_ReturnHome;

    public void getConfluencePageConfirmLogoutPageElements(WebDriver driver) {

        Btn_ConfirmLogout = getPageElementById(driver, By.id("logout"));
        Lnk_ReturnHome = getPageElementById(driver, By.id("cancel"));

    }

}
