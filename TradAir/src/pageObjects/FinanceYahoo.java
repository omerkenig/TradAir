package pageObjects;

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
import java.io.IOException;
import javax.lang.model.element.Element;
import javax.xml.parsers.ParserConfigurationException;

public class FinanceYahoo extends utils {
	String text;
	static int bid1 = 0;
	Integer offer = 0;

	public FinanceYahoo(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "td[data-test='BID-value'] span[class='Trsdu(0.3s) ']")
	public static String Bid;

	@FindBy(how = How.CSS, using = "td[data-test='ASK-value'] span[class='Trsdu(0.3s) ']")
	public static String Offer;

	public static void Print() throws ParserConfigurationException, SAXException, IOException {
		try {
			System.out.println("The filed BID is : " + driver
					.findElement(By.cssSelector("td[data-test='BID-value'] span[class='Trsdu(0.3s) ']")).getText());

			test.log(LogStatus.PASS, "The BID text is good");
		} catch (Exception exp) {
			test.log(LogStatus.FAIL, "Problem with get text from BID , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with get text from BID filed , See Report for more Details");
		}

		try {
			System.out.println("The filed OFFER is : " + driver
					.findElement(By.cssSelector("td[data-test='ASK-value'] span[class='Trsdu(0.3s) ']")).getText());

			test.log(LogStatus.PASS, "The OFFER text is good");
		} catch (Exception exp) {
			test.log(LogStatus.FAIL, "Problem with get text from OFFER , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with get text from OFFER filed , See Report for more Details");
		}
	}

	

}
