package Tests;

import Utilities.CapabilityLoader;
import Utilities.Reports.ExtentReportManager;
import Utilities.TestModeller.DataResolution.RemoteDataResolver;
import Utilities.TestModeller.UseTestModellerId;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {
    /********** Replace with your own details ***********/
    protected WebDriver driver;

    public WebDriver getDriver()
    {
        return driver;
    }

    @BeforeSuite()
    public void setupReporter()
    {
        ExtentReportManager.setupReporter();

//        Only if running locally
//        RemoteDataResolver.ResolveData();
    }

    @BeforeMethod(alwaysRun = true)
    public void initDriver(Method method)
    {
        ExtentReportManager.createNewTest(method);

        driver = CapabilityLoader.createWebDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closerDriver()
    {
        driver.quit();
    }

    @AfterSuite
    public void closeReporter()
    {
        ExtentReportManager.closeReporter();
    }
}
