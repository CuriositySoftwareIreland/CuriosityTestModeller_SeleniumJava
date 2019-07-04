package Pages.Intelligent;

import Pages.IntelligentMultObjectPageBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utilities.TestModeller.TestModellerModuleId;
import Utilities.Reports.ExtentReportManager;
import Utilities.TestModeller.Identifier.ModellerObjectIdentifier;

// http://modeller.dev.testinsights.io/app/#!/module-collection/guid/af836af0-c2af-467a-a9e2-bd80a45030f2
@TestModellerModuleId(id = "af836af0-c2af-467a-a9e2-bd80a45030f2")
public class LoginPage extends IntelligentMultObjectPageBase
{
	public LoginPage (WebDriver driver)
	{
		super(driver);
	}
	
	private ModellerObjectIdentifier CancelElem = new ModellerObjectIdentifier(100013);
	
	private ModellerObjectIdentifier LoginElem = new ModellerObjectIdentifier(100014);
	
	private ModellerObjectIdentifier pswElem = new ModellerObjectIdentifier(100015);
	
	private ModellerObjectIdentifier unameElem = new ModellerObjectIdentifier(100016);
	
	private ModellerObjectIdentifier passwordElem = new ModellerObjectIdentifier(100017);
	
	
	
		        	/**
	 * GoToUrl
     * @name GoToUrl
     */
	 	public void GoToUrl()
	{
		m_Driver.get("http://dev.testinsights.io/example.html");
		
		ExtentReportManager.passStepWithScreenshot(m_Driver, "GoToUrl - http://dev.testinsights.io/example.html");		
	}
        
	/**
	 * AssertUrl
     * @name AssertUrl
     */
	     public void AssertUrl()
    {
        String currentUrl = m_Driver.getCurrentUrl();

        if (!currentUrl.equals("http://dev.testinsights.io/example.html")) {
			String errorMessage = "Expecting URL - http://dev.testinsights.io/example.html - Found " + currentUrl;
			
            Assert.fail(errorMessage);
			
			ExtentReportManager.failStepWithScreenshot(m_Driver, errorMessage);			
        }
		
		ExtentReportManager.passStepWithScreenshot(m_Driver, "AssertUrl");		
    }
        
	/**
	 * Click_Cancel
     * @name Click_Cancel
     */
	 	public void Click_Cancel()
	{
		WebElement elem = getElement(CancelElem);

		if (elem == null) {
			String errorMessage = "Unable to locate object: " + CancelElem.toString();
			
			Assert.fail(errorMessage);
			
			ExtentReportManager.failStepWithScreenshot(m_Driver, errorMessage);			
		}
		
		elem.click();
		
		ExtentReportManager.passStepWithScreenshot(m_Driver, "Click_Cancel");
	}
        
	/**
	 * Click_Login
     * @name Click_Login
     */
	 	public void Click_Login()
	{
		WebElement elem = getElement(LoginElem);

		if (elem == null) {
			String errorMessage = "Unable to locate object: " + LoginElem.toString();
			
			Assert.fail(errorMessage);
			
			ExtentReportManager.failStepWithScreenshot(m_Driver, errorMessage);			
		}
		
		elem.click();
		
		ExtentReportManager.passStepWithScreenshot(m_Driver, "Click_Login");
	}
        
	/**
	 * Enter_psw
     * @name Enter_psw
	 * @param psw [text]      */
	 	public void Enter_psw(String psw)
	{
		WebElement elem = getElement(pswElem);

		if (elem == null) {
			String failMessage = "Unable to locate object: " + pswElem.toString();
			
			Assert.fail(failMessage);
			
			ExtentReportManager.failStepWithScreenshot(m_Driver, failMessage);
		}
		
		elem.sendKeys(psw);
		
		ExtentReportManager.passStepWithScreenshot(m_Driver, "Enter_psw");		
	}
        
	/**
	 * Enter_uname
     * @name Enter_uname
	 * @param uname [name]      */
	 	public void Enter_uname(String uname)
	{
		WebElement elem = getElement(unameElem);

		if (elem == null) {
			String failMessage = "Unable to locate object: " + unameElem.toString();
			
			Assert.fail(failMessage);
			
			ExtentReportManager.failStepWithScreenshot(m_Driver, failMessage);
		}
		
		elem.sendKeys(uname);
		
		ExtentReportManager.passStepWithScreenshot(m_Driver, "Enter_uname");		
	}
        
	/**
	 * Click_password
     * @name Click_password
     */
	 	public void Click_password()
	{
		WebElement elem = getElement(passwordElem);

		if (elem == null) {
			String errorMessage = "Unable to locate object: " + passwordElem.toString();
			
			Assert.fail(errorMessage);
			
			ExtentReportManager.failStepWithScreenshot(m_Driver, errorMessage);			
		}
		
		elem.click();
		
		ExtentReportManager.passStepWithScreenshot(m_Driver, "Click_password");
	}
	
}