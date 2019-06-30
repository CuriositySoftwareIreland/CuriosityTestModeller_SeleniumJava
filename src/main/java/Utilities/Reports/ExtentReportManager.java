package Utilities.Reports;

import Utilities.TestModeller.GetScreenShot;
import Utilities.TestModeller.UseTestModellerId;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;

public class ExtentReportManager {
    public static ExtentReports extentReport;

    public static ExtentTest extentTest;

    public static String currentTestGuid;

    public static String currentTestName;

    public static String extentDir = System.getProperty("user.dir") +"\\report\\";

    public static void setupReporter()
    {
        ExtentHtmlReporter avent = new ExtentHtmlReporter(extentDir +  "\\index.html");

        if (extentReport == null) {
            extentReport = new ExtentReports();
            extentReport.attachReporter(avent);
        }
    }

    public static void closeReporter()
    {
        extentReport.flush();
    }

    public static void createNewTest(Method method)
    {
        createNewTest(method.getName());

        currentTestName = method.getName();

        UseTestModellerId useAsTestName = method.getAnnotation(UseTestModellerId.class);
        if (useAsTestName != null) {
            String TestID = useAsTestName.testModellerGuid();
            if (TestID != null) {
                currentTestGuid = TestID;
            }
        }
    }

    public static void createNewTest(String testName)
    {
        extentTest = extentReport.createTest(testName);
    }

    public static void passStepWithScreenshot(WebDriver driver, String stepName)
    {
        extentTest.log(Status.PASS, stepName).addScreenCaptureFromBase64String(GetScreenShot.captureAsBase64(driver));//.addScreenCaptureFromBase64String(GetScreenShot.captureAsBase64(driver));
    }

    public static void failStepWithScreenshot(WebDriver driver, String stepName)
    {
        extentTest.log(Status.FAIL, stepName).addScreenCaptureFromBase64String(GetScreenShot.captureAsBase64(driver));

    }
}
