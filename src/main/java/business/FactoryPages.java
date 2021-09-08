package business;

import pages.HomePage;
import pages.SearchResultsPage;
import util.WebdriverMultitone;

public class FactoryPages {

    public static final int DEFAULT_WAIT_TIME = 50000;
    private HomePage homePage = new HomePage(WebdriverMultitone.getMultiDriver());
    private SearchResultsPage searchResultsPage = new SearchResultsPage(WebdriverMultitone.getMultiDriver());

    public HomePage getHomePage() {
        return homePage;
    }

    public SearchResultsPage getSearchResultsPage() {
        return searchResultsPage;
    }

    public void useAllWaiters() {
        homePage.implicitWait(DEFAULT_WAIT_TIME);
        homePage.waitForPageLoadComplete(DEFAULT_WAIT_TIME);
        homePage.loadWait(DEFAULT_WAIT_TIME);
    }

}
