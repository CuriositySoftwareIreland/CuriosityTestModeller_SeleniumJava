package Utilities.TestModeller.Recorder;

public interface RecorderPageInterface {
    public void GoToURL(String url);

    public void ClickByXpath(String xpath);

    public void EnterTextByXpath(String xpath, String text);

    public void SubmitByXpath(String xpath);

    public void SelectOptionIndexByXPath(String xpath, Integer index);

    public void EnterSearchByXPath(String xpath, String text);
}
