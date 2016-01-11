package com.atlassian.test.BPT_Auto.PageFactory;

import com.atlassian.test.BPT_Auto.Utils.TestUtilFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Marcus_Chang on 2016/1/11.
 */
public class AtlassianCloud_Page_Login extends CommonPageModel {

    private static WebElement Ipt_UserName;
    private static WebElement Ipt_PassWord;
    private static WebElement Btn_Login;
    private static WebElement Ckb_KeepMeLoggedIn;
    private static String Txt_PageTitle;

    public void getAtlassianCloudPageLoginElements(WebDriver driver) {

        Ipt_UserName = getPageElementById(driver, By.id("username"));
        Ipt_PassWord = getPageElementById(driver, By.id("password"));
        Btn_Login = getPageElementById(driver, By.id("login"));
        Ckb_KeepMeLoggedIn = getPageElementById(driver, By.id("remember-me"));
        Txt_PageTitle = driver.getTitle();

    }

    public void cleanLoginPageInputTextArea(WebDriver driver, TestUtilFunctions testUtil){
        testUtil.clearInputs(driver, Ipt_UserName);
        testUtil.clearInputs(driver, Ipt_PassWord);
    }

}
