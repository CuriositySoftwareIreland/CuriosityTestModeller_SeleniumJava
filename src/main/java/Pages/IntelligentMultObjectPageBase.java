package Pages;

import Utilities.Reports.ExtentReportManager;
import Utilities.TestModeller.ElementScanner.ElementExtractor;
import Utilities.TestModeller.Entities.ConnectionProfileFactory;
import Utilities.TestModeller.Entities.PageObjects.*;
import Utilities.TestModeller.Identifier.ModellerObjectIdentifier;
import Utilities.TestModeller.Identifier.ObjectIdentifier;
import Utilities.TestModeller.ModellerTestRunIdGenerator;
import Utilities.TestModeller.Services.PageObjectService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class IntelligentMultObjectPageBase extends PageBase {
    protected HashMap<ObjectIdentifier, PageObjectParameterEntity> objectIdentifierHash;

    private final double ObjectThreshold = 0.9f;

    public IntelligentMultObjectPageBase(WebDriver driver)
    {
        super(driver);

        objectIdentifierHash = new HashMap<ObjectIdentifier, PageObjectParameterEntity>();
    }

    // Get element from a list of identifiers
    public WebElement getElement(PageObjectEntity po, List<ObjectIdentifier> elementIdentifiers)
    {
        // Create a hash with maintains our votes
        HashMap<WebElement, Double> noVotes = new HashMap<WebElement, Double>();

        // Track the identifiers for use when tracking broken items later
        HashMap<ObjectIdentifier, List<WebElement>> identiferNodeHash = new HashMap<ObjectIdentifier, List<WebElement>>();

        // Loop over each identifer and calculate the votes assigned
        for(ObjectIdentifier identifer : elementIdentifiers) {
            List<WebElement> foundElements = getWebElements(identifer.getIdentifier());

            identiferNodeHash.put(identifer, foundElements);

            if (foundElements == null) {
                continue;
            }

            for (WebElement foundElem : foundElements) {
                if (!noVotes.containsKey(foundElem)) {
                    noVotes.put(foundElem, 0.0d);
                }

                // Ignore if < threshold
                double conf = noVotes.get(foundElem) + ((1.0d / foundElements.size()) * identifer.getConfidence());

                noVotes.put(foundElem, conf);
            }
        }

        // Return object with the most votes (note: it may return null)
        // We could also add a threshold here. E.g. must be over x certainty
        double max = 0;
        WebElement curElem = null;
        for (WebElement key : noVotes.keySet()) {
            if (noVotes.get(key) > max && noVotes.get(key) > ObjectThreshold) {
                max = noVotes.get(key);

                curElem = key;
            }
        }

        PageObjectHistoryEntity poHis = new PageObjectHistoryEntity();
        poHis.setLatestRun(new Date());
        poHis.setRunId(ModellerTestRunIdGenerator.GetRunId());
        poHis.setPageObject(po.getId());
        poHis.setTestGuid(ExtentReportManager.currentTestGuid);
        poHis.setTestName(ExtentReportManager.currentTestName);

        Boolean containsChanges = false;
        if (curElem != null) {
            // If it doesn;t find the resulting object -> we need to update it
            poHis.setPageObjectStatus(PageObjectParameterStateEnum.Active);

            for(ObjectIdentifier iden : identiferNodeHash.keySet()) {
                if (!identiferNodeHash.get(iden).contains(curElem)) {
                    updateElement(curElem, objectIdentifierHash.get(iden));

                    poHis.setPageObjectStatus(PageObjectParameterStateEnum.IntelligentPass);

                    containsChanges = true;
                } else {
                    PageObjectParameterEntity parameterEntity = objectIdentifierHash.get(iden);

                    if (!parameterEntity.getParameterState().equals(PageObjectParameterStateEnum.Active)) {
                        parameterEntity.setParameterState(PageObjectParameterStateEnum.Active);

                        containsChanges = true;
                    }
                }
            }

        } else {
            // Mark all parameters as failing
            for (ObjectIdentifier iden : elementIdentifiers) {
                objectIdentifierHash.get(iden).setParameterState(PageObjectParameterStateEnum.Fail);
            }

            // Mark as failure
            poHis.setPageObjectStatus(PageObjectParameterStateEnum.Fail);

            containsChanges = true;
        }

        // Post history
        {
            PageObjectService poService = new PageObjectService(ConnectionProfileFactory.getProfile());
            poService.AddPageObjectHistory(poHis);
        }

        // Post the page object to update the references and states
        if (containsChanges) {
            PageObjectService poService = new PageObjectService(ConnectionProfileFactory.getProfile());
            poService.UpdatePageObject(po);
        }

        return curElem;
    }

    public WebElement getElement(ModellerObjectIdentifier elementIdentifier)
    {
        // Get the object and parameters
        List<ObjectIdentifier> objectIdentifiers = new ArrayList<ObjectIdentifier>();
        for (PageObjectParameterEntity parameterEntity :  elementIdentifier.getPageObjectEntity().getParameters()) {

//            if (parameterEntity.getParamType().equals(VipAutomationSelectorEnum.TagName))
//                continue;

            // Build the parameter
            ObjectIdentifier curIdentifer = null;

            By resolvedIdentifier = ElementExtractor.GetElementIdentifierForParameter(parameterEntity);
            if (resolvedIdentifier == null) {
                continue;
            }

            curIdentifer = new ObjectIdentifier(resolvedIdentifier, parameterEntity.getConfidence());

            objectIdentifiers.add(curIdentifer);

            objectIdentifierHash.put(curIdentifer, parameterEntity);
        }

        WebElement resolvedElem = getElement(elementIdentifier.getPageObjectEntity(), objectIdentifiers);

        return resolvedElem;
    }

    // Update the element reference
    public void updateElement(WebElement elem, PageObjectParameterEntity pageObjectParameter)
    {
        // Update the page object references
        if (!ElementExtractor.updateParameter(pageObjectParameter, elem, m_Driver)) {
            // If its not able to update with a new element - Mark as inactive / failed
            pageObjectParameter.setParameterState(PageObjectParameterStateEnum.Fail);
        } else {
            // Mark as intelligent identifier which has been updated
            pageObjectParameter.setParameterState(PageObjectParameterStateEnum.IntelligentPass);
        }
    }
}
