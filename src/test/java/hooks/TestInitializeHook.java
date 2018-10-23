package hooks;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.xml.sax.SAXException;

import base.config.ConfigReader;
import base.config.GlobalSettings;
import base.genericLib_Mob.MobProp;
import base.genericLib_Web.UIProp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


import io.appium.java_client.android.AndroidElement;


public class TestInitializeHook {
	
	ConfigReader config = new ConfigReader();
	
	public  void InitializeSettings() throws Exception
    {
		config.SetFrameworkSettings();
    }

    //Hook Methods For Chrome Drivers
    public static void InitializeDriverAndBrowser()
    {
        if (UIProp.getUIDriver() == null)
        {
        	OpenBrowser();
            setImplicitTimeout(UIProp.getUIDriver(), 15);
            maximizeBrowser(UIProp.getUIDriver());
        }


    }
    
    public static void quitWebDriver()
    {
        if (UIProp.getUIDriver() != null)
        {
        	TestInitializeHook.quitDriver(UIProp.getUIDriver());
        }


    }

    public static void InitializeMobileDriver()
    {
    	
    	
    	if (MobProp.getMobDriver() == null)
        {
            StartMobileAppAppium();
        }

    }


    private static void OpenBrowser()
    {

        try
        {
            switch (GlobalSettings.getBrowser())
            {
                case "Internet Explorer":
                    UIProp.setUIDriver(new InternetExplorerDriver());
                    break;
                case "FireFox":
                	UIProp.setUIDriver(new FirefoxDriver());

                    break;
                case "Chrome":
                	UIProp.setUIDriver(new ChromeDriver());
                    break;
            }
            
            Actions Action = new Actions(UIProp.getUIDriver());
            UIProp.setActions(Action);
        }

        catch (Exception e3)
        {
            System.out.println("UI Driver Invocation encountered an error. ");
            e3.printStackTrace();
        }

    }

    public static void setImplicitTimeout(WebDriver driver, int seconds)
    {
       driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void maximizeBrowser(WebDriver driver)
    {
        driver.manage().window().maximize();
    }


    public static void quitDriver(WebDriver driver)
    {
        try
        {
            driver.quit();
            System.out.printf("Driver was quit sucessfully");
        }
        catch (NullPointerException e)
        {
            System.out.println("Null Driver Reference, no Driver to Quit");
            e.printStackTrace();
        }
    }
    
    /*private static ExtentReports extent;
    private static ExtentTest test;
    private static DateTime reportFolderNameWithDateAndTime = DateTime.Now;
    private static String userName = Environment.UserName;
    private static String dateInString = String.Format("{0:yyyy_MM_dd_HH_mm_ss}", reportFolderNameWithDateAndTime);
    private static String reportLocation = @"C:\Users\" + userName + @"\Downloads\" + dateInString + @"\";
    private static String screenCaptureLocation = @reportLocation + @"ScreenShots\";

    public static void HtmlReportBeforeScenario()
    {
        extent = GetExtent();
        test = extent.StartTest(ScenarioContext.Current.ScenarioInfo.Title);
        test.AssignCategory(FeatureContext.Current.FeatureInfo.Title);
    }

    public static void StartHtmlReporting(String TestTitle, String TestCategory)
    {
        extent = GetExtent();
        test = extent.StartTest(TestTitle);
        test.AssignCategory(TestCategory);
    }



    public static void HtmlReportBeforeEachScenarioStep()
    {
        test.Log(LogStatus.Info, ScenarioContext.Current.StepContext.StepInfo.StepDefinitionType.ToString() + " " + ScenarioContext.Current.StepContext.StepInfo.Text);
    }

    public static void HtmlReportAfterEachScenarioStep()
    {
        if (ScenarioContext.Current.TestError != null)
        {
            var error = ScenarioContext.Current.TestError;
            var errormessage = "<pre>" + error.Message + "</pre>";
            var errorStack = "<pre>" + error.StackTrace + "</pre>";
            test.Log(LogStatus.Fail, ScenarioContext.Current.StepContext.StepInfo.StepDefinitionType.ToString() + " " + ScenarioContext.Current.StepContext.StepInfo.Text + ScenarioContext.Current.StepContext.StepInfo.Table);
            test.Log(LogStatus.Error, errormessage);
            test.Log(LogStatus.Error, errorStack);

            //Attach Screen Shot if Captured
            String screenShotPath = takeScreenShot();
            if (!screenShotPath.Equals(""))
            {
                test.Log(LogStatus.Info, "Screen Shot below: " + test.AddScreenCapture(screenShotPath));
            }

        }

        else
        {
            test.Log(LogStatus.Pass, ScenarioContext.Current.StepContext.StepInfo.StepDefinitionType.ToString() + " " + ScenarioContext.Current.StepContext.StepInfo.Text);
            TryCreateLogForSyncTiming();
        }
    }

    private static void TryCreateLogForSyncTiming()
    {
        if (ScenarioContext.Current.StepContext.StepInfo.Text.Contains("time taken for the sync"))
        {
            test.Log(LogStatus.Pass, $"Time taken on {GlobalSettings.MobilePlatformToRunTest} to sync {GlobalSettings.SyncCount} form/s: {GlobalSettings.SyncTime}");
        }
    }

    public static void HtmlReportAfterScenario()
    {
        extent.Flush();

    }

    public static void EndHTMLReporting()
    {
        extent.Flush();

    }

    public static void ExtentCustomInfoLogger(String TextToLog)
    {
        if (!GlobalSettings.Environment.Equals("Local"))
        {
            test.Log(LogStatus.Info, TextToLog);
        }
    }

    public static void ExtentCustomPassLogger(String TextToLog)
    {
        if (!GlobalSettings.Environment.Equals("Local"))
        {
            test.Log(LogStatus.Pass, TextToLog);
        }
    }

    public static void ExtentCustomWarnLogger(String TextToLog)
    {
        test.Log(LogStatus.Warning, TextToLog);
    }

    private static ExtentReports GetExtent()
    {
        bool reportLocationexists = System.IO.Directory.Exists(reportLocation);

        bool screenshotLocationExits = System.IO.Directory.Exists(screenCaptureLocation);

        if (!reportLocationexists)
        {
            Directory.CreateDirectory(reportLocation);
        }

        if (!screenshotLocationExits)
        {
            Directory.CreateDirectory(screenCaptureLocation);
        }

        if (extent != null)
            return extent; //avoid creating new instance of html file
        extent = new ExtentReports(reportLocation + "PM_TestReport_" + dateInString + ".html", true);
        //extent.LoadConfig(@"C:\Users\sesa473389\Desktop\extent-config.xml");
        return extent;
    }

    //Screen Shot Method

    public static String takeScreenShot()
    {
        String screenShotFullPath = "";
        String[] tagsList = ScenarioContext.Current.ScenarioInfo.Tags;
        WebDriver driver = null;

        if (tagsList.Length > 0)
        {
            for (int i = 0; i < tagsList.Length; i++)
            {
                if (tagsList[i].Equals("UI"))
                {
                     driver = UIProp.UIDriver;

                }
                else if (tagsList[i].Equals("Mobile"))
                {
                     driver = MobProp.MobDriver;
                }

                if (tagsList[i].Equals("UI") || tagsList[i].Equals("Mobile"))
                { 
                    try
                    {
                        Screenshot ss = ((ITakesScreenshot)driver).GetScreenshot();
                        String title = ScenarioContext.Current.ScenarioInfo.Title;
                        String screenShotTitle = title + DateTime.Now.ToString("yyyy-MM-dd-HH_mm_ss");
                        screenShotFullPath = screenCaptureLocation + screenShotTitle + ".jpg";
                        if (Directory.Exists(screenCaptureLocation))
                        {
                            ss.SaveAsFile(screenShotFullPath, ScreenshotImageFormat.Jpeg);
                            break;
                        }

                    }
                    catch (Exception e)
                    {
                        System.out.printf("Error Capturing Screen Shot {0}", e.StackTrace);
                    }
                }

            }
        }
        return screenShotFullPath;
    }


    //Mobile App Intializers Xamarin

    public static void StartMobileAppXamarin()
    {

        switch (GlobalSettings.MobilePlatformToRunTest)
        {
            case "Android":
                MobProp.app = ConfigureApp.Android
                .DeviceSerial("emulator-5554")
                .ApkFile("/system/app/ExactCalculator/ExactCalculator.apk")
                //.InstalledApp("com.android.calculator2")
                .EnableLocalScreenshots()
                .StartApp();
                break;
            case "IOS":
                MobProp.app = ConfigureApp.iOS
                .DeviceIdentifier("f8c67472f88efb1985c2f5e73698d6bb36988f5d")
                .AppBundle(GlobalSettings.IOSMobileAppPath)
                .EnableLocalScreenshots()
                .StartApp();
                break;
        }


    }*/

    //Mobile App Intializers Appium

    public static void StartMobileAppAppium()
    {


        switch (GlobalSettings.getMobilePlatformToRunTest())
        {                    
            case "Android":

                //MobCommonFunctions.RunCmdCommand("/C \"C:\\Users\\sesa473389\\AppData\\Local\\Android\\Sdk\\platform-tools\\\"adb uninstall io.appium.settings");
                //MobCommonFunctions.RunCmdCommand("/C \"C:\\Users\\sesa473389\\AppData\\Local\\Android\\Sdk\\platform-tools\\\"adb uninstall io.appium.unlock");

                DesiredCapabilities AndroidCapabilities = new DesiredCapabilities();
                //AndroidCapabilities.setCapability("device", "My Mi5");
                AndroidCapabilities.setCapability("deviceName", GlobalSettings.getDeviceName());
                AndroidCapabilities.setCapability("platformName", "Android");
                AndroidCapabilities.setCapability("platformVersion", "8.0");
                AndroidCapabilities.setCapability("appPackage", "com.schneiderelectric.worktaskspro");
                AndroidCapabilities.setCapability("noReset", true);            
                //AndroidCapabilities.setCapability("app", GlobalSettings.getAndroidMobileAppPath());
                AndroidCapabilities.setCapability("appActivity", "md53008f3147f8baeda24be77bc62dea917.SplashActivity");
                //AndroidCapabilities.setCapability("autoAcceptAlerts", true);
                AndroidCapabilities.setCapability("unicodeKeyboard", true);
                //AndroidCapabilities.setCapability("forceMjsonwp", true);
                //AndroidCapabilities.setCapability("resetkeyboard", true);
                AndroidCapabilities.setCapability("automationName", "uiautomator2");
                AndroidCapabilities.setCapability("newCommandTimeout", 300);
                //AndroidCapabilities.setCapability("ignoreUnimportantViews", "true");
                //AndroidCapabilities.setCapability("report.disable",true);
                AndroidCapabilities.setCapability("app", GlobalSettings.getAndroidMobileAppPath());
                try
                {
                    MobProp.setMobDriver(new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), AndroidCapabilities));
                }
                catch (Exception e)
                {

                    System.out.printf("%s",e.getMessage());
                    System.out.printf("%s",e.getStackTrace().toString());
                    System.out.printf("Mobile Driver Could not be intitialized");
                }

                break;

            case "IOS":
                DesiredCapabilities IOSCapabilities = new DesiredCapabilities();
                
                
                IOSCapabilities.setCapability("automationName", "XCUITest");
                IOSCapabilities.setCapability("platformName", "iOS");
                IOSCapabilities.setCapability("platformVersion", "11.4.1");
                IOSCapabilities.setCapability("deviceName", "Aveva iPhone");
                IOSCapabilities.setCapability("udid", "32798c6c811f74f62ac6e73c24258f7286484ee2");
                IOSCapabilities.setCapability("noReset", true);
                //IOSCapabilities.setCapability("bundleId", "com.schneiderelectric.worktaskspro");
                IOSCapabilities.setCapability("bundleId", "com.V9S2B6YKKV_com.schneiderelectric.worktaskspro");
                //IOSCapabilities.setCapability("app", "Settings");
                IOSCapabilities.setCapability("clearSystemFiles", true);
                IOSCapabilities.setCapability("forceMjsonwp", true);
                //IOSCapabilities.setCapability("fullReset", true);
                IOSCapabilities.setCapability("newCommandTimeout", 300);
                //IOSCapabilities.setCapability("report.disable", true);
                IOSCapabilities.setCapability("maxTypingFrequency ", 60);
                //IOSCapabilities.setCapability("language", "de");
                //IOSCapabilities.setCapability("locales", "de_DE");
                IOSCapabilities.setCapability("app", GlobalSettings.getIOSMobileAppPath());
                //IOSCapabilities.setCapability("simpleIsVisibleCheck", true);
                
                try
                {
                    MobProp.setMobDriver(new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), IOSCapabilities));
                }
                catch (Exception e)
                {

                    System.out.printf("%s", e.getMessage());
                    System.out.printf("%s",e.getStackTrace().toString());
                    System.out.printf("Mobile Driver Could not be intitialized");
                }
                break;

            case "Windows":

                DesiredCapabilities WindowsCapabilities = new DesiredCapabilities();
                WindowsCapabilities.setCapability("app", "309B0967.WorkTasksPro_7xf3mzjcygx94!App");
                WindowsCapabilities.setCapability("deviceName", "WindowsPC");
                WindowsCapabilities.setCapability("fullReset", "false");
                WindowsCapabilities.setCapability("noReset", "true");

                try
                {
                    
                	MobProp.setMobDriver(new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), WindowsCapabilities));
                }
                catch (Exception e)
                {

                    System.out.printf(e.getMessage());
                    System.out.printf(e.getStackTrace().toString());
                    System.out.printf("Mobile Driver Could not be intitialized");
                }
                break;

        }


        if (!GlobalSettings.getMobilePlatformToRunTest().equals("Windows"))
        {
            //MobProp.getMobDriver(). = "NATIVE_APP";
        }

    }



}
