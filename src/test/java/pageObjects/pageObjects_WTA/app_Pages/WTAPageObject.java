package pageObjects.pageObjects_WTA.app_Pages;

import io.appium.java_client.pagefactory.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.genericLib_Mob.MobProp;


public class WTAPageObject {



    public WTAPageObject()
    {
        PageFactory.initElements(new AppiumFieldDecorator(MobProp.getMobDriver()), this);
    }
}