package com.atlassian.test.BPT_Auto.PageFactory;

import com.atlassian.test.BPT_Auto.Utils.TestUtilFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Marcus_Chang on 2016/1/11.
 */
public class Confluence_Page_NewCreatedPage extends CommonPageModel {

    public WebElement Txt_CreatedPageTitleText;
    public WebElement Txt_CreatedPageMainContent;
    public WebElement Btn_CreatedPageUserMenuLink;
    public WebElement Btn_Logout;
    public String Txt_PageTitle;

    public void getConfluencePageNewCreatedPageElements(WebDriver driver) {

        Txt_CreatedPageTitleText = getPageElementById(driver, By.id("title-text"));
        Txt_CreatedPageMainContent = getPageElementById(driver, By.id("main-content"));
        Btn_CreatedPageUserMenuLink = getPageElementById(driver, By.id("user-menu-link"));
        Btn_Logout = getPageElementById(driver, By.id("logout-link"));
        Txt_PageTitle = driver.getTitle();

    }



}
