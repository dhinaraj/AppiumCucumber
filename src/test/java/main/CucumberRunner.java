    package main;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vimalselvam.cucumber.listener.*;

import base.config.GlobalSettings;
import base.genericLib_Mob.MobCommonFunctions;
import base.genericLib_Mob.MobProp;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import hooks.TestInitializeHook;


@CucumberOptions(
		strict = true,
		monochrome = true, 
		features = "src/test/resources/features/WorkTasksPro",
		glue = "stepdefinition",
		//plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"},
		//plugin = {"pretty", "html:target/cucumber-html-report"},
		//dryRun=true)
		tags={"@ReadyForBuild"})

public class CucumberRunner extends AbstractTestNGCucumberTests {
	
	public static String cucumberRelativeReportPath;
	public static String cucumberAbsoluteReportPath;

	 MobCommonFunctions MobCommonFunctions = new MobCommonFunctions();
/*
	public static Properties config = null;
	//public static WebDriver driver = null;

	public void LoadConfigProperty() throws IOException {
		config = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
		config.load(ip);
	}

	public void openBrowser() throws Exception {
		LoadConfigProperty();
		if (config.getProperty("browserType").equals("Firefox")) {

			driver = new FirefoxDriver();
		} else if (config.getProperty("browserType").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src//test//resources//drivers/chromedriver");
			driver = new ChromeDriver();
		}
	}*/

	/*public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void pageLoad(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void setEnv() throws Exception {
		LoadConfigProperty();
		String baseUrl = config.getProperty("siteUrl");
		driver.get(baseUrl);
	}

	public static String currentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String cal1 = dateFormat.format(cal.getTime());
		return cal1;
	}

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		openBrowser();
		maximizeWindow();
		implicitWait(30);
		deleteAllCookies();
		setEnv();
	}

	@AfterClass(alwaysRun = true)
	public void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "//screenshots/screenshot.png"));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDownr(ITestResult result) throws IOException {
		if (result.isSuccess()) {
			File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String failureImageFileName = result.getMethod().getMethodName()
					+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
			File failureImageFile = new File(System.getProperty("user.dir") + "//screenshots//" + failureImageFileName);
			FileUtils.copyFile(imageFile, failureImageFile);
		}

	}

	@AfterSuite(alwaysRun = true)
	public void quit() throws IOException, InterruptedException {
		driver.quit();
	}*/

	TestInitializeHook mainHook = new TestInitializeHook();
	
	public boolean initializeDriver(int retryCount)
	{

		boolean isDriverInitialized = false;
		for (int i = 0; i <= retryCount; i++) {

			try {
				System.out.println("Driver intializaion Attempt :  " + i);
				
				TestInitializeHook.InitializeMobileDriver();
				if(MobProp.getMobDriver()!=null)
				{
					isDriverInitialized = true;
				}

			} catch (Exception e) {
				System.out.println("Driver intializaion failed");
				e.printStackTrace();
			}
			
			if(isDriverInitialized)
			{
				System.out.println("Driver intializaion Attempt :  " + i + "Sucessful");
				break;
			}
			else
			{
				System.out.println("Driver intializaion Attempt :  " + i + "Failed");
			}
		}

		return isDriverInitialized;
	}
	
	
	public static String currentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String cal1 = dateFormat.format(cal.getTime());
		return cal1;
	}

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {

		mainHook.InitializeSettings();
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyy_HH_mm_ss");
		 Date date = new Date();
		String strDate = dateFormat.format(date);
		cucumberRelativeReportPath = "cucumber-reports"+strDate;
		cucumberAbsoluteReportPath = System.getProperty("user.dir") + "/target/" + cucumberRelativeReportPath;
		new File(cucumberAbsoluteReportPath +"/screenshots").mkdirs();

	}
	
	@BeforeClass(alwaysRun = true)
	public void initializeMobileAppBeforeClass() throws IOException {
		
		if(GlobalSettings.getMobilePlatformToRunTest().equals("Android"))
		{
			//MobCommonFunctions.RunCmdCommand("adb uninstall com.schneiderelectric.worktaskspro");
			MobCommonFunctions.changeDeviceLanguage("en", "US");
		}
		
		if(GlobalSettings.getGenrateStepsSkeleton().equals("false"))
		{

				boolean isDriverInitialized = initializeDriver(3);
				if(isDriverInitialized)
				{
				TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), 15);
				}

				ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		        extentProperties.setReportPath(cucumberAbsoluteReportPath+"/report.html");

		}
		
		
	}	
	
	
	@BeforeMethod(alwaysRun = true)
	public void initializeMobileAppBeforeMethod() throws IOException {

		if (GlobalSettings.getGenrateStepsSkeleton().equals("false")) {
			
			if (MobProp.getMobDriver() == null) {
				boolean isDriverInitialized = initializeDriver(3);
				if (isDriverInitialized) {
					TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), 15);
				}
			} else if (MobProp.getMobDriver().getSessionId() == null) {
				TestInitializeHook.quitDriver(MobProp.getMobDriver());
				boolean isDriverInitialized = initializeDriver(3);
				if (isDriverInitialized) {
					TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), 15);
				}

			}
			TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), 15);
		}

	}
	

	@AfterClass(alwaysRun = true)
	public void quitMobileAppAndtakeScreenshot() throws IOException {
		if(GlobalSettings.getGenrateStepsSkeleton().equals("false"))
		{
		if (MobProp.getMobDriver() != null) {
		TestInitializeHook.quitDriver(MobProp.getMobDriver());
        }
		}
	}
	
	

	
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() throws Exception {
		if(GlobalSettings.getGenrateStepsSkeleton().equals("false"))
		{
		Reporter.loadXMLConfig(new File("src/test/resources/config/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("WorkTasksPro UI Test Report");
        if (MobProp.getMobDriver() != null) {
        	TestInitializeHook.quitDriver(MobProp.getMobDriver());
        }
		}

	}
	

}

