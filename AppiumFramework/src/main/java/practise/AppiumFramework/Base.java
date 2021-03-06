package practise.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {

	public static AppiumDriverLocalService service;
	
	public static AndroidDriver<AndroidElement> driver;

	public AppiumDriverLocalService startServer() {
		
		boolean flag = checkIfServerIsRunning(4723);
		if (!flag) {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}

	public static void startEmulator() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}
	public static boolean checkIfServerIsRunning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {

			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {

			isServerRunning = true;

		} finally {

			serverSocket = null;
		}

		return isServerRunning;

	}

	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\practise\\AppiumFramework\\global.properties");

		Properties prop = new Properties();
		prop.load(fis);

		File aapDir = new File("src");

		File app = new File(aapDir, (String) prop.get(appName));
		

		DesiredCapabilities cap = new DesiredCapabilities();

		String device = (String) prop.get("device");
		
		//if (device.contains("emulator"))
		//{
			
			//startEmulator();
		//}

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}
	

	public static void getScreenshot(String s) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	
	}
	
}
