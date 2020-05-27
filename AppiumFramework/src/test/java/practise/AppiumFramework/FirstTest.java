package practise.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import practise.AppiumFramework.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFramework.HomePage;
import practise.AppiumFramework.Preferences;

public class FirstTest extends Base {

	@Test(dataProvider = "InputData" , dataProviderClass = TestData.class)

	public void launch(String Input) throws IOException, InterruptedException {

		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("ApiDemos");

		HomePage h = new HomePage(driver);

		// driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();

		h.Preferences.click();

		Preferences p = new Preferences(driver);

		p.dependencies.click();

		// driver.findElementByXPath("//android.widget.TextView[@text='3. Preference
		// dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
		// driver.findElementsByClassName("android.widget.Button").get(1).click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
		
		p.button.get(1).click();

		service.stop();
	}
	
	@BeforeTest 
	
	public void KillAllNodes() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}

}