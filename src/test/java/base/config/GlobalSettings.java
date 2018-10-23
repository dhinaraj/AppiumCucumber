package base.config;

public class GlobalSettings {
	
	private static String typeOfTest ;

	private static String skeltaServer ;

	private static String userName ;
	private static String password ;

	private static String repoName ;

	private static String browser ;

	private static String webAppUrl ;
	
	private static String testRepoName ;
	
	private static String httpUrl ;
	
	private static String httpsUrl ;
	
	private static String azureServiceBusUrl ;

    //public static SqlConnection SketlaSQLConnection ;

    private static String chromeDriverLocation ;


    public static String MobilePlatformToRunTest ;
    private static String AndroidMobileAppPath ;

    private static String IOSMobileAppPath ;

    private static String DeviceName ;

	private static String SyncTime ;
    private static int SyncCount ;

    private static String Environment ;

    private static int implcitTimeOutMin;
	private static int implcitTimeOutMax ;
	
	private static String extentReportConfig;
	
	private static String GenrateStepsSkeleton;
    
    

	public static String getTypeOfTest() {
		return typeOfTest;
	}

	public static void setTypeOfTest(String typeOfTest) {
		GlobalSettings.typeOfTest = typeOfTest;
	}

	public static String getSkeltaServer() {
		return skeltaServer;
	}

	public static void setSkeltaServer(String skeltaServer) {
		GlobalSettings.skeltaServer = skeltaServer;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		GlobalSettings.userName = userName;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		GlobalSettings.password = password;
	}

	public static String getRepoName() {
		return repoName;
	}

	public static void setRepoName(String repoName) {
		GlobalSettings.repoName = repoName;
	}

	public static String getBrowser() {
		return browser;
	}

	public static void setBrowser(String browser) {
		GlobalSettings.browser = browser;
	}

	public static String getWebAppUrl() {
		return webAppUrl;
	}

	public static void setWebAppUrl(String webAppUrl) {
		GlobalSettings.webAppUrl = webAppUrl;
	}

	public static String getChromeDriverLocation() {
		return chromeDriverLocation;
	}

	public static void setChromeDriverLocation(String chromeDriverLocation) {
		GlobalSettings.chromeDriverLocation = chromeDriverLocation;
	}

	public static String getMobilePlatformToRunTest() {
		return MobilePlatformToRunTest;
	}

	public static void setMobilePlatformToRunTest(String mobilePlatformToRunTest) {
		MobilePlatformToRunTest = mobilePlatformToRunTest;
	}

	public static String getAndroidMobileAppPath() {
		return AndroidMobileAppPath;
	}

	public static void setAndroidMobileAppPath(String androidMobileAppPath) {
		AndroidMobileAppPath = androidMobileAppPath;
	}

	public static String getIOSMobileAppPath() {
		return IOSMobileAppPath;
	}

	public static void setIOSMobileAppPath(String iOSMobileAppPath) {
		IOSMobileAppPath = iOSMobileAppPath;
	}

	public static String getDeviceName() {
		return DeviceName;
	}

	public static void setDeviceName(String deviceName) {
		DeviceName = deviceName;
	}

	public static String getSyncTime() {
		return SyncTime;
	}

	public static void setSyncTime(String syncTime) {
		SyncTime = syncTime;
	}

	public static int getSyncCount() {
		return SyncCount;
	}

	public static void setSyncCount(int syncCount) {
		SyncCount = syncCount;
	}

	public static String getEnvironment() {
		return Environment;
	}

	public static void setEnvironment(String environment) {
		Environment = environment;
	}

	public static int getImplcitTimeOutMin() {
		return implcitTimeOutMin;
	}

	public static void setImplcitTimeOutMin(int implTimeOutMin) {
		implcitTimeOutMin = implTimeOutMin;
	}

	public static int getImplcitTimeOutMax() {
		return implcitTimeOutMax;
	}

	public static void setImplcitTimeOutMax(int implTimeOutMax) {
		implcitTimeOutMax = implTimeOutMax;
	}

	public static String getExtentReportConfig() {
		return extentReportConfig;
	}

	public static void setExtentReportConfig(String extentRepConfig) {
		extentReportConfig = extentRepConfig;
	}

	public static String getGenrateStepsSkeleton() {
		return GenrateStepsSkeleton;
	}

	public static void setGenrateStepsSkeleton(String genrateStepsSkeleton) {
		GenrateStepsSkeleton = genrateStepsSkeleton;
	}

	public static String getHttpUrl() {
		return httpUrl;
	}

	public static void setHttpUrl(String httpUrl) {
		GlobalSettings.httpUrl = httpUrl;
	}

	public static String getHttpsUrl() {
		return httpsUrl;
	}

	public static void setHttpsUrl(String httpsUrl) {
		GlobalSettings.httpsUrl = httpsUrl;
	}

	public static String getAzureServiceBusUrl() {
		return azureServiceBusUrl;
	}

	public static void setAzureServiceBusUrl(String azureServiceBusUrl) {
		GlobalSettings.azureServiceBusUrl = azureServiceBusUrl;
	}

	public static String getTestRepoName() {
		return testRepoName;
	}

	public static void setTestRepoName(String testRepoName) {
		GlobalSettings.testRepoName = testRepoName;
	}  
    
    

}
