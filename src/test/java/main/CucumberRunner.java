package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import base.genericLib_Mob.MobProp;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import hooks.TestInitializeHook;

@CucumberOptions(
		strict = true,
		monochrome = true, 
		features = "src/test/resources/",
		glue = "stepdefinition",
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})
		//dryRun=true)//,
		//tags={"@Regression,@JunitScenario,@TestngScenario"})

public class CucumberRunner extends AbstractTestNGCucumberTests {
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
	
	public void initializeDriver(int retryCount)
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
				TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), 15);
				break;
			}
			else
			{
				System.out.println("Driver intializaion Attempt :  " + i + "Failed");
			}

		}
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

	}
	
	@BeforeClass(alwaysRun = true)
	public void initializeMobileAppBeforeClass() throws IOException {
		
		initializeDriver(3);
		
	}	
	
	
	@BeforeMethod(alwaysRun = true)
	public void initializeMobileAppBeforeMethod() throws IOException {

		if(MobProp.getMobDriver()==null )
		{
			initializeDriver(3);
		}
		else if(MobProp.getMobDriver().getSessionId()==null) {
			TestInitializeHook.quitDriver(MobProp.getMobDriver());
			initializeDriver(3);
			
		}
		
	}


	@AfterClass(alwaysRun = true)
	public void quitMobileAppAndtakeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) MobProp.getMobDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "//screenshots/screenshot.png"));
		TestInitializeHook.quitDriver(MobProp.getMobDriver());

	}

	@AfterMethod(alwaysRun = true)
	public void tearDownr(ITestResult result) throws IOException {
		if (result.isSuccess()) {
			File imageFile = ((TakesScreenshot) MobProp.getMobDriver()).getScreenshotAs(OutputType.FILE);
			String failureImageFileName = result.getMethod().getMethodName()
					+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
			File failureImageFile = new File(System.getProperty("user.dir") + "//screenshots//" + failureImageFileName);
			FileUtils.copyFile(imageFile, failureImageFile);
		}

	}

	@AfterSuite(alwaysRun = true)
	public void quit() throws IOException, InterruptedException {
 
	}
}
