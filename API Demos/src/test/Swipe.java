package test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import Base.Base;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Swipe extends Base {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = Capabilities();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text = 'Views']").click();
		
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		
		driver.findElementByXPath("//android.widget.TextView[@text = '2. Inline']").click();

		driver.findElementByXPath("//*[@content-desc = '9']").click();
		
		
		TouchAction t = new TouchAction(driver);
		
		WebElement first = driver.findElementByXPath("//*[@content-desc = '15']");
		
		WebElement second = driver.findElementByXPath("//*[@content-desc = '45']");
		
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
		
		
	}

}
