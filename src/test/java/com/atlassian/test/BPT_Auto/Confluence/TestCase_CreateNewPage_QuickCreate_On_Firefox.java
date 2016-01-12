package com.atlassian.test.BPT_Auto.Confluence;

import com.atlassian.test.BPT_Auto.PageFactory.*;
import com.atlassian.test.BPT_Auto.TestParams.BaseTest;
import com.atlassian.test.BPT_Auto.TestParams.ProjectParams;
import com.atlassian.test.BPT_Auto.Utils.*;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Marcus_Chang on 2016/1/11.
 */
public class TestCase_CreateNewPage_QuickCreate_On_Firefox extends BaseTest {

    private static WebDriver firefoxDriver;
    private static AtlassianCloud_Page_Login AtlassianCloudPageLogin;
    private static Confluence_Page_Dashboard ConfluencePageDashboard;
    private static Confluence_Page_NewBlankPage ConfluencePageNewBlankPage;
    private static Confluence_Page_NewCreatedPage ConfluencePageNewCreatedPage;
    private static Confluence_Page_ConfirmLogoutPage ConfluencePageConfirmLogoutPage;
    private static Confluence_Page_LoggedOutPage ConfluencePageLoggedOutPage;
    private static ReportsUtils report;
    private static ScreenShotTaker capture;
    private static ExtentTest logger;
    private static TestUtilFunctions testUtil;


    @Rule
    public RetryTest retry = new RetryTest(3, firefoxDriver, logger, capture);

    @BeforeClass
    public static void init() {
        //create the testUtilFunctions instance
        testUtil = new TestUtilFunctions();
        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("Firefox");
        DesiredCapabilities firefoxCapabilities = testUtil.setFirefoxDriverProperties();
        //创建一个 Firefox 的浏览器实例
        firefoxDriver = new FirefoxDriver(firefoxCapabilities);
        //Create the ReportsUtils instance
        report = new ReportsUtils();
        //Create the ScreenShotTaker instance
        capture = new ScreenShotTaker();
        //Begin to log the report details
        logger = report.testLogger("TestCase_CreateNewPage_QuickCreate_On_Firefox");
        //初始化LogUtilFunctions类，创建此类实例并设置当前测试用例的日志配置
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_CreateNewPage_QuickCreate_On_Firefox", ProjectParams.getTestCase_CreateNewPage_QuickCreate_On_Firefox_LayOut(), ProjectParams.getFireFoxDriverLocalPath());

        AtlassianCloudPageLogin = new AtlassianCloud_Page_Login();
        ConfluencePageDashboard = new Confluence_Page_Dashboard();
        ConfluencePageNewBlankPage = new Confluence_Page_NewBlankPage();
        ConfluencePageNewCreatedPage = new Confluence_Page_NewCreatedPage();
        ConfluencePageConfirmLogoutPage = new Confluence_Page_ConfirmLogoutPage();
        ConfluencePageLoggedOutPage = new Confluence_Page_LoggedOutPage();

        //最大化浏览器窗口
        AtlassianCloudPageLogin.MaxPageWindow(firefoxDriver);
    }

    @Test
    public void TestAction_CreateNewPage_QuickCreate() {

        //Action 1 : Open the confluence login page
        logger.log(LogStatus.INFO, "Begin the test and open the test login page.");
        AtlassianCloudPageLogin.OpenTargetURL(firefoxDriver, ProjectParams.getConfluenceURL());
        //Grab all target web elements on the page : AtlassianCloud_Page_Login
        AtlassianCloudPageLogin.getAtlassianCloudPageLoginElements(firefoxDriver);
        //Assert the page title == [Atlassian Cloud]
        Assert.assertTrue(AtlassianCloudPageLogin.Txt_PageTitle.equals("Atlassian Cloud"));
        logger.log(LogStatus.PASS, "Atlassian Cloud Login Page Opened!");
        //Input the user name & pass to login
        AtlassianCloudPageLogin.cleanLoginPageInputTextArea(firefoxDriver, testUtil);
        AtlassianCloudPageLogin.Ipt_UserName.sendKeys(ProjectParams.getLoginUserName());
        AtlassianCloudPageLogin.Ipt_PassWord.sendKeys(ProjectParams.getLoginUserPass());
        AtlassianCloudPageLogin.Btn_Login.click();

        //Action 2 : verify the login action
        logger.log(LogStatus.INFO, "Login the Confluence Dashboard and prepare to grab target elements on the page.");
        //Grab all target web elements on the page : Confluence_Page_Dashboard
        ConfluencePageDashboard.getConfluencePageDashboardElements(firefoxDriver);
        //Assert the page title == [Dashboard - Confluence]
        Assert.assertTrue(ConfluencePageDashboard.Txt_PageTitle.equals("Dashboard - Confluence"));
        logger.log(LogStatus.PASS, "Login Success! Confluence Dashboard Opened. TestAction_Login -> Finished!");

        //Action 3 : create new pages by Quick Create Button
        logger.log(LogStatus.INFO, "Perform the click on [Quick Create Button]");
        ConfluencePageDashboard.Btn_QuickCreate.click();
        //Grab all target web elements on the page : Confluence_Page_NewBlankPage
        ConfluencePageNewBlankPage.getConfluencePageNewBlankPageElements(firefoxDriver);
        //Assert the page title == [Add Page - Confluence-AutoTest-Marcus - Confluence]
        Assert.assertTrue(ConfluencePageNewBlankPage.Txt_PageTitle.equals("Add Page - Confluence-AutoTest-Marcus - Confluence"));
        logger.log(LogStatus.PASS, "Quick Create Button Clicked Success! New Blank Page Opened. TestAction_QuickCreateButtonClick -> Finished!");

        //Action 4 : Input title and body contents on the new blank page and press save button to create the page
        logger.log(LogStatus.INFO, "Begin to input contents on New Blank Page Title and Body.");
        ConfluencePageNewBlankPage.Ipt_ContentTitle.sendKeys(ProjectParams.getFirefoxQuickCreateNewBlankPageTitle());
        ConfluencePageNewBlankPage.setConfluencePageNewBlankPageMCEbody(firefoxDriver);
        ConfluencePageNewBlankPage.Btn_Save.click();

        //Grab all target web elements on the page : Confluence_Page_NewCreatedPage
        ConfluencePageNewCreatedPage.getConfluencePageNewCreatedPageElements(firefoxDriver);
        //Assert the page title == [TestCase_CreateNewPage_QuickCreate_On_Firefox Test Title :) - Confluence-AutoTest-Marcus - Confluence]
        Assert.assertTrue(ConfluencePageNewCreatedPage.Txt_PageTitle.equals("TestCase_CreateNewPage_QuickCreate_On_Firefox Test Title :) - Confluence-AutoTest-Marcus - Confluence"));
        logger.log(LogStatus.PASS, "Quick Create New Page Success! TestAction_QuickCreateNewPage -> Finished!");

        //Action 5 : Begin to logout the test
        logger.log(LogStatus.INFO, "Begin to exit the test page.");
        ConfluencePageNewCreatedPage.Btn_CreatedPageUserMenuLink.click();
        ConfluencePageNewCreatedPage.Btn_Logout.click();
        //Grab all target web elements on the page : Confluence_Page_ConfirmLogoutPage
        ConfluencePageConfirmLogoutPage.getConfluencePageConfirmLogoutPageElements(firefoxDriver);
        ConfluencePageConfirmLogoutPage.Btn_ConfirmLogout.click();
        //Gran all target web elements on the page : Confluence_Page_LoggedOutPage
        ConfluencePageLoggedOutPage.getConfluencePageLoggedOutPageElements(firefoxDriver);
        //Assert the page pop-up == [You are logged out of this Atlassian Cloud instance.]
        Assert.assertTrue(ConfluencePageLoggedOutPage.Pop_AlreadyLoggedOut.getText().equals("You are logged out of this Atlassian Cloud instance."));
        logger.log(LogStatus.PASS, "Logged Out Success! TestAction_LogOut -> Finished!");

    }


    @AfterClass
    public static void tearDown() {
        report.endTestLogger(logger);
        firefoxDriver.quit();
    }


}
