package com.atlassian.test.BPT_Auto.PageFactory;

import com.atlassian.test.BPT_Auto.TestParams.ProjectParams;
import com.atlassian.test.BPT_Auto.Utils.TestUtilFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Marcus_Chang on 2016/1/11.
 */
public class Confluence_Page_NewBlankPage extends CommonPageModel {

    public WebElement Ipt_ContentTitle;
    public WebElement Btn_Preview;
    public WebElement Btn_Save;
    public WebElement Btn_Close;
    public String Txt_PageTitle;

    public void getConfluencePageNewBlankPageElements(WebDriver driver) {

        Ipt_ContentTitle = getPageElementById(driver, By.id("content-title"));
        Btn_Preview = getPageElementById(driver, By.id("rte-button-preview"));
        Btn_Save = getPageElementById(driver, By.id("rte-button-publish"));
        Btn_Close = getPageElementById(driver, By.id("rte-button-cancel"));
        Txt_PageTitle = driver.getTitle();

    }

    public void setConfluencePageNewBlankPageMCEbody(WebDriver driver) {

         String tinyMcebBodyInputContent = ProjectParams.getChromeQuickCreateNewBlankPageBodyContent();
        ((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.setContent(arguments[0])", tinyMcebBodyInputContent);

    }

}
