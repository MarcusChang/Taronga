package com.atlassian.test.BPT_Auto.Confluence;

import com.atlassian.test.BPT_Auto.PageFactory.*;
import com.atlassian.test.BPT_Auto.TestParams.BaseTest;
import com.atlassian.test.BPT_Auto.TestParams.ProjectParams;
import com.atlassian.test.BPT_Auto.Utils.*;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Marcus_Chang on 2016/1/11.
 *Latest Updated by Marcus_Chang on 2016/Jan/13.
 */
public class TestCase_SetRestrictions_QuickCreate_On_Chrome extends BaseTest {

    private static WebDriver chromeDriver;
    private static AtlassianCloud_Page_Login AtlassianCloudPageLogin;
    private static Confluence_Page_Dashboard ConfluencePageDashboard;
    private static Confluence_Page_NewBlankPage ConfluencePageNewBlankPage;
    private static Confluence_Page_NewCreatedPage ConfluencePageNewCreatedPage;
    private static Confluence_Page_ConfirmLogoutPage ConfluencePageConfirmLogoutPage;
    private static Confluence_Page_LoggedOutPage ConfluencePageLoggedOutPage;
    private static Confluence_Page_Restrictions ConfluencePageRestrictions;
    private static ReportsUtils report;
    private static ScreenShotTaker capture;
    private static ExtentTest logger;
    private static TestUtilFunctions testUtil;


    @Rule
    public RetryTest retry = new RetryTest(3, chromeDriver, logger, capture);

    @BeforeClass
    public static void init() {
        //create the testUtilFunctions instance
        testUtil = new TestUtilFunctions();
        //initial DriverUtilFunctions.class，set the driver boot path in its constructor
        new DriverUtilFunctions("Chrome");
        DesiredCapabilities chromeCapabilities = testUtil.setChromeDriverProperties();

        //创建一个 Chrome 的浏览器实例
        chromeDriver = new ChromeDriver(chromeCapabilities);
        //create a Chrome browser instance
        report = new ReportsUtils();
        //Create the ScreenShotTaker instance
        capture = new ScreenShotTaker();
        //Begin to log the report details
        logger = report.testLogger("TestCase_SetRestrictions_QuickCreate_On_Chrome");
        //initial LogUtilFunctions.class，set the system level info log configuration by create the class instance
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_SetRestrictions_QuickCreate_On_Chrome", ProjectParams.getTestCase_SetRestrictions_QuickCreate_On_Chrome_LayOut(), ProjectParams.getChromeDriverLocalPath());

        AtlassianCloudPageLogin = new AtlassianCloud_Page_Login();
        ConfluencePageDashboard = new Confluence_Page_Dashboard();
        ConfluencePageNewBlankPage = new Confluence_Page_NewBlankPage();
        ConfluencePageNewCreatedPage = new Confluence_Page_NewCreatedPage();
        ConfluencePageConfirmLogoutPage = new Confluence_Page_ConfirmLogoutPage();
        ConfluencePageLoggedOutPage = new Confluence_Page_LoggedOutPage();
        ConfluencePageRestrictions = new Confluence_Page_Restrictions();

        //Maximize the browser window
        AtlassianCloudPageLogin.MaxPageWindow(chromeDriver);
    }

    @Test
    public void TestAction_SetRestrictions_QuickCreate() {

        //Action 1 : Open the confluence login page
        logger.log(LogStatus.INFO, "Begin the test and open the test login page.");
        AtlassianCloudPageLogin.OpenTargetURL(chromeDriver, ProjectParams.getConfluenceURL());
        //Grab all target web elements on the page : AtlassianCloud_Page_Login
        AtlassianCloudPageLogin.getAtlassianCloudPageLoginElements(chromeDriver);
        //Assert the page title == [Atlassian Cloud]
        Assert.assertTrue(AtlassianCloudPageLogin.Txt_PageTitle.equals("Atlassian Cloud"));
        logger.log(LogStatus.PASS, "Atlassian Cloud Login Page Opened!");
        //Input the user name & pass to login
        AtlassianCloudPageLogin.cleanLoginPageInputTextArea(chromeDriver, testUtil);
        AtlassianCloudPageLogin.Ipt_UserName.sendKeys(ProjectParams.getLoginUserName());
        AtlassianCloudPageLogin.Ipt_PassWord.sendKeys(ProjectParams.getLoginUserPass());
        AtlassianCloudPageLogin.Btn_Login.click();

        //Action 2 : verify the login action
        logger.log(LogStatus.INFO, "Login the Confluence Dashboard and prepare to grab target elements on the page.");
        //Grab all target web elements on the page : Confluence_Page_Dashboard
        ConfluencePageDashboard.getConfluencePageDashboardElements(chromeDriver);
        //Assert the page title == [Dashboard - Confluence]
        Assert.assertTrue(ConfluencePageDashboard.Txt_PageTitle.equals("Dashboard - Confluence"));
        logger.log(LogStatus.PASS, "Login Success! Confluence Dashboard Opened. TestAction_Login -> Finished!");

        //Action 3 : create new pages by Quick Create Button
        logger.log(LogStatus.INFO, "Perform the click on [Quick Create Button]");
        ConfluencePageDashboard.Btn_QuickCreate.click();
        //Grab all target web elements on the page : Confluence_Page_NewBlankPage
        ConfluencePageNewBlankPage.getConfluencePageNewBlankPageElements(chromeDriver);
        //Assert the page title == [Add Page - Confluence-AutoTest-Marcus - Confluence]
        Assert.assertTrue(ConfluencePageNewBlankPage.Txt_PageTitle.equals("Add Page - Confluence-AutoTest-Marcus - Confluence"));
        logger.log(LogStatus.PASS, "Quick Create Button Clicked Success! New Blank Page Opened. TestAction_QuickCreateButtonClick -> Finished!");

        //Action 4 : Input title and body contents on the new blank page and set the Restrictions for InvitedUser then press save button to create the page
        logger.log(LogStatus.INFO, "Begin to input contents on New Blank Page Title and Body.");
        ConfluencePageNewBlankPage.Ipt_ContentTitle.sendKeys(ProjectParams.getChromeSetRestrictionsNewBlankPageTitle());
        ConfluencePageNewBlankPage.setTestCaseSetRestrictionsConfluencePageNewBlankPageMCEbody(chromeDriver);
        logger.log(LogStatus.INFO, "Perform the click on [Restrictions Button]");
        ConfluencePageNewBlankPage.Btn_Restrictions.click();
        //Grab all target web elements on the page : Confluence_Page_Restrictions
        ConfluencePageRestrictions.getConfluencePageRestrictionsElements(chromeDriver);
        //Begin to perform the Restrictions setting actions
        logger.log(LogStatus.INFO, "Performing the Restrictions setting actions.");
        ConfluencePageRestrictions.Drp_RestrictionsList.click();
        ConfluencePageRestrictions.getConfluencePageRestrictionsElements(chromeDriver);
        ConfluencePageRestrictions.Btn_ViewingAndEditingRestricted.click();
        ConfluencePageRestrictions.Ipt_AddUserBar.sendKeys(ProjectParams.getLoginInvitedUserName());
        testUtil.waitForTime(1000);
        ConfluencePageRestrictions.getConfluencePageRestrictionsElements(chromeDriver);
        ConfluencePageRestrictions.Drp_InvitedUser.click();
        ConfluencePageRestrictions.setPermissionSelectorToValue(ProjectParams.getRestrictionsPageSetPermissionSelectorToCanView());
        ConfluencePageRestrictions.Btn_Add.click();
        testUtil.waitForTime(1000);
        ConfluencePageRestrictions.Btn_Apply.click();
        testUtil.waitForTime(1000);
        logger.log(LogStatus.PASS, "The Invited User's Restrictions is set to [Viewing and editing restricted]-[Can View].");
        ConfluencePageNewBlankPage.Btn_Save.click();
        testUtil.waitForTime(1000);
        //Grab all target web elements on the page : Confluence_Page_NewCreatedPage
        ConfluencePageNewCreatedPage.getConfluencePageNewCreatedPageElements(chromeDriver);
        //Assert the page title == [TestCase_SetRestrictions_QuickCreate_On_Chrome Test Title :) - Confluence-AutoTest-Marcus - Confluence]
        Assert.assertTrue(ConfluencePageNewCreatedPage.Txt_PageTitle.equals("TestCase_SetRestrictions_QuickCreate_On_Chrome Test Title :) - Confluence-AutoTest-Marcus - Confluence"));
        logger.log(LogStatus.PASS, "Quick Create New Page Success! TestAction_QuickSetRestrictions -> Finished!");

        //Action 5 : Begin to logout the test
        logger.log(LogStatus.INFO, "Begin to exit the test page.");
        ConfluencePageNewCreatedPage.Btn_CreatedPageUserMenuLink.click();
        ConfluencePageNewCreatedPage.Btn_Logout.click();
        //Grab all target web elements on the page : Confluence_Page_ConfirmLogoutPage
        ConfluencePageConfirmLogoutPage.getConfluencePageConfirmLogoutPageElements(chromeDriver);
        ConfluencePageConfirmLogoutPage.Btn_ConfirmLogout.click();
        //Gran all target web elements on the page : Confluence_Page_LoggedOutPage
        ConfluencePageLoggedOutPage.getConfluencePageLoggedOutPageElements(chromeDriver);
        //Assert the page pop-up == [You are logged out of this Atlassian Cloud instance.]
        Assert.assertTrue(ConfluencePageLoggedOutPage.Pop_AlreadyLoggedOut.getText().equals("You are logged out of this Atlassian Cloud instance."));
        logger.log(LogStatus.PASS, "Logged Out Success! TestAction_LogOut -> Finished!");
        ConfluencePageLoggedOutPage.Btn_ReturnToLoginPage.click();

        //Action 6 : Use the Invited User to login the Confluence
        logger.log(LogStatus.INFO, "Begin to use the Invited User to login the Confluence page.");
        AtlassianCloudPageLogin.getAtlassianCloudPageLoginElements(chromeDriver);
        AtlassianCloudPageLogin.cleanLoginPageInputTextArea(chromeDriver, testUtil);
        AtlassianCloudPageLogin.Ipt_UserName.sendKeys(ProjectParams.getLoginInvitedUserName());
        AtlassianCloudPageLogin.Ipt_PassWord.sendKeys(ProjectParams.getLoginInvitedUserPass());
        AtlassianCloudPageLogin.Btn_Login.click();

        //Action 7 : Operate the click on the invited space to open the target space page
        logger.log(LogStatus.INFO, "Begin to open the restriction set page.");
        ConfluencePageDashboard.getConfluencePageDashboardElements(chromeDriver);
        ConfluencePageDashboard.lnk_RestrictionSetPageLink.click();
        //Assert the target page has no edit option
        ConfluencePageNewCreatedPage.getConfluencePageNewCreatedPageElements(chromeDriver);
        Assert.assertNull(ConfluencePageNewCreatedPage.Lnk_Edit);
        logger.log(LogStatus.PASS, "Restriction for the Invited User verified Success !");

    }


    @AfterClass
    public static void tearDown() {
        report.endTestLogger(logger);
        chromeDriver.quit();
    }


}
