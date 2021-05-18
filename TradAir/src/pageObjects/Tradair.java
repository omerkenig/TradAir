package pageObjects;

import org.eclipse.jetty.util.preventers.LoginConfigurationLeakPreventer;
import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;
import com.gargoylesoftware.htmlunit.javascript.host.dom.Text;
import com.relevantcodes.extentreports.LogStatus;
import utilities.extentReportManager;
import utilities.utils;
import static org.junit.Assert.fail;
import utilities.utils;

import java.awt.AWTException;
import java.io.IOException;
import javax.lang.model.element.Element;
import javax.xml.parsers.ParserConfigurationException;

public class Tradair extends utils {
	String text;
	static int bid1 = 0;
	Integer offer = 0;

	public Tradair(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "username")
	public static WebElement User;

	@FindBy(how = How.ID, using = "password")
	public static WebElement Pass;

	@FindBy(how = How.XPATH, using = "//input[@value='Log In']")
	public static WebElement Login;

	public static void login(String user, String pass) throws ParserConfigurationException, SAXException, IOException {
		try {
			User.sendKeys(user);
			Pass.sendKeys(pass);
			Login.click();
			driver.switchTo().frame("intercom-frame");

			System.out.println("The First Sell is : " + driver
					.findElement(
							By.xpath("//div[contains(@class,'marketTopOfTheBook_bottom marketTopOfTheBook_price')]"))
					.getText());
			System.out.println("The First buy is : "
					+ driver.findElement(By.xpath("(//div[@class='marketTopOfTheBook_directionTop flexContRow'])[2]"))
							.getText());

			System.out.println("The Second Sell is : " + driver
					.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]"))
					.getText());
			System.out.println("The Second buy is : " + driver
					.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/div[2]"))
					.getText());

			System.out.println("The Third Sell is : " + driver
					.findElement(By.xpath("//*[@id=\"2\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]"))
					.getText());
			System.out.println("The Third buy is : " + driver
					.findElement(By.xpath("//*[@id=\"2\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/div[2]"))
					.getText());

			System.out.println("The 4th Sell is : " + driver
					.findElement(By.xpath("//*[@id=\"3\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]"))
					.getText());
			System.out.println("The 4th buy is : " + driver
					.findElement(By.xpath("//*[@id=\"3\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/div[2]"))
					.getText());

			System.out.println("The 5th Sell is : " + driver
					.findElement(By.xpath("//*[@id=\"4\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]"))
					.getText());
			System.out.println("The 5th buy is : " + driver
					.findElement(By.xpath("//*[@id=\"4\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/div[2]"))
					.getText());

			test.log(LogStatus.PASS, "The Buy and Sell text is good");
		} catch (Exception exp) {
			test.log(LogStatus.FAIL, "Problem with Buy and Sell text , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with get text from BID filed , See Report for more Details");
		}
	}
	
	public static void login1(String URL,String user, String pass) throws ParserConfigurationException, SAXException, IOException {
		try {
			driver.get(URL);
			User.sendKeys(user);
			Pass.sendKeys(pass);
			Login.click();
			driver.switchTo().frame("intercom-frame");

			System.out.println("The First Sell is : " + driver
					.findElement(
							By.xpath("//div[contains(@class,'marketTopOfTheBook_bottom marketTopOfTheBook_price')]"))
					.getText());
			System.out.println("The First buy is : "
					+ driver.findElement(By.xpath("(//div[@class='marketTopOfTheBook_directionTop flexContRow'])[2]"))
							.getText());

			System.out.println("The Second Sell is : " + driver
					.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]"))
					.getText());
			System.out.println("The Second buy is : " + driver
					.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/div[2]"))
					.getText());

			System.out.println("The Third Sell is : " + driver
					.findElement(By.xpath("//*[@id=\"2\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]"))
					.getText());
			System.out.println("The Third buy is : " + driver
					.findElement(By.xpath("//*[@id=\"2\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/div[2]"))
					.getText());

			System.out.println("The 4th Sell is : " + driver
					.findElement(By.xpath("//*[@id=\"3\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]"))
					.getText());
			System.out.println("The 4th buy is : " + driver
					.findElement(By.xpath("//*[@id=\"3\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/div[2]"))
					.getText());

			System.out.println("The 5th Sell is : " + driver
					.findElement(By.xpath("//*[@id=\"4\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]"))
					.getText());
			System.out.println("The 5th buy is : " + driver
					.findElement(By.xpath("//*[@id=\"4\"]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/div[2]"))
					.getText());

			test.log(LogStatus.PASS, "The Buy and Sell text is good");
		} catch (Exception exp) {
			test.log(LogStatus.FAIL, "Problem with Buy and Sell text , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with get text from BID filed , See Report for more Details");
		}
	}

	public void action(String data, String data2, String data3) {
		// TODO Auto-generated method stub
		
	}
}






