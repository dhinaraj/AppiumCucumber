package base.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;

import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

public class ConfigReader {
	
	
     
     static String workingDir = System.getProperty("user.dir");
     
     
     public static Properties config = null;
 	//public static WebDriver driver = null;

 	public void LoadConfigProperty() throws IOException {
 		config = new Properties();
 		FileInputStream ip = new FileInputStream(
 				System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
 		config.load(ip);
 	}


     public  void SetFrameworkSettings() throws Exception
     {
    	 
    	 LoadConfigProperty();
    	 System.out.printf("Base Folder %s %n", workingDir);
         String strFilename = workingDir + "//src//test//resources//config//config.properties";
         
         System.out.printf("Filepath %s %n", strFilename);
         
         GlobalSettings.setTypeOfTest(config.getProperty("TyepOFTest"));
         
         GlobalSettings.setWebAppUrl(config.getProperty("webAppUrl"));
         GlobalSettings.setSkeltaServer(config.getProperty("SkeltaServer"));

         GlobalSettings.setUserName(config.getProperty("Username"));
         GlobalSettings.setPassword(config.getProperty("Password"));

         GlobalSettings.setRepoName(config.getProperty("MobileAutTesting"));

         GlobalSettings.setBrowser(config.getProperty("Browser"));

         GlobalSettings.setChromeDriverLocation(workingDir + "\\Base\\GenericLib_UI\\BrowserDriver\\");



         GlobalSettings.setMobilePlatformToRunTest(config.getProperty("MobilePlatformToRunTest"));
         GlobalSettings.setAndroidMobileAppPath(workingDir + "\\Base\\GenericLib_Mobile\\MobileAppFiles\\" +config.getProperty("AndroidAPK") );
         GlobalSettings.setIOSMobileAppPath(workingDir + "\\Base\\GenericLib_Mobile\\MobileAppFiles\\" + config.getProperty("IosApp"));

         GlobalSettings.setDeviceName(config.getProperty("DeviceName"));

         ////GlobalSettings.setEnvironment(config.getProperty("Browser"));

         GlobalSettings.setImplcitTimeOutMin(Integer.parseInt(config.getProperty("setImplcitTimeOutMin")));
         GlobalSettings.setImplcitTimeOutMax(Integer.parseInt(config.getProperty("setImplcitTimeOutMax")));
    	 

     }




}
