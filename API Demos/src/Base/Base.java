package Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {

		File f = new File("src");//File class used set the apk location

		File fs = new File(f, "ApiDemos-debug.apk");
		
		//DesiredCapabilities is a class which takes the information in json structure & gives info to the server

		DesiredCapabilities cap = new DesiredCapabilities();//creating new object

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");//passing information through the object to the server using methods

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);//set connection to the server taking an android driver class & passed two arguments one is to establish server & to pass mobile capabilities through object 'cap' 

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

}
