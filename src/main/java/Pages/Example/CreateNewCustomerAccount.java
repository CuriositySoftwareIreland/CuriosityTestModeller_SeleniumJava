package Pages.Example;

import Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import Utilities.TestModeller.TestModellerModuleId;

// http://modeller.dev.testinsights.io/app/#!/module-collection/guid/c1953987-fa55-4f8f-bbf4-8391c6e8d57d
@TestModellerModuleId(id = "c1953987-fa55-4f8f-bbf4-8391c6e8d57d")
public class CreateNewCustomerAccount extends PageBase {

    public CreateNewCustomerAccount(WebDriver driver) {
        super(driver);
    }

    private By CreateAccountElem = By.xpath("/html/body/div[1]/main/div[3]/div/form/div/div[1]/button/span");

    private By Confirm_PasswordElem = By.xpath("//INPUT[@name='password_confirmation']");

    private By PasswordElem = By.xpath("//*[@id='password']");

    private By EmailElem = By.xpath("//*[@id='email_address']");

    private By Last_NameElem = By.xpath("//INPUT[@name='lastname']");

    private By First_NameElem = By.xpath("//INPUT[@name='firstname']");

    private String pageURL = "https://magento.nublue.co.uk/customer/account/create/";

    public void GoToUrl() {
        m_Driver.get(pageURL);
    }

    public void AssertURL() {
        String currentUrl = m_Driver.getCurrentUrl();
        if (!currentUrl.equals(pageURL)) {
            Assert.fail("Expecting URL - " + pageURL + " Found " + currentUrl);
        }
    }

    /**
     * @name CreateAccount
     */
    public void Click_CreateAccount() {
        WebElement elem = getWebElement(CreateAccountElem);
        if (elem == null) {
            Assert.fail("Unable to locate object: " + CreateAccountElem.toString());
        }
        elem.click();
    }

    /**
     *  @name Confirm Password
     * @param Confirm_Password [password]
     */
    public void Enter_Confirm_Password(String Confirm_Password) {
        WebElement elem = getWebElement(Confirm_PasswordElem);
        if (elem == null) {
            Assert.fail("Unable to locate object: " + Confirm_PasswordElem.toString());
        }
        elem.sendKeys(Confirm_Password);
    }

    /**
     *  @name Password
     * @param Password [password]
     */
    public void Enter_Password(String Password) {
        WebElement elem = getWebElement(PasswordElem);
        if (elem == null) {
            Assert.fail("Unable to locate object: " + PasswordElem.toString());
        }
        elem.sendKeys(Password);
    }

    /**
     *  @name Email
     * @param Email [text]
     */
    public void Enter_Email(String Email) {
        WebElement elem = getWebElement(EmailElem);
        if (elem == null) {
            Assert.fail("Unable to locate object: " + EmailElem.toString());
        }
        elem.sendKeys(Email);
    }

    /**
     *  @name Last Name
     * @param Last_Name [lastname]
     */
    public void Enter_Last_Name(String Last_Name) {
        WebElement elem = getWebElement(Last_NameElem);
        if (elem == null) {
            Assert.fail("Unable to locate object: " + Last_NameElem.toString());
        }
        elem.sendKeys(Last_Name);
    }

    /**
     *  @name First Name
     * @param First_Name [firstname]
     */
    public void Enter_First_Name(String First_Name) {
        WebElement elem = getWebElement(First_NameElem);
        if (elem == null) {
            Assert.fail("Unable to locate object: " + First_NameElem.toString());
        }
        elem.sendKeys(First_Name);
    }
}
