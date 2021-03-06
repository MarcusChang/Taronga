package com.atlassian.test.BPT_Auto.Utils;

import com.atlassian.test.BPT_Auto.TestParams.ProjectParams;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * Created by Marcus_Chang on 2016/Jan/10.
 */
public class ReportsUtils {

    private static ExtentReports extent;

    public ExtentTest testLogger(String testName) {
        extent = new ExtentReports(ProjectParams.getExtentReportsPath() + TestUtilFunctions.getDateTime() + ".html", false, DisplayOrder.NEWEST_FIRST);
        return extent.startTest(testName);
    }

    public ExtentTest testLogger(String testName, String description) {
        extent = new ExtentReports(ProjectParams.getExtentReportsPath() + TestUtilFunctions.getDateTime() + ".html", false, DisplayOrder.NEWEST_FIRST);
        return extent.startTest(testName, description);
    }

    public void endTestLogger(ExtentTest testlogger) {
        extent.endTest(testlogger);
        extent.flush();
        extent.close();
    }

}
