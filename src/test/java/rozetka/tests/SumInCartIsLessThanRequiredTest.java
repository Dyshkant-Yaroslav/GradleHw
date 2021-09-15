package rozetka.tests;

import business.BuyTheMostExpensiveProduct;
import business.FindProductsByTypeAndBrand;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumInCartIsLessThanRequiredTest extends BaseTest {


    @Test(dataProvider = "getFilterData",description = "buy the most expensive laptop")
    @Description("In that test we buy product from rozetka.ua")
    public void checkIfSumInCartIsLessThanRequired(String type, String brand, int bounds)
            throws InterruptedException {

        FindProductsByTypeAndBrand findProductsByTypeAndBrand = new FindProductsByTypeAndBrand();
        BuyTheMostExpensiveProduct buyTheMostExpensiveProduct = new BuyTheMostExpensiveProduct();

        findProductsByTypeAndBrand.findProductsByTypeAndBrand(type, brand);
        buyTheMostExpensiveProduct.buyTheMostExpensiveProduct();

        Assert.assertFalse(findProductsByTypeAndBrand.getHomePage().getSumOfProductsInCart() >= bounds
                || findProductsByTypeAndBrand.getHomePage().getSumOfProductsInCart() == 0);

    }
    @Test(description = "Failed - wrong assert))) ")
    @Description("Test that shows failed result")
    public void falseTest(){
        Assert.assertEquals(2,3);
    }

}