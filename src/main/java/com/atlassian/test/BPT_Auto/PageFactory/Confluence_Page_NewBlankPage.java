package com.atlassian.test.BPT_Auto.PageFactory;

import com.atlassian.test.BPT_Auto.TestParams.ProjectParams;
import com.atlassian.test.BPT_Auto.Utils.TestUtilFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by Marcus_Chang on 2016/1/11.
 */
public class Confluence_Page_NewBlankPage extends CommonPageModel {

    public WebElement Ipt_ContentTitle;
    public WebElement Btn_Preview;
    public WebElement Btn_Save;
    public WebElement Btn_Close;
    public WebElement Btn_Restrictions;
    public String Txt_PageTitle;
    public String tinyMcebBodyInputContent;

    public void getConfluencePageNewBlankPageElements(WebDriver driver) {

        Ipt_ContentTitle = getPageElementById(driver, By.id("content-title"));
        Btn_Preview = getPageElementById(driver, By.id("rte-button-preview"));
        Btn_Save = getPageElementById(driver, By.id("rte-button-publish"));
        Btn_Close = getPageElementById(driver, By.id("rte-button-cancel"));
        Btn_Restrictions = getPageElementById(driver, By.id("rte-button-restrictions"));
        Txt_PageTitle = driver.getTitle();

    }

    public void setTestCaseCreateNewPageConfluencePageNewBlankPageMCEbody(WebDriver driver) {

        if (driver instanceof ChromeDriver) {
            tinyMcebBodyInputContent = ProjectParams.getChromeQuickCreateNewBlankPageBodyContent();
        }
        else if (driver instanceof FirefoxDriver) {
            tinyMcebBodyInputContent = ProjectParams.getFirefoxQuickCreateNewBlankPageBodyContent();
        }else if (driver instanceof InternetExplorerDriver) {
            tinyMcebBodyInputContent = ProjectParams.getIEQuickCreateNewBlankPageBodyContent();
        }

        ((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.setContent(arguments[0])", tinyMcebBodyInputContent);

    }

    public void setTestCaseSetRestrictionsConfluencePageNewBlankPageMCEbody(WebDriver driver) {

        if (driver instanceof ChromeDriver) {
            tinyMcebBodyInputContent = ProjectParams.getChromeSetRestricitonsNewBlankPageBodyContent();
        }
        else if (driver instanceof FirefoxDriver) {
            tinyMcebBodyInputContent = ProjectParams.getFirefoxSetRestrictionsNewBlankPageBodyContent();
        }else if (driver instanceof InternetExplorerDriver) {
            tinyMcebBodyInputContent = ProjectParams.getIESetRestrictionsNewBlankPageBodyContent();
        }

        ((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.setContent(arguments[0])", tinyMcebBodyInputContent);

    }

}
