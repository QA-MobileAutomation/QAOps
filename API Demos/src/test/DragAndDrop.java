package test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import Base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDrop extends Base {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = Capabilities();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByXPath("//android.widget.TextView[@text = 'Views']").click();

		driver.findElementByXPath("//android.widget.TextView[@text = 'Drag and Drop']").click();

		TouchAction t = new TouchAction(driver);

		WebElement fc = driver.findElementsByClassName("android.view.View").get(0);

		WebElement sc = driver.findElementsByClassName("android.view.View").get(1);

		t.longPress(longPressOptions().withElement(element(fc))).moveTo(element(sc)).release().perform();

	}

}
