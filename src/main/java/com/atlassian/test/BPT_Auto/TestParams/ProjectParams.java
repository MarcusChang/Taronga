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

    public static String getLibraURL() {
        return propertiesFactoryBean.get("LibraURL").toString().trim();
    }

    public static String getStandardTopicURL() {
        return propertiesFactoryBean.get("StandardTopicURL").toString().trim();
    }

    public static String getPKTopicURL() {
        return propertiesFactoryBean.get("PKTopicURL").toString().trim();
    }

    public static String getChromeTest_167543_HomePage_LayOut() {
        return propertiesFactoryBean.get("ChromeTest_167543_HomePage_LayOut").toString().trim();
    }

    public static String getChromeTest_167543_StdTopic_LayOut() {
        return propertiesFactoryBean.get("ChromeTest_167543_StdTopic_LayOut").toString().trim();
    }

    public static String getChromeTest_167543_PKTopic_LayOut() {
        return propertiesFactoryBean.get("ChromeTest_167543_PKTopic_LayOut").toString().trim();
    }

    public static String getFirefoxTest_167543_HomePage_LayOut() {
        return propertiesFactoryBean.get("FirefoxTest_167543_HomePage_LayOut").toString().trim();
    }

    public static String getFirefoxTest_167543_StdTopic_LayOut() {
        return propertiesFactoryBean.get("FirefoxTest_167543_StdTopic_LayOut").toString().trim();
    }

    public static String getFirefoxTest_167543_PKTopic_LayOut() {
        return propertiesFactoryBean.get("FirefoxTest_167543_PKTopic_LayOut").toString().trim();
    }

    public static String getIETest_167543_HomePage_LayOut() {
        return propertiesFactoryBean.get("IETest_167543_HomePage_LayOut").toString().trim();
    }

    public static String getIETest_167543_StdTopic_LayOut() {
        return propertiesFactoryBean.get("IETest_167543_StdTopic_LayOut").toString().trim();
    }

    public static String getIETest_167543_PKTopic_LayOut() {
        return propertiesFactoryBean.get("IETest_167543_PKTopic_LayOut").toString().trim();
    }

    public static String getChromeTest_167545_LayOut() {
        return propertiesFactoryBean.get("ChromeTest_167545_LayOut").toString().trim();
    }

    public static String getFirefoxTest_167545_LayOut() {
        return propertiesFactoryBean.get("FirefoxTest_167545_LayOut").toString().trim();
    }

    public static String getIETest_167545_LayOut() {
        return propertiesFactoryBean.get("IETest_167545_LayOut").toString().trim();
    }

    public static String getSimLoginUserName_1() {
        return propertiesFactoryBean.get("SimLoginUserName_1").toString().trim();
    }

    public static String getSimLoginUserName_2() {
        return propertiesFactoryBean.get("SimLoginUserName_2").toString().trim();
    }

    public static String getSimLoginUserName_3() {
        return propertiesFactoryBean.get("SimLoginUserName_3").toString().trim();
    }

    public static String getSimLoginUserPass() {
        return propertiesFactoryBean.get("SimLoginUserPass").toString().trim();
    }

    public static String getTargetSkuUrl_1() {
        return propertiesFactoryBean.get("TargetSkuUrl_1").toString().trim();
    }

    public static String getTargetSkuUrl_2() {
        return propertiesFactoryBean.get("TargetSkuUrl_2").toString().trim();
    }

    public static String getTargetSkuUrl_3() {
        return propertiesFactoryBean.get("TargetSkuUrl_3").toString().trim();
    }

    public static String getTargetSkuUrl_4() {
        return propertiesFactoryBean.get("TargetSkuUrl_4").toString().trim();
    }

    public static String getTargetSkuUrl_5() {
        return propertiesFactoryBean.get("TargetSkuUrl_5").toString().trim();
    }

    public static String getTargetSkuUrl_6() {
        return propertiesFactoryBean.get("TargetSkuUrl_6").toString().trim();
    }

    public static String getTargetSkuUrl_7() {
        return propertiesFactoryBean.get("TargetSkuUrl_7").toString().trim();
    }

    public static String getTargetDialogAskInput_1() {
        return propertiesFactoryBean.get("TargetDialogAskInput_1").toString().trim();
    }

    public static String getTargetDialogAskInput_2() {
        return propertiesFactoryBean.get("TargetDialogAskInput_2").toString().trim();
    }

    public static String getTargetDialogAskInput_3() {
        return propertiesFactoryBean.get("TargetDialogAskInput_3").toString().trim();
    }

    public static String getTargetDialogAskInput_4() {
        return propertiesFactoryBean.get("TargetDialogAskInput_4").toString().trim();
    }

    public static String getTargetDialogAskInput_5() {
        return propertiesFactoryBean.get("TargetDialogAskInput_5").toString().trim();
    }

    public static String getTargetDialogAskInput_6() {
        return propertiesFactoryBean.get("TargetDialogAskInput_6").toString().trim();
    }

    public static String getTargetDialogAskInput_7() {
        return propertiesFactoryBean.get("TargetDialogAskInput_7").toString().trim();
    }

    public static String getCreateTopicReturns_1() {
        return propertiesFactoryBean.get("CreateTopicReturns_1").toString().trim();
    }


}
