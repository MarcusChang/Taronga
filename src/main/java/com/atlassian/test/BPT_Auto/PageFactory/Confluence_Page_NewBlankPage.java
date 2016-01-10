package com.atlassian.test.BPT_Auto.PageFactory;

import com.atlassian.test.BPT_Auto.Utils.TestUtilFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Marcus_Chang on 2016/1/11.
 */
public class Confluence_Page_NewBlankPage extends CommonPageModel {

    private static WebElement Ipt_ContentTitle;
    private static WebElement Ipt_MceContentBody;
    private static WebElement Btn_Priview;
    private static WebElement Btn_Save;
    private static WebElement Btn_Close;
    private static String Txt_PageTitle;

    public void getConfluencePageNewBlankPageElements(WebDriver driver) {

        Ipt_ContentTitle = getPageElementById(driver, By.id("content-title"));
        Ipt_MceContentBody = getPageElementById(driver, By.id("tinymce"));
        Btn_Priview = getPageElementById(driver, By.id("rte-button-preview"));
        Btn_Save = getPageElementById(driver, By.id("rte-button-publish"));
        Btn_Close = getPageElementById(driver, By.id("rte-button-cancel"));
        Txt_PageTitle = driver.getTitle();

    }

}
