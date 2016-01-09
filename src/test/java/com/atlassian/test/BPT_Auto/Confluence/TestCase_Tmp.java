package com.atlassian.test.BPT_Auto.Confluence;

import com.atlassian.test.BPT_Auto.TestParams.BaseTest;
import com.atlassian.test.BPT_Auto.Utils.*;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Marcus_Chang on 2016/1/8.
 */
public class TestCase_Tmp extends BaseTest{

    public static int i = 0;
    private static ExtentReports extent;

    @Rule
    public RetryTest retry = new RetryTest(3);

    @Test
    public void testTmp_01() {

        //create the testUtilFunctions instance
        TestUtilFunctions testUtil = new TestUtilFunctions();

        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("Chrome");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");

        ReportsUtils report = new ReportsUtils();

//        extent = new ExtentReports("C:\\Users\\Marcus_Chang\\Desktop\\TarongaTestReport\\TestReport-BPT-" + TestUtilFunctions.getDateTime() + ".html", false, DisplayOrder.NEWEST_FIRST);
//        ExtentTest logger = extent.startTest("begin the test");
        ExtentTest logger = report.testLogger("Atlassian BPT Begin");
        ScreenShotTaker Capture = new ScreenShotTaker();
        Capture.takeScreenShot(driver);
        System.out.println("testing...1");
        Assert.assertTrue(++i == 3);
        logger.log(LogStatus.PASS, "i == 3");
        report.endTestLogger(logger);
//        extent.endTest(logger);
//        extent.flush();
    }

}
