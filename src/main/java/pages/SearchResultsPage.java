package pages;

import business.FactoryPages;
import elements.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='sidebar-block__inner ng-star-inserted']//input[@class='sidebar-search__input ng-untouched ng-pristine ng-valid']")
    private Input brandFilterInput;

    @FindBy(xpath = "//button[@class='buy-button goods-tile__buy-button ng-star-inserted']")
    private List<Button> buyButtonListOfProducts;

    @FindBy(xpath = "//div[@class='sidebar-block ng-star-inserted']//ul[@class='checkbox-filter ng-star-inserted'][2]//li//a")
    private List<A> listOfBrandCheckboxes;

    @FindBy(xpath = "//div[@class='sidebar-block ng-star-inserted']//ul[@class='checkbox-filter ng-star-inserted'][2]//li//a//label")
    private List<Label> listOfBrandLabel;

    @FindBy(xpath = "//rz-sort[@class='catalog-settings__sorting']//select[@class='select-css ng-untouched ng-pristine ng-valid ng-star-inserted']")
    private Select sortFilter;

    @FindBy(xpath = "//div[@class='catalog-settings']//rz-sort//select//option[@value='2: expensive']")
    private Option sortFromHighToLowPrice;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    public AbstractElement getBrandFilterInput() {
        return brandFilterInput;
    }

    public List<Button> getBuyButtonListOfProducts() {
        return buyButtonListOfProducts;
    }

    public Button getBuyButtonListOfProductsFirstButton() {
        if (getBuyButtonListOfProducts().get(0) == null) {
            waitVisibilityOfElement(FactoryPages.DEFAULT_WAIT_TIME, getBuyButtonListOfProducts().get(0));
        }
        return getBuyButtonListOfProducts().get(0);
    }


    public void useBrandFilterInput(String keyword) {
        brandFilterInput.sendKeys(keyword, Keys.ENTER);
    }

    public void selectFilteredBrand() {
        if (listOfBrandCheckboxes.get(0) == null) {
            waitVisibilityOfElement(FactoryPages.DEFAULT_WAIT_TIME, listOfBrandCheckboxes.get(0));
        }
        listOfBrandCheckboxes.get(0).click();
    }

    public void buyFirstProductFromList() {
        buyButtonListOfProducts.get(0).click();
    }

    public void useSortFilter() {
        sortFilter.click();
    }

    public void usePriceFilter() {
        sortFromHighToLowPrice.click();
    }


}