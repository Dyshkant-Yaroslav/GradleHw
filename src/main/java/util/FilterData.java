package util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "filterData")
@XmlAccessorType(XmlAccessType.FIELD)
public class FilterData {

    private String productType;
    private String brand;
    private int priceBounds;

    public String getProductType() {
        return productType;
    }

    public String getBrand() {
        return brand;
    }

    public int getPriceBounds() {
        return priceBounds;
    }

}