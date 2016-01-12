package com.atlassian.test.BPT_Auto.TestParams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;
import org.junit.BeforeClass;

/**
 * Created by Marcus_Chang on 2016/Jan/07.
 * Latest Updated by Marcus_Chang on 2016/Jan/08.
 * This java file is used to store all const params for all test projects
 */
public class ProjectParams implements ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(ProjectParams.class);

    private static Properties propertiesFactoryBean;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setPropertiesFactoryBean((Properties) applicationContext.getBean("propertiesFactoryBean"));
    }

    public static void setPropertiesFactoryBean(Properties propertiesFactoryBean) {
        ProjectParams.propertiesFactoryBean = propertiesFactoryBean;
    }

    public static Properties getPropertiesFactoryBean() {
        return propertiesFactoryBean;
    }

    public static String getChromeDriverLocalPath() {
        return propertiesFactoryBean.get("ChromeDriverLocalPath").toString().trim();
    }

    public static String getFireFoxDriverLocalPath() {
        return propertiesFactoryBean.get("FireFoxDriverLocalPath").toString().trim();
    }

    public static String getIEDriverLocalPath() {
        return propertiesFactoryBean.get("IEDriverLocalPath").toString().trim();
    }

    public static String getExtentReportsPath() {
        return propertiesFactoryBean.get("ExtentReportsPath").toString().trim();
    }

    public static String getScreenShotsPath() {
        return propertiesFactoryBean.get("ScreenShotsPath").toString().trim();
    }

    public static String getScreenShotsFormat() {
        return propertiesFactoryBean.get("ScreenShotsFormat").toString().trim();
    }

    public static String getConfluenceURL() {
        return propertiesFactoryBean.get("ConfluenceURL").toString().trim();
    }

    public static String getLoginUserName() {
        return propertiesFactoryBean.get("LoginUserName").toString().trim();
    }

    public static String getLoginUserPass() {
        return propertiesFactoryBean.get("LoginUserPass").toString().trim();
    }

    public static String getLoginInvitedUserName() {
        return propertiesFactoryBean.get("LoginInvitedUserName").toString().trim();
    }

    public static String getLoginInvitedUserPass() {
        return propertiesFactoryBean.get("LoginInvitedUserPass").toString().trim();
    }


    public static String getTestCase_CreateNewPage_QuickCreate_On_Chrome_LayOut() {
        return propertiesFactoryBean.get("TestCase_CreateNewPage_QuickCreate_On_Chrome_LayOut").toString().trim();
    }

    public static String getTestCase_CreateNewPage_QuickCreate_On_Firefox_LayOut() {
        return propertiesFactoryBean.get("TestCase_CreateNewPage_QuickCreate_On_Firefox_LayOut").toString().trim();
    }

    public static String getTestCase_CreateNewPage_QuickCreate_On_IE_LayOut() {
        return propertiesFactoryBean.get("TestCase_CreateNewPage_QuickCreate_On_IE_LayOut").toString().trim();
    }

    public static String getChromeQuickCreateNewBlankPageTitle() {
        return propertiesFactoryBean.get("ChromeQuickCreateNewBlankPageTitle").toString().trim();
    }

    public static String getChromeQuickCreateNewBlankPageBodyContent() {
        return propertiesFactoryBean.get("ChromeQuickCreateNewBlankPageBodyContent").toString().trim();
    }

    public static String getFirefoxQuickCreateNewBlankPageTitle() {
        return propertiesFactoryBean.get("FirefoxQuickCreateNewBlankPageTitle").toString().trim();
    }

    public static String getFirefoxQuickCreateNewBlankPageBodyContent() {
        return propertiesFactoryBean.get("FirefoxQuickCreateNewBlankPageBodyContent").toString().trim();
    }

    public static String getIEQuickCreateNewBlankPageTitle() {
        return propertiesFactoryBean.get("IEQuickCreateNewBlankPageTitle").toString().trim();
    }

    public static String getIEQuickCreateNewBlankPageBodyContent() {
        return propertiesFactoryBean.get("IEQuickCreateNewBlankPageBodyContent").toString().trim();
    }

    public static String getTestCase_SetRestrictions_QuickCreate_On_Chrome_LayOut() {
        return propertiesFactoryBean.get("TestCase_SetRestrictions_QuickCreate_On_Chrome_LayOut").toString().trim();
    }

    public static String getTestCase_SetRestrictions_QuickCreate_On_Firefox_LayOut() {
        return propertiesFactoryBean.get("TestCase_SetRestrictions_QuickCreate_On_Firefox_LayOut").toString().trim();
    }

    public static String getTestCase_SetRestrictions_QuickCreate_On_IE_LayOut() {
        return propertiesFactoryBean.get("TestCase_SetRestrictions_QuickCreate_On_IE_LayOut").toString().trim();
    }

    public static String getChromeSetRestrictionsNewBlankPageTitle() {
        return propertiesFactoryBean.get("ChromeSetRestrictionsOnQuickCreateNewBlankPageTitle").toString().trim();
    }

    public static String getChromeSetRestricitonsNewBlankPageBodyContent() {
        return propertiesFactoryBean.get("ChromeSetRestrictionsOnQuickCreateNewBlankPageBodyContent").toString().trim();
    }

    public static String getFirefoxSetRestrictionsNewBlankPageTitle() {
        return propertiesFactoryBean.get("FirefoxSetRestrictionsOnQuickCreateNewBlankPageTitle").toString().trim();
    }

    public static String getFirefoxSetRestrictionsNewBlankPageBodyContent() {
        return propertiesFactoryBean.get("FirefoxSetRestrictionsOnQuickCreateNewBlankPageBodyContent").toString().trim();
    }

    public static String getIESetRestrictionsNewBlankPageTitle() {
        return propertiesFactoryBean.get("IESetRestrictionsOnQuickCreateNewBlankPageTitle").toString().trim();
    }

    public static String getIESetRestrictionsNewBlankPageBodyContent() {
        return propertiesFactoryBean.get("IESetRestrictionsOnQuickCreateNewBlankPageBodyContent").toString().trim();
    }

    public static String getRestrictionsPageSetPermissionSelectorToCanView() {
        return propertiesFactoryBean.get("RestrictionsPageSetPermissionSelectorToCanView").toString().trim();
    }







}
