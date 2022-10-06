package testLayer;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.MediaEntityBuilder;
import base.BaseClass;
import pom.WindowHandlePOM;

public class WindowHandle extends BaseClass {
	Actions action;
	WindowHandlePOM wh;
	SoftAssert asrt = new SoftAssert();
	
	
	public WindowHandle() {
	// 2.Read all properties of the BaseClass
		super();
	}

	@BeforeMethod
	public void preSetup() {
		launchBrowser();
		captureReport();
		wh=new WindowHandlePOM();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		flushReport();
	}
	@Test
	public void windowHANDLE1() throws Exception {
		bsTest = extent.createTest("Window Handle", "Befis Test");
		action = new Actions(driver);
		bsTest.pass("Google", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(driver)).build());
		wh.rightClickGmailKeyPressDown();
		// switch to new tab
		wh.SwitchToNewTab();
		Thread.sleep(1000);
		bsTest.pass("Gmail", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(driver)).build());
		// switch to old tab
		wh.SwitchToOldTab();
		Thread.sleep(2000);

	}

}