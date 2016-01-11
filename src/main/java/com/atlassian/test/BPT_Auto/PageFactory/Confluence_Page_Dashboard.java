package com.atlassian.test.BPT_Auto.PageFactory;

import com.atlassian.test.BPT_Auto.Utils.TestUtilFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Marcus_Chang on 2016/1/11.
 */
public class Confluence_Page_Dashboard extends CommonPageModel {

    public WebElement Btn_QuickCreate;
    public WebElement Btn_CreatePage;
    public WebElement Pop_CreateDialog;
    public WebElement Pop_CreateDialog_BlankPage;
    public WebElement Pop_CreateDialog_CreateButton;
    public WebElement Pop_CreateDialog_CloseButton;
    public String Txt_PageTitle;

    public void getConfluencePageDashboardElements(WebDriver driver) {

        Btn_QuickCreate = getPageElementById(driver, By.id("quick-create-page-button"));
        Btn_CreatePage = getPageElementById(driver, By.id("create-page-button"));
        Pop_CreateDialog = getPageElementById(driver, By.id("create-dialog"));

        Pop_CreateDialog_BlankPage = getPageElementByXpath(driver, By.xpath("//div[@id='create-dialog']/div/div[1]/div/div[2]/div[2]/div[2]/ol/li[1]"));
        Pop_CreateDialog_CreateButton = getPageElementByXpath(driver, By.xpath("//div[@id='create-dialog']/div/div/button"));
        Pop_CreateDialog_CloseButton =getPageElementByXpath(driver, By.xpath("//div[@id='create-dialog']/div/div/a[text()='Close']"));

        Txt_PageTitle = driver.getTitle();

    }

    public void switchToIframe(WebDriver driver, WebElement targetIframe) {
        //使driver进入Frame_FormLogin内联框架进行元素定位
        driver.switchTo().frame(targetIframe);
    }

    public void switchOutIframe(WebDriver driver) {
        //登录完成后使driver跳出Frame_FormLogin内联框架
        driver.switchTo().defaultContent();
    }







}
