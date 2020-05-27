package test;

import java.net.MalformedURLException;

import Base.Base;
import Base.RealDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.Preferences;

public class FirstTest extends Base {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = Capabilities();//reusing method 'capabilities' from base class
		
		HomePage h = new HomePage(driver);

		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		h.Preferences.click();
		
		Preferences p = new Preferences(driver);
		
		p.dependencies.click();
		
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();//xpath with index 2 [2]
		driver.findElementByClassName("android.widget.EditText").sendKeys("hello");//send characters
		//driver.findElementsByClassName("android.widget.Button").get(1).click();

		p.button.get(1).click();
	}

}
