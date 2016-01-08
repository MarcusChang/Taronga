package com.atlassian.test.BPT_Auto.Utils;

import com.atlassian.test.BPT_Auto.TestParams.ProjectParams;

/**
 * Created by Marcus_Chang on 2016/Jan/07.
 * Latest Updated by Marcus_Chang on 2016/Jan/08.
 */
public class DriverUtilFunctions {
    public DriverUtilFunctions(String driver){

        if (driver != null && driver.equals("Chrome")){
            // 设置 chrome 的路径
            System.setProperty("webdriver.chrome.driver", ProjectParams.getChromeDriverLocalPath());
        }
        else if (driver != null && driver.equals("Firefox")){
            // 设置 Firefox 的路径
            System.setProperty("webdriver.firefox.bin", ProjectParams.getFireFoxDriverLocalPath());
        }
        else if (driver != null && driver.equals("IE")){
            // 设置 IE 的路径
            System.setProperty("webdriver.ie.driver", ProjectParams.getIEDriverLocalPath());
        }

    }
}
