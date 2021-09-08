package rozetka.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import util.RozetkaFilter;
import util.WebdriverMultitone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class BaseTest {


    @BeforeTest
    public void set() {
        WebdriverMultitone.setProperties();
    }

    @AfterMethod
    public void close() {
        WebdriverMultitone.closeMultiDriver();
    }


    @DataProvider(name = "getFilterData", parallel = true)
    public Object[][] getFilterData() throws JAXBException {
        File file = new File("src\\main\\resources\\rozetkaFilterData.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(RozetkaFilter.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        RozetkaFilter rozetkaFilter = (RozetkaFilter) unmarshaller.unmarshal(file);
        Object[][] array = rozetkaFilter.getFilterDataList().stream()
                .map(x -> new Object[]{
                        x.getProductType(), x.getBrand(), x.getPriceBounds()
                }).toArray(Object[][]::new);
        return array;
    }

}