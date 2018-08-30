package base.genericLib_Mob;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.config.GlobalSettings;
import hooks.TestInitializeHook;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MobileAppiumFunctions {
	
	
	 public static boolean isElementPresent(MobileElement element)
     {
         boolean foundElement = false;
         WebDriverWait wait = new WebDriverWait(MobProp.getMobDriver(), 3);
         try
         {
             wait.until(ExpectedConditions.elementToBeClickable(element));
             foundElement = true;
         }
         catch (WebDriverException eTO)
         {
             foundElement = false;
         }
         return foundElement;
     }

     public static boolean isDialogPresent(WebDriver driver)
     {
         boolean foundalert = false;

         WebDriverWait wait = new WebDriverWait(driver, 5);
         try
         {

             wait.until(ExpectedConditions.alertIsPresent());
             foundalert = true;
         }
         catch (WebDriverException eTO)
         {
             foundalert = false;
         }

         return foundalert;
     }

     public static void switchToalertAndaccept()
     {
         MobProp.getMobDriver().switchTo().alert().accept();
     }


     public static void switchToframeMobileElement(MobileElement element)
     {
         MobProp.getMobDriver().switchTo().frame(element);
     }

     public static void MoveToMobileElement(MobileElement element)
     {
         Actions action = new Actions(MobProp.getMobDriver());
         action.moveToElement(element).perform();
     }

     public static void waituntilElementclickable(MobileElement element)
     {
         //WebDriver driver = GetDriver();

         if(MobProp.getMobDriver() != null)
         { 

         new WebDriverWait(MobProp.getMobDriver(), 50)
         .until(ExpectedConditions.elementToBeClickable(element));
         }
         else if (MobProp.getMobDriver() != null)
         {
             new WebDriverWait(MobProp.getMobDriver(), 50)
             .until(ExpectedConditions.elementToBeClickable(element));
         }

     }

     public static void waituntilElementIsInvisible(String xpath, int seconds)
     {
       
         TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), seconds);

         WebDriverWait wait = new WebDriverWait(MobProp.getMobDriver(), seconds);
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));

         TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
     }

     public static void waituntilElementIsNoLongerInDom(MobileElement element, int seconds)
     {

         TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), seconds);

         WebDriverWait wait = new WebDriverWait(MobProp.getMobDriver(), seconds);
         wait.until(ExpectedConditions.stalenessOf(element));

         TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
     }



     public static void waituntilElementIsVisible(MobileElement element, int seconds)
     {
         if (MobProp.getMobDriver() != null)
         {
             TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), seconds);

             WebDriverWait wait = new WebDriverWait(MobProp.getMobDriver(), seconds);
             wait.until(ExpectedConditions.visibilityOf(element));
             TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
         }
         else if (MobProp.getMobDriver() != null)
         {

         TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), seconds);

         WebDriverWait wait = new WebDriverWait(MobProp.getMobDriver(), seconds);
         switch (GlobalSettings.MobilePlatformToRunTest)
         {
             default:
                 wait.until(ExpectedConditions.visibilityOf(element));
                 break;
         }

         TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
			}

     }

     public static void waituntilElementExists(String identifier, int seconds)
     {
         WebDriverWait wait = new WebDriverWait(MobProp.getMobDriver(), seconds);
         switch (GlobalSettings.MobilePlatformToRunTest)
         {
             default:
                 TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), seconds);
                 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(identifier)));
                 break;
         }

         TestInitializeHook.setImplicitTimeout(MobProp.getMobDriver(), GlobalSettings.getImplcitTimeOutMax());
     }

     public static void getWindowHandles()
     {
         String expectedTitle = "";
         WebDriver popup = null;
         String mainWindow = MobProp.getMobDriver().getWindowHandle();
         boolean foundPopupTitle = false;
         Set<String> windowHandles = MobProp.getMobDriver().getWindowHandles();
         for(String handle : windowHandles)
         {
             popup = MobProp.getMobDriver().switchTo().window(handle);
             if (popup.getTitle().contains(expectedTitle))
             {
                 foundPopupTitle = true;
                 break;
             }
         }

         if (foundPopupTitle)
         {
             popup.close();
         }
         //switch back to original window
         MobProp.getMobDriver().switchTo().window(mainWindow);
     }

     public static void switchToWindowHandleNextChildWindow()
     {
         String mainWindow = MobProp.getMobDriver().getWindowHandle();
         Set<String> windowHandles = MobProp.getMobDriver().getWindowHandles();
         for(String handle : windowHandles)
         {
             MobProp.getMobDriver().switchTo().window(handle);
         }
     }

     public static void switchToWindowHandleWithSpecificTitle(String Title)
     {
         //String expectedTitle = "";
         WebDriver popup = null;
         try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         String mainWindow = MobProp.getMobDriver().getWindowHandle();
         boolean foundPopupTitle = false;
         Set<String> windowHandles = MobProp.getMobDriver().getWindowHandles();
         for(String handle : windowHandles)
         {
             popup = MobProp.getMobDriver().switchTo().window(handle);
             String popupTitle = popup.getTitle();
             if (popupTitle.contains(Title))
             {
                 System.out.print("Preview Window Opened Sucessfully");
                 foundPopupTitle = true;
                 break;
             }
         }

         //if (foundPopupTitle)
         //{
         //    popup.Close();
         //}
         //switch back to original window
         //MobProp.getMobDriver().switchTo().Window(mainWindow);
     }


/*     public static void enableCheckBox(MobileElement checkbox, boolean available)
     {
         
         String availstatus = checkbox.getAttribute("checked");

         if(availstatus==null)
         { 
         boolean checkIfCheckBoxIsSelected = checkbox.isSelected();
             availstatus = checkIfCheckBoxIsSelected.ToString();
         }
         String expectedStatus = available.ToString();
         //this is used to verify if checkbox is checked, if not it will adjust accordingly
         if (!availstatus.Equals(expectedStatus, StringComparison.CurrentCultureIgnoreCase))
         {
             checkbox.click();
         }

     }*/


     public static boolean checkIfElementPresentAndclickable(MobileElement element)
     {
         WebDriver driver = MobProp.getMobDriver();

         try
         {
             new WebDriverWait(driver, 3)
         .until(ExpectedConditions.elementToBeClickable(element));
             return true;
         }

         catch (Exception e)
         {

             return false;
         }
     }

     public static void switchTodefaultContent()
     {
         MobProp.getMobDriver().switchTo().defaultContent();
     }


     public static void Action_moveToElementAndclick(MobileElement element)
     {
         Actions actions = new Actions(MobProp.getMobDriver());
         actions.moveToElement(element);
         actions.click();
         actions.build().perform();
     }

     public static boolean checkIfElementIsDisplayedAndEnabled(MobileElement element)
     {
         boolean isButtonDisplayedAndEnabled = false;

         if (element.isDisplayed() && element.isEnabled())
         {
             isButtonDisplayedAndEnabled = true;
         }

         return isButtonDisplayedAndEnabled;
     }
     
     
     public static void swipe(int startx, int starty, int endx, int endy, int duration) { // Android ONLY!
         System.out.println("    swipe(" + startx + ", " + starty + ", " + endx + ", " + endy + ")");
         new TouchAction((MobProp.getMobDriver())).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();
     }
     
     
 	public static void scroll(MobileElement startElement, MobileElement endElement) {
	    TouchAction touchAction = new TouchAction(MobProp.getMobDriver());
	    
	    Point firstElementLocation = startElement.getLocation();
	    Point secondElementLocation = endElement.getLocation();

	    touchAction.tap(PointOption.point(firstElementLocation.x, firstElementLocation.y)).moveTo(PointOption.point(secondElementLocation.x, secondElementLocation.y)).release().perform();
	}
	
 	public static void horizontalSwipeByPercentages() {
		
		Dimension size = MobProp.getMobDriver().manage().window().getSize();
		int endPoint = (int) (size.width * 0.05);
		int startPoint = (int) (size.width * 0.95);
		int anchor = size.height/2;

 
        new TouchAction(MobProp.getMobDriver())
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(0)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
        
        

	}
 	
 	public static void verticalSwipeByPercentages(double startPointPercent, double endPointPercent) {
		
		Dimension size = MobProp.getMobDriver().manage().window().getSize();
		int startPoint = (int) (size.height * startPointPercent);
		int endPoint = (int) (size.height * endPointPercent);
		
		int anchor = size.width/2;

 
        new TouchAction(MobProp.getMobDriver())
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(0)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
        
        

	}


}
