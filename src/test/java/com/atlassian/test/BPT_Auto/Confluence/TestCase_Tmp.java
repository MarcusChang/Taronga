package com.atlassian.test.BPT_Auto.Confluence;

import com.atlassian.test.BPT_Auto.PageFactory.Libra_Page_Index;
import com.atlassian.test.BPT_Auto.PageFactory.Libra_Page_PreIndex;
import com.atlassian.test.BPT_Auto.TestParams.BaseTest;
import com.atlassian.test.BPT_Auto.TestParams.ProjectParams;
import com.atlassian.test.BPT_Auto.Utils.*;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Marcus_Chang on 2016/1/8.
 */
public class TestCase_Tmp extends BaseTest{

    public static int i = 0;
    private static ExtentReports extent;
    private static WebDriver chromeDriver;
    private static Libra_Page_Index libraPageIndex;
    private static Libra_Page_PreIndex libraPagePreIndex;
    private static ReportsUtils report;
    private static ScreenShotTaker capture;
    private static ExtentTest logger;

    @Rule
    public RetryTest retry = new RetryTest(3, chromeDriver, logger, capture);

    @BeforeClass
    public static void init() {
        //create the testUtilFunctions instance
        TestUtilFunctions testUtil = new TestUtilFunctions();

        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("Chrome");

        // 创建一个 Chrome 的浏览器实例
        chromeDriver = new ChromeDriver();

        report = new ReportsUtils();

        capture = new ScreenShotTaker();

        logger = report.testLogger("--testTmp_01 Begin--");

        //初始化LogUtilFunctions类，创建此类实例并设置当前测试用例的日志配置
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_Tmp", ProjectParams.getChromeTest_167543_HomePage_LayOut(), ProjectParams.getChromeDriverLocalPath());

        libraPagePreIndex = new Libra_Page_PreIndex();
        libraPageIndex = new Libra_Page_Index();

        //最大化浏览器窗口
        libraPagePreIndex.MaxPageWindow(chromeDriver);
    }


    @Test
    public void testTmp_01() {

            // 让浏览器访问 Libra 京友邦首页
            libraPagePreIndex.OpenTargetURL(chromeDriver, "http://www.baidu.com");
            Assert.assertTrue(++i == 4);
            logger.log(LogStatus.PASS, "i == 3");

    }

    @AfterClass
    public static void tearDown() {
        report.endTestLogger(logger);
        chromeDriver.quit();
    }

}
