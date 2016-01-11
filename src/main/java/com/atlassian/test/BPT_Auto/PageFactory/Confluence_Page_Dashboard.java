package com.atlassian.test.BPT_Auto.PageFactory;

import com.atlassian.test.BPT_Auto.Utils.TestUtilFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Marcus_Chang on 2016/1/11.
 */
public class Confluence_Page_Dashboard extends CommonPageModel {

    private static WebElement Btn_QuickCreate;
    private static WebElement Btn_CreatePage;
    private static WebElement Pop_CreateDialog;
    private static WebElement Pop_CreateDialog_BlankPage;
    private static WebElement Pop_CreateDialog_CreateButton;
    private static WebElement Pop_CreateDialog_CloseButton;
    private static String Txt_PageTitle;

    public void getConfluencePageDashboardElements(WebDriver driver) {

        Btn_QuickCreate = getPageElementById(driver, By.id("quick-create-page-button"));
        Btn_CreatePage = getPageElementById(driver, By.id("create-page-button"));
        Pop_CreateDialog = getPageElementById(driver, By.id("create-dialog"));

        Pop_CreateDialog_BlankPage = getPageElementByXpath(driver, By.id("create-dialog"));
        Pop_CreateDialog_CreateButton = getPageElementByXpath(driver, By.xpath("//div[@id='create-dialog']/div/div/button"));
        Pop_CreateDialog_CloseButton =getPageElementByXpath(driver, By.xpath("//div[@id='create-dialog']/div/div/a[text()='Close']"));

        Txt_PageTitle = driver.getTitle();

    }







}
