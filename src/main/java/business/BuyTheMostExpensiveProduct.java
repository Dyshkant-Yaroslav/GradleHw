package business;

public class BuyTheMostExpensiveProduct {

    private FactoryPages factoryPages = new FactoryPages();

    public void buyTheMostExpensiveProduct() {
        factoryPages.getSearchResultsPage().useSortFilter();
        factoryPages.useAllWaiters();
        factoryPages.getSearchResultsPage().usePriceFilter();
        factoryPages.useAllWaiters();
        factoryPages.getHomePage().waitVisibilityOfElement(FactoryPages.DEFAULT_WAIT_TIME, factoryPages.getSearchResultsPage().getBuyButtonListOfProductsFirstButton());
        factoryPages.getSearchResultsPage().buyFirstProductFromList();
        factoryPages.useAllWaiters();
        factoryPages.getHomePage().clickOnCart();
        factoryPages.useAllWaiters();
        factoryPages.getHomePage().waitVisibilityOfElement(FactoryPages.DEFAULT_WAIT_TIME, factoryPages.getHomePage().getCartDiv());
    }

}
