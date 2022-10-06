package base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest bsTest;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Step 3: Screenshot method
	public static void getScreenshot() throws IOException {
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshotfilename + ".png"));
	}

	public static String captureScreenshot(WebDriver driver) throws Exception {
		Date currentdate = new Date();
		String newScreenshotName = currentdate.toString().replace(" ", "-").replace(":", "-");
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// File destination=new File("screenshot.png");
		File destination = new File(".//Report/screenshot//" + newScreenshotName + ".png");
		// getting the absolute path of the screenshot
		String filePath = destination.getAbsolutePath();
		FileUtils.copyFile(source, destination);
		return filePath;
	}

	public static void captureReport() {
		Date currentdate = new Date();
		String newReportName = currentdate.toString().replace(" ", "-").replace(":", "-");
		ExtentSparkReporter spark = new ExtentSparkReporter(".//Report//" + newReportName + ".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	public static void flushReport() {
		extent.flush();
	}
}
