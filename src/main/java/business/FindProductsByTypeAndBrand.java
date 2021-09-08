package business;

import pages.HomePage;

public class FindProductsByTypeAndBrand {

    private FactoryPages factoryPages = new FactoryPages();

    public void findProductsByTypeAndBrand(String type, String brand) throws InterruptedException {
        factoryPages.getHomePage().searchByKeyword(type);
        factoryPages.getHomePage().waitReadyStatementOfElement(FactoryPages.DEFAULT_WAIT_TIME, factoryPages.getSearchResultsPage().getBrandFilterInput());
        factoryPages.getSearchResultsPage().useBrandFilterInput(brand);
        factoryPages.useAllWaiters();
        Thread.sleep(3000);
        factoryPages.getSearchResultsPage().selectFilteredBrand();
        factoryPages.useAllWaiters();
        factoryPages.useAllWaiters();
    }

    public HomePage getHomePage() {
        return factoryPages.getHomePage();
    }

}
