package com.atlassian.test.BPT_Auto.PageFactory;

import com.atlassian.test.BPT_Auto.TestParams.ProjectParams;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Marcus_Chang on 2016/1/12.
 */
public class Confluence_Page_Restrictions extends CommonPageModel{

    public WebElement Drp_RestrictionsList;
    public WebElement Btn_NoRestrictions;
    public WebElement Btn_EditingRestricted;
    public WebElement Btn_ViewingAndEditingRestricted;
    public WebElement Ipt_AddUserBar;
    public WebElement Drp_PermissionSelector;
    public WebElement Btn_Add;
    public WebElement Btn_Apply;
    public WebElement Btn_Cancel;
    public WebElement Drp_InvitedUser;

    public void getConfluencePageRestrictionsElements(WebDriver driver) {

        Drp_RestrictionsList = getPageElementById(driver, By.id("s2id_page-restrictions-dialog-selector"));
        Btn_NoRestrictions = getPageElementByXpath(driver, By.xpath("//div[@id='select2-drop']/ul/li[1]/div"));
        Btn_EditingRestricted = getPageElementByXpath(driver, By.xpath("//div[@id='select2-drop']/ul/li[2]/div"));
        Btn_ViewingAndEditingRestricted = getPageElementByXpath(driver, By.xpath("//div[@id='select2-drop']/ul/li[3]/div"));
        //Ipt_AddUserBar = getPageElementById(driver, By.id("s2id_restrictions-dialog-auto-picker"));
        Ipt_AddUserBar = getPageElementById(driver, By.id("s2id_autogen2"));
        Drp_PermissionSelector = getPageElementById(driver, By.id("page-restrictions-permission-selector"));
        Btn_Add = getPageElementById(driver, By.id("page-restrictions-add-button"));
        Btn_Apply = getPageElementById(driver, By.id("page-restrictions-dialog-save-button"));
        Btn_Cancel = getPageElementById(driver, By.id("page-restrictions-dialog-close-button"));
        Drp_InvitedUser = getPageElementByXpath(driver, By.xpath("//div[@id='select2-drop']/ul/li/div"));

    }

    public void setPermissionSelectorToValue(String text) {

        new Select(Drp_PermissionSelector).selectByVisibleText(text);

    }


}
