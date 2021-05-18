package businessScenarios;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.javascript.host.URL;

import pageObjects.FinanceYahoo;
import utilities.commonOps;
import utilities.utils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Sanity extends utils {

	// public static WebDriver driver;
	Random rnd = new Random();

	private static String mainWindowHandle;
	private static pageObjects.FinanceYahoo Finance = new pageObjects.FinanceYahoo(driver);
	private static pageObjects.Tradair Tradair = new pageObjects.Tradair(driver);



	@BeforeClass
	public static void openBrowser() throws ParserConfigurationException, SAXException, IOException {
		initBrowser(getData("BrowserType"));
		mainWindowHandle = driver.getWindowHandle();
		initExtentReport();
		initElements();
		wait = new WebDriverWait(driver, Long.parseLong(getData("WaitTime")));

	}

	@After
	public void finalizingTest() throws ParserConfigurationException, SAXException, IOException {
		// recoveryTest(driver);
		finilizeExtentReportTest();
	}

	@AfterClass
	public static void closeBrowser() throws ParserConfigurationException, SAXException, IOException {
		finilizeExtentReport();
		// driver.quit();
	}

	@Test
	public void T01_Print_Bid_And_Offer()
			throws InterruptedException, ParserConfigurationException, SAXException, IOException, AWTException {

		
		// 1. Get the bid and offer and print them
		initTest(testName.getMethodName(), " Exercise 1 - print BID & OFFER ");
		FinanceYahoo.Print();
	}
	
	@Test
	public void T02_Login_And_Print()
			throws InterruptedException, ParserConfigurationException, SAXException, IOException, AWTException {

		
		// Login using TestUser/TestUser123
		driver.get("https://sso-uat.tradair.com/?redirect=https://demo-new.tradair.com");
		Tradair.login1(getData("URL"), getData("User"), getData("Pass"));
		
	}
	
	@Test
	public void T03_Login_And_Print()
			throws InterruptedException, ParserConfigurationException, SAXException, IOException, AWTException {

		
		// Login using TestUser/TestUser123
		
		Tradair.action(getData("URL"),getData("TestUser"),getData("TestUser123"));
		
	}

	// Rule that Handles test name for logs
	@Rule
	public TestName testName = new TestName();

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void starting(final Description description) {
			String methodName = description.getMethodName();
			String className = description.getClassName();
			className = className.substring(className.lastIndexOf('.') + 1);
			System.err.println("Starting JUnit-test: " + className + " " + methodName);
		}
	};

	public static void initElements() {
		PageFactory.initElements(driver, Finance);
		PageFactory.initElements(driver, Tradair);

		

	}

}
