package Pages;

import Utilities.TestModeller.Recorder.RecorderPageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericWebPageBase extends PageBase implements RecorderPageInterface {
    public GenericWebPageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    public void GoToURL(String url) {
        m_Driver.get(url);
    }

    @Override
    public void ClickByXpath(String xpath) {
        WebElement elem = getWebElement(By.xpath(xpath));

        elem.click();
    }

    @Override
    public void EnterTextByXpath(String xpath, String text) {
        WebElement elem = getWebElement(By.xpath(xpath));

        elem.sendKeys(text);
    }

    @Override
    public void SubmitByXpath(String xpath) {
        WebElement elem = getWebElement(By.xpath(xpath));

        elem.click();
    }

    @Override
    public void SelectOptionIndexByXPath(String xpath, Integer index) {
        Select dropdown = new Select(getWebElement(By.xpath(xpath)));

        dropdown.selectByIndex(index);
    }

    @Override
    public void EnterSearchByXPath(String xpath, String text) {
        WebElement elem = getWebElement(By.xpath(xpath));

        elem.sendKeys(text);

        elem.click();
    }
}
