package com.atlassian.test.BPT_Auto.Utils;

import java.io.File;
import java.io.IOException;

import com.atlassian.test.BPT_Auto.TestParams.ProjectParams;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


/**
 * Created by Marcus_Chang on 2016/Jan/9.
 */
public class ScreenShotTaker {

    public void takeScreenShot(WebDriver driver) {

        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(ProjectParams.getScreenShotsPath() + TestUtilFunctions.getDateTime() + ProjectParams.getScreenShotsFormat()));
        }
        catch (IOException e) {System.out.println(e.getMessage());}
    }

}

