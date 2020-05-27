package test;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import Base.Base;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;

import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class MobileGestures extends Base {
	
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver  = Capabilities();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();//attribute & its value
		
		//tap
		
		TouchAction t = new TouchAction(driver);//touch action is a class to perform any touch actions in mobile
		
		WebElement ExpandableLists = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		
		t.tap(TapOptions.tapOptions().withElement(element(ExpandableLists))).perform();//whenever used touch actions, always use .perform(); & for any gestures use touch action class
		
		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
		
		WebElement people = driver.findElementByXPath("//android.widget.TextView[@text= 'People Names']");
		
		t.longPress(longPressOptions().withElement(element(people)).withDuration(ofSeconds(2))).release().perform();
		
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
		
		
	}

}
