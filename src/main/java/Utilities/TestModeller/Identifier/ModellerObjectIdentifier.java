package Utilities.TestModeller.Identifier;

import Utilities.TestModeller.Entities.ConnectionProfileFactory;
import Utilities.TestModeller.Entities.PageObjects.PageObjectEntity;
import Utilities.TestModeller.Services.PageObjectService;

public class ModellerObjectIdentifier {
    private int pageObjectId;

    private PageObjectEntity pageObjectEntity;

    public ModellerObjectIdentifier(int pageObjectId)
    {
        this.pageObjectId = pageObjectId;

        this.pageObjectEntity = null;
    }

    public int getPageObjectId() {
        return pageObjectId;
    }

    public void setPageObjectId(int pageObjectId) {
        this.pageObjectId = pageObjectId;
    }

    public PageObjectEntity getPageObjectEntity() {
        if (pageObjectEntity == null) {
            retrieveAndAssignPageObjectEntity();
        }

        return pageObjectEntity;
    }

    public void setPageObjectEntity(PageObjectEntity pageObjectEntity) {
        this.pageObjectEntity = pageObjectEntity;
    }

    private void retrieveAndAssignPageObjectEntity()
    {
        PageObjectService poService = new PageObjectService(ConnectionProfileFactory.getProfile());

        this.pageObjectEntity = poService.GetPageObject(this.pageObjectId);
    }
}
