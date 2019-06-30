package Pages;

import Utilities.TestModeller.Identifier.ObjectIdentifier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class MultiObjectPageBase extends PageBase
{
    public MultiObjectPageBase(WebDriver driver) {
        super(driver);
    }

    // Get element from a list of identifiers
    public WebElement getElement(List<ObjectIdentifier> elementIdentifiers)
    {
        // Create a hash with maintains our votes
        HashMap<WebElement, Double> noVotes = new HashMap<WebElement, Double>();

        // Loop over each identifer and calculate the votes assigned
        for(ObjectIdentifier identifer : elementIdentifiers) {
             List<WebElement> foundElements = getWebElements(identifer.getIdentifier());

             if (foundElements == null) {
                 continue;
             }

             for (WebElement foundElem : foundElements) {
                 if (!noVotes.containsKey(foundElem)) {
                     noVotes.put(foundElem, 0.0d);
                 }

                 noVotes.put(foundElem, noVotes.get(foundElem) + ((1.0d / foundElements.size()) * identifer.getConfidence()));
             }
        }

        // Return object with the most votes (note: it may return null)
        // We could also add a threshold here. E.g. must be over x certainty
        double max = 0;
        WebElement curElem = null;
        for (WebElement key : noVotes.keySet()) {
            if (max > noVotes.get(key)) {
                max = noVotes.get(key);

                curElem = key;
            }
        }

        return curElem;
    }
}
